package com.zhongkexinli.micro.serv.common.util;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.zhongkexinli.micro.serv.common.vo.TreeNode;

public class TreeUtilTest {

	@Test
	public void testBulid() {
		TreeNode treeNode1 = new TreeNode();
		treeNode1.setId(1);
		treeNode1.setParentId(0);
		
		TreeNode treeNode2 = new TreeNode();
		treeNode2.setId(2);
		treeNode2.setParentId(1);
		
		List<TreeNode> treeNodes = new ArrayList<>();
		
		treeNodes.add(treeNode1);
		treeNodes.add(treeNode2);
		
		
		TreeNode root = new TreeNode();
		root.setId(0);
		root.setParentId(0);
		
		List<TreeNode> buildTreeNodeList =  TreeUtil.bulid(treeNodes, root);
		assertTrue(buildTreeNodeList != null);
	}

	@Test
	public void buildByRecursiveTest() {
		TreeNode treeNode1 = new TreeNode();
		treeNode1.setId(1);
		treeNode1.setParentId(0);
		
		TreeNode treeNode2 = new TreeNode();
		treeNode2.setId(2);
		treeNode2.setParentId(1);
		
		List<TreeNode> treeNodes = new ArrayList<>();
		
		treeNodes.add(treeNode1);
		treeNodes.add(treeNode2);
		
		
		TreeNode root = new TreeNode();
		root.setId(0);
		root.setParentId(0);
		
		List<TreeNode> buildTreeNodeList =  TreeUtil.buildByRecursive(treeNodes, root);
		assertTrue(buildTreeNodeList != null);
	}

	@Test
	public void findChildrenTest() {
		TreeNode treeNode1 = new TreeNode();
		treeNode1.setId(1);
		treeNode1.setParentId(0);
		
		TreeNode treeNode2 = new TreeNode();
		treeNode2.setId(2);
		treeNode2.setParentId(1);
		
		List<TreeNode> treeNodes = new ArrayList<>();
		
		treeNodes.add(treeNode1);
		treeNodes.add(treeNode2);
		
		TreeNode findTreeNode = TreeUtil.findChildren(treeNode1, treeNodes);
		assertTrue(findTreeNode != null);
		assertTrue(findTreeNode.getId()==1);
		assertTrue(findTreeNode.getParentId()==0);
	}

}
