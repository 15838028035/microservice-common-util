package com.zhongkexinli.micro.serv.common.vo;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "layuiXtree对象实体")
public class LayuiXtree {

	@ApiModelProperty(value = "显示的值")
	private String title;
	
	@ApiModelProperty(value = "隐藏的值")
	private String value;
	
	@ApiModelProperty(value = "子节点列表")
	private List<LayuiXtree> data = new ArrayList<LayuiXtree>();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<LayuiXtree> getData() {
		return data;
	}

	public void setData(List<LayuiXtree> data) {
		this.data = data;
	}
	
	 public void add(LayuiXtree layuiXtree){
		 data.add(layuiXtree);
	 }
	
}
