package com.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Areax;
import com.service.AreaxService;
import com.util.PageHelper;
import com.util.VeDate;
//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/areax" , produces = "text/plain;charset=utf-8")
public class AreaxController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private AreaxService areaxService;

	// 准备添加数据
	@RequestMapping("createAreax.action")
	public String createAreax() {
		return "admin/addareax";
	}
	// 添加数据
	@RequestMapping("addAreax.action")
	public String addAreax(Areax areax) {
		areax.setAddtime(VeDate.getStringDateShort());
		this.areaxService.insertAreax(areax);
		return "redirect:/areax/createAreax.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteAreax.action")
	public String deleteAreax(String id) {
		this.areaxService.deleteAreax(id);
		return "redirect:/areax/getAllAreax.action";
	}

	// 批量删除数据
	@RequestMapping("deleteAreaxByIds.action")
	public String deleteAreaxByIds() {
		String[] ids = this.getRequest().getParameterValues("areaxid");
		if (ids != null) {
			for (String areaxid : ids) {
				this.areaxService.deleteAreax(areaxid);
			}
		}
		return "redirect:/areax/getAllAreax.action";
	}

	// 更新数据
	@RequestMapping("updateAreax.action")
	public String updateAreax(Areax areax) {
		this.areaxService.updateAreax(areax);
		return "redirect:/areax/getAllAreax.action";
	}

	// 显示全部数据
	@RequestMapping("getAllAreax.action")
	public String getAllAreax(String number) {
		List<Areax> areaxList = this.areaxService.getAllAreax();
		PageHelper.getUserPage(areaxList, "areax", "getAllAreax", 10, number, this.getRequest());
		return "admin/listareax";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryAreaxByCond.action")
	public String queryAreaxByCond(String cond, String name, String number) {
		Areax areax = new Areax();
		if(cond != null){
			if ("areaxname".equals(cond)) {
				areax.setAreaxname(name);
			}
			if ("addtime".equals(cond)) {
				areax.setAddtime(name);
			}
			if ("memo".equals(cond)) {
				areax.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.areaxService.getAreaxByLike(areax), "areax", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryareax";
	}

	// 按主键查询数据
	@RequestMapping("getAreaxById.action")
	public String getAreaxById(String id) {
		Areax areax = this.areaxService.getAreaxById(id);
		this.getRequest().setAttribute("areax", areax);
		return "admin/editareax";
	}


}
