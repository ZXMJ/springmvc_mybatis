package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.exception.CustomException;
import com.ssm.mapper.ItemsMapper;
import com.ssm.mapper.ItemsMapperCustom;
import com.ssm.pojo.Items;
import com.ssm.pojo.ItemsCustom;
import com.ssm.pojo.ItemsQueryVo;
import com.ssm.service.ItemsService;
@Service
public class ItemsServiceImpl implements ItemsService {

	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	@Autowired
	private ItemsMapper itemsMapper;
	
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)
			throws Exception {
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}
	@Override
	public Items findItemById(Integer id) throws Exception {
			
		Items items = itemsMapper.selectByPrimaryKey(id);
		if(items==null){
			throw new CustomException("修改的商品信息不存在!");
		}
		//中间对商品信息进行业务处理
		//....
		//返回ItemsCustom
		ItemsCustom itemsCustom = null;
		//将items的属性值拷贝到itemsCustom
		if(items!=null){
			itemsCustom = new ItemsCustom();
			BeanUtils.copyProperties(items, itemsCustom);
		}		
		return itemsCustom;
	}
	
	@Override
	public void updateItemById(Integer id,Items items) throws Exception {
		//updateByPrimaryKeyWithBLOBs修改所有类型updateByPrimaryKey不能修改大文本类型
		itemsMapperCustom.updateByPrimaryKeyWithBLOBs(items);
	}
}

