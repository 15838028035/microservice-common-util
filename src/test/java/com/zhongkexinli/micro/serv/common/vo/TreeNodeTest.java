package com.zhongkexinli.micro.serv.common.vo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 通用树
 *
 */
public class TreeNodeTest {

    @Test
    public void testSetChildren() {

        TreeNode treeNode = new TreeNode();
        treeNode.setId(0);
        treeNode.setParentId(0);

        List<TreeNode> children = new ArrayList<>();

        TreeNode treeNode1 = new TreeNode();
        treeNode1.setId(1);
        treeNode1.setParentId(0);

        TreeNode treeNode2 = new TreeNode();
        treeNode2.setId(2);
        treeNode2.setParentId(0);

        children.add(treeNode1);
        children.add(treeNode2);

        treeNode.setChildren(children);

        assertEquals(2,treeNode.getChildren().size());
    }

}
