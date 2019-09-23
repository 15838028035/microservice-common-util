package com.zhongkexinli.micro.serv.common.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 通用树
 *
 */
public class TreeNode {
    /**
     * ID
     */
    protected int id;

    /**
     * 父ID
     */
    protected int parentId;
    
    /**
     * 子节点列表
     */
    private List<TreeNode> children = new ArrayList<>();

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public void add(TreeNode node) {
        children.add(node);
    }
}
