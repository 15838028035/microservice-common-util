package com.zhongkexinli.micro.serv.common.util;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class EnumerationAsStreamUtil {

	private EnumerationAsStreamUtil() {
		// 空构造
	}
	
	public static <T> Stream<T> enumerationAsStream(Enumeration<T> e) {
	    return StreamSupport.stream(
	        Spliterators.spliteratorUnknownSize(
	            new Iterator<T>() {
	                public T next() {
	                    return e.nextElement();
	                }
	                public boolean hasNext() {
	                    return e.hasMoreElements();
	                }
	                
	                @Override
	                public void forEachRemaining(Consumer<? super T> action) {
	                    while(e.hasMoreElements()) action.accept(e.nextElement());
	                }
	            },
	            Spliterator.ORDERED), false);
	}
}
