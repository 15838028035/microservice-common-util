package com.zhongkexinli.micro.serv.common.vo;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TreeNodeTest {

	@Test
	public void testSetChildren() {
		
		TreeNode treeNode = new TreeNode();
		treeNode.setId(0);
		treeNode.setParentId(0);
		
		List<TreeNode> children = new ArrayList<TreeNode>();
		
		TreeNode treeNode1 = new TreeNode();
		treeNode1.setId(1);
		treeNode1.setParentId(0);
		
		TreeNode treeNode2 = new TreeNode();
		treeNode2.setId(2);
		treeNode2.setParentId(0);
		
		children.add(treeNode1);
		children.add(treeNode2);
		
		treeNode.setChildren(children);
		
		assertTrue(treeNode.getChildren().size()==2);
	}

}
