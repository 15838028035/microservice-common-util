package com.zhongkexinli.micro.serv.common.vo;
/**
 * 
 * @author malingbing
 *
 */
public class TreeBean {
	private Integer id;// id
	private Integer pId;// 父级pid
	private String name;//节点名称
	private boolean isParent;//是否是父级
	private boolean isLeaf;//是否是子集
	private String url;//lianjie
	private boolean open;//是否打开
	private boolean choiseRequir = false;//是否打开
	private String type = "normal";
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isParent() {
		return isParent;
	}
	public void setParent(boolean isParent) {
		this.isParent = isParent;
	}
	public boolean isLeaf() {
		return isLeaf;
	}
	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public boolean isChoiseRequir() {
		return choiseRequir;
	}
	public void setChoiseRequir(boolean choiseRequir) {
		this.choiseRequir = choiseRequir;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
