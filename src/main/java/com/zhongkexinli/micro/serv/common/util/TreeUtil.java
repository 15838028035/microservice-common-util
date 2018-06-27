package com.zhongkexinli.micro.serv.common.util;


import java.util.ArrayList;
import java.util.List;

import com.zhongkexinli.micro.serv.common.vo.TreeNode;

/**
 */
public class TreeUtil{
  /**
   * 两层循环实现建树
   * 
   * @param treeNodes 传入的树节点列表
   * @return
   */
  public static <T extends TreeNode> List<T> bulid(List<T> treeNodes,Object root) {

    List<T> trees = new ArrayList<T>();

    for (T treeNode : treeNodes) {

      if (root.equals(treeNode.getParentId())) {
        trees.add(treeNode);
      }

      for (T it : treeNodes) {
        if (it.getParentId() == treeNode.getId()) {
          if (treeNode.getChildren() == null) {
            treeNode.setChildren(new ArrayList<TreeNode>());
          }
          treeNode.add(it);
        }
      }
    }
    return trees;
  }
  
  /**
   * 两层循环实现建树
   * 
   * @param treeNodes 传入的树节点列表
   * @return
   */
 /* public static <T extends LayuiXtree> List<T> bulidXtree(List<T> treeNodes,Object root) {

    List<T> trees = new ArrayList<T>();

    for (T treeNode : treeNodes) {

      if (String.valueOf(root).equals(treeNode.getParentId())) {
        trees.add(treeNode);
      }

      for (T it : treeNodes) {
        if (it.getParentId()!=null && it.getParentId().equals(treeNode.getValue())) {
          if (treeNode.getData() == null) {
            treeNode.setData(new ArrayList<LayuiXtree>());
          }
          treeNode.add(it);
        }
      }
    }
    return trees;
  }*/

  /**
   * 使用递归方法建树
   * 
   * @param treeNodes
   * @return
   */
  public static <T extends TreeNode> List<T> buildByRecursive(List<T> treeNodes,Object root) {
    List<T> trees = new ArrayList<T>();
    for (T treeNode : treeNodes) {
      if (root.equals(treeNode.getParentId())) {
        trees.add(findChildren(treeNode, treeNodes));
      }
    }
    return trees;
  }

  /**
   * 递归查找子节点
   * 
   * @param treeNodes
   * @return
   */
  public static <T extends TreeNode> T findChildren(T treeNode, List<T> treeNodes) {
    for (T it : treeNodes) {
      if (treeNode.getId() == it.getParentId()) {
        if (treeNode.getChildren() == null) {
          treeNode.setChildren(new ArrayList<TreeNode>());
        }
        treeNode.add(findChildren(it, treeNodes));
      }
    }
    return treeNode;
  }

}