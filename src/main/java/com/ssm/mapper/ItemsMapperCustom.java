package com.ssm.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ssm.pojo.ItemsCustom;
import com.ssm.pojo.ItemsQueryVo;
@Component
public interface ItemsMapperCustom extends ItemsMapper{
	//商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;	
}