package com.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Shops;
import com.service.ShopsService;
import com.util.PageHelper;
import com.util.VeDate;
//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/shops" , produces = "text/plain;charset=utf-8")
public class ShopsController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private ShopsService shopsService;

	// 准备添加数据
	@RequestMapping("createShops.action")
	public String createShops() {
		return "admin/addshops";
	}
	// 添加数据
	@RequestMapping("addShops.action")
	public String addShops(Shops shops) {
		shops.setAddtime(VeDate.getStringDateShort());
		this.shopsService.insertShops(shops);
		return "redirect:/shops/createShops.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteShops.action")
	public String deleteShops(String id) {
		this.shopsService.deleteShops(id);
		return "redirect:/shops/getAllShops.action";
	}

	// 批量删除数据
	@RequestMapping("deleteShopsByIds.action")
	public String deleteShopsByIds() {
		String[] ids = this.getRequest().getParameterValues("shopsid");
		if (ids != null) {
			for (String shopsid : ids) {
				this.shopsService.deleteShops(shopsid);
			}
		}
		return "redirect:/shops/getAllShops.action";
	}

	// 更新数据
	@RequestMapping("updateShops.action")
	public String updateShops(Shops shops) {
		this.shopsService.updateShops(shops);
		return "redirect:/shops/getAllShops.action";
	}

	// 显示全部数据
	@RequestMapping("getAllShops.action")
	public String getAllShops(String number) {
		List<Shops> shopsList = this.shopsService.getAllShops();
		PageHelper.getUserPage(shopsList, "shops", "getAllShops", 10, number, this.getRequest());
		return "admin/listshops";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryShopsByCond.action")
	public String queryShopsByCond(String cond, String name, String number) {
		Shops shops = new Shops();
		if(cond != null){
			if ("shopsname".equals(cond)) {
				shops.setShopsname(name);
			}
			if ("manager".equals(cond)) {
				shops.setManager(name);
			}
			if ("addtime".equals(cond)) {
				shops.setAddtime(name);
			}
			if ("contact".equals(cond)) {
				shops.setContact(name);
			}
			if ("address".equals(cond)) {
				shops.setAddress(name);
			}
			if ("memo".equals(cond)) {
				shops.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.shopsService.getShopsByLike(shops), "shops", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryshops";
	}

	// 按主键查询数据
	@RequestMapping("getShopsById.action")
	public String getShopsById(String id) {
		Shops shops = this.shopsService.getShopsById(id);
		this.getRequest().setAttribute("shops", shops);
		return "admin/editshops";
	}


}
