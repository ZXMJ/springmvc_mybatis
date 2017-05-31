package com.ssm.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * <p>Title: ItemsQueryVo</p>
 * <p>Description:商品包装对象 </p>
 * <p>Company: www.com</p> 
 * @author	传智.燕青
 * @date	2015-4-13下午3:22:36
 * @version 1.0
 */
public class ItemsQueryVo {
	
	//商品信息
	private Items items;
	
	//为了系统 可扩展性，对原始生成的po进行扩展
	private ItemsCustom itemsCustom;
	//页面的list需要在包装类中定义
	private List<ItemsCustom> itemsList; 
	//页面定义的map需要在包装类中定义
	private Map<String,Object> itemsMap =new HashMap<String, Object>();
	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}

	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}

	public List<ItemsCustom> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<ItemsCustom> itemsList) {
		this.itemsList = itemsList;
	}

	public Map<String, Object> getItemsMap() {
		return itemsMap;
	}

	public void setItemsMap(Map<String, Object> itemsMap) {
		this.itemsMap = itemsMap;
	}

	
}
