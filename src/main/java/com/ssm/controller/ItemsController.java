package com.ssm.controller;


import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.controller.validation.ValidGroup1;
import com.ssm.pojo.Items;
import com.ssm.pojo.ItemsCustom;
import com.ssm.pojo.ItemsQueryVo;
import com.ssm.service.ItemsService;
/**
 * Title: ItemsController.java
 * Description:
 * Company: 
 * @author 范保申
 * @date 2016-4-5上午11:49:47
 * @version 1.0
 */

@Controller
@RequestMapping("/items")
public class ItemsController {

	@Autowired
	private ItemsService itemsService;
	/**
	 * <p>Title: queryItems</p>
 	 * <p>Description:显示所有商品</p>
	 * <p>Company: </p> 
	 * @author 范保申
	 * @date 2016-4-5
	 */

	@RequestMapping("/queryItems")
	public ModelAndView queryItems() throws Exception{
		ModelAndView mav=new ModelAndView();
		List<ItemsCustom> itemsList= itemsService.findItemsList(null);
		mav.addObject("itemsList", itemsList);                                                                      
		mav.setViewName("items/itemsList");
		return mav; 
	}
	//测试页面数组参数绑定---跳到页面
	@RequestMapping("/queryItems2")
	public String queryItems2(Model model) throws Exception{
		List<ItemsCustom> itemsList= itemsService.findItemsList(null);
		model.addAttribute("itemsList",itemsList);                                                          
		return "items/itemsArray"; 
	}
	/**
	 * 
	* <p>Title: editItem</p>
	* <p>Description:进入修改商品页面</p>
	* <p>Company: </p> 
	* @author 范保申
	* @date 2016-4-5
	* 当页面的参数name和controller参数的名字不一样时如何
	* @RequestParam里边指定request传入参数名称和形参进行绑定。 
	* 通过required属性指定参数是否必须要传入
	* 通过defaultValue可以设置默认值，如果id参数没有传入，将默认值和形参绑定。
	*
	 */
	@RequestMapping("/editItem")
	public ModelAndView editItem(@RequestParam(value = "id", required = true)Integer items_id) throws Exception{
		ModelAndView mav=new ModelAndView();
		Items items=new ItemsCustom();
		items=itemsService.findItemById(items_id);
		mav.addObject("items",items);
		mav.setViewName("items/editItems");
		return mav;
	}
	//测试页面数组参数绑定---接受页面传过来的值
	@RequestMapping("/deteleItems")
	public String deteleItems(Integer items_id[]) throws Exception{
		
		return "success";
	}
	/**
	* 
	* <p>Title: editItemsSubmit</p>
	* <p>Description:商品修改编辑页面</p>
	* <p>Company: </p> 
	* @author 范保申
	* @date 2016-4-5
	* 在需要校验的pojo前边添加@Validated，在需要校验的pojo后边添加BindingResult
	* bindingResult接收校验出错信息
	* 注意：@Validated和BindingResult bindingResult是配对出现，并且形参顺序是固定的（一前一后）。
	* value={ValidGroup1.class}指定使用ValidGroup1分组的 校验
	* @ModelAttribute可以指定pojo回显到页面在request中的key
	* items_pic 接收商品图片
	*/
	@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit(Model model,Integer id,@Validated(value=ValidGroup1.class) Items items,BindingResult bindingResult,MultipartFile items_pic)throws Exception{
		// 获取校验错误信息
				if (bindingResult.hasErrors()) {
					// 输出错误信息
					List<ObjectError> allErrors = bindingResult.getAllErrors();

					/*for (ObjectError objectError : allErrors) {
						// 输出错误信息
						System.out.println(objectError.getDefaultMessage());

					}*/
					// 将错误信息传到页面
					model.addAttribute("allErrors", allErrors);
					
					
					//可以直接使用model将提交pojo回显到页面
					model.addAttribute("items", items);
					
					// 出错重新到商品修改页面
					return "items/editItems";
				}
				//原始名称
				String originalFilename = items_pic.getOriginalFilename();
				//上传图片
				if(items_pic!=null && originalFilename!=null && originalFilename.length()>0){
					
					//存储图片的物理路径
					String pic_path = "E:\\Pictures\\";
					
					
					//新的图片名称
					String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
					//新图片
					File newFile = new File(pic_path+newFileName);
					
					//将内存中的数据写入磁盘
					items_pic.transferTo(newFile);
					
					//将新图片名称写到itemsCustom中
					items.setPic(newFileName);
					
				}
				
			itemsService.updateItemById(id, items);
		return "success";		
	}
	
	@RequestMapping("/editItemsSubmit2")
	public String editItemsSubmit2(Integer id,Items items)throws Exception{
			itemsService.updateItemById(id, items);
		return  "success";		
	}
	
	//测试页面List参数绑定---跳到页面
	@RequestMapping("/editListItems")
	public String editListItems(Model model) throws Exception{
		List<ItemsCustom> itemsList= itemsService.findItemsList(null);
		model.addAttribute("itemsList",itemsList);                                                          
		return "items/editListItems"; 
	}
	//测试页面List参数绑定---接受页面传过来的值
	@RequestMapping("/editListItemsSubmit")
	public String editListItemsSubmit(ItemsQueryVo itemsQueryVo)throws Exception{
		
		return "success";
		
	}
	
	//测试页面Map参数绑定---跳到页面
		@RequestMapping("/editMapItems")
		public String editMapItems(Model model) throws Exception{
			List<ItemsCustom> itemsList= itemsService.findItemsList(null);
			model.addAttribute("itemsList",itemsList);                                                          
			return "items/editMapItems"; 
		}
		//测试页面Map参数绑定---接受页面传过来的值
		@RequestMapping("/editMapItemsSubmit")
		public String editMapItemsSubmit(ItemsQueryVo itemsQueryVo)throws Exception{
			
			return "success";
			
		}
		
		// 商品分类
		//itemtypes表示最终将方法返回值放在request中的key
		@ModelAttribute("itemtypes")
		public Map<String, String> getItemTypes() throws Exception{

			Map<String, String> itemTypes = new HashMap<String, String>();
			itemTypes.put("101", "数码");
			itemTypes.put("102", "母婴");

			return itemTypes;
		}
		
		
}
