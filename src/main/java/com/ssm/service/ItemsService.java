package com.ssm.service;

import java.util.List;

import com.ssm.pojo.Items;
import com.ssm.pojo.ItemsCustom;
import com.ssm.pojo.ItemsQueryVo;

public interface ItemsService {
	//查询所有商品
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	//根据id查找商品
	public Items findItemById(Integer id) throws Exception;
	//根据id修改商品信息
	public void updateItemById(Integer id,Items items) throws Exception;
}
