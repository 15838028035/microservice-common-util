package com.zhongkexinli.micro.serv.common.util;

import java.util.ArrayList;
import java.util.List;

import com.zhongkexinli.micro.serv.common.vo.TreeNode;

/**
 * 树工具类
 */
public class TreeUtil {

    private TreeUtil() {
        // 空构造
    }

    /**
     * 两层循环实现建树
     * 
     * @param treeNodes
     *            传入的树节点列表
     * @param root
     *            根节点
     * @return 对象
     */
    public static <T extends TreeNode> List<T> bulid(List<T> treeNodes, Object root) {

        List<T> trees = new ArrayList<>();
        treeNodes.forEach(treeNode ->{
            if (root.equals(treeNode.getParentId())) {
                trees.add(treeNode);
            }

            for (T it : treeNodes) {
                if (it.getParentId() == treeNode.getId()) {
                    if (treeNode.getChildren() == null) {
                        treeNode.setChildren(new ArrayList<>());
                    }
                    treeNode.add(it);
                }
            }
            
        });
        return trees;
    }

    /**
     * 使用递归方法建树
     * 
     * @param treeNodes
     *            树节点列表
     * @param root
     *            根节点
     * @return 树形列表
     */
    public static <T extends TreeNode> List<T> buildByRecursive(List<T> treeNodes, Object root) {
        List<T> trees = new ArrayList<>();
        treeNodes.forEach(treeNode ->{
            if (root.equals(treeNode.getParentId())) {
                trees.add(findChildren(treeNode, treeNodes));
            }
        });
        
        return trees;
    }

    /**
     * 递归查找子节点
     * 
     * @param treeNodes
     *            树节点列表
     * @return 树形列表
     */
    public static <T extends TreeNode> T findChildren(T treeNode, List<T> treeNodes) {
        treeNodes.forEach(treeNodeObj ->{
            if (treeNode.getId() == treeNodeObj.getParentId()) {
                if (treeNode.getChildren() == null) {
                    treeNode.setChildren(new ArrayList<>());
                }
                treeNode.add(findChildren(treeNodeObj, treeNodes));
            }
        });
        return treeNode;
    }

}