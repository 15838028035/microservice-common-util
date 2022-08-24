package com.zhongkexinli.micro.serv.common.util;


import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.IntFunction;

/**
 * 
 */
public class ForEachUtils {
    
    private ForEachUtils() {
        // 空实现
    }
    
    /**
     * 
     * @param <T>
     * @param startIndex 开始遍历的索引
     * @param elements 集合
     * @param action 
     */
    public static <T> void forEach(int startIndex,Iterable<? extends T> elements, BiConsumer<Integer, ? super T> action) {
        Objects.requireNonNull(elements);
        Objects.requireNonNull(action);
        if(startIndex < 0) {
            startIndex = 0;
        }
        int index = 0;
        for (T element : elements) {
            index++;
            if(index <= startIndex) {
                continue;
            }
            
            action.accept(index-1, element);
        }
    }
    
    public static void foreach(List<?> list, int batchSize, Consumer<List<?>> consumer) {
        for (int i = 0; i < list.size(); i += batchSize) {
            consumer.accept(list.subList(i, Math.min(list.size(), i + batchSize)));
        }
    }

    public static void foreach(IntFunction<Integer> function) {
        foreach(0, function);
    }

    public static void foreach(int start, IntFunction<Integer> function) {
        for (int end = start + 1; start < end; start++) {
            end = function.apply(start);
        }
    }
}

