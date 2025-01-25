package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Areax;
import com.entity.Cars;
import com.entity.Cate;
import com.entity.Shops;
import com.service.AreaxService;
import com.service.CarsService;
import com.service.CateService;
import com.service.ShopsService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/cars", produces = "text/plain;charset=utf-8")
public class CarsController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private CarsService carsService;
	@Autowired
	private CateService cateService;
	@Autowired
	private AreaxService areaxService;
	@Autowired
	private ShopsService shopsService;

	// 准备添加数据
	@RequestMapping("createCars.action")
	public String createCars() {
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		List<Areax> areaxList = this.areaxService.getAllAreax();
		this.getRequest().setAttribute("areaxList", areaxList);
		List<Shops> shopsList = this.shopsService.getAllShops();
		this.getRequest().setAttribute("shopsList", shopsList);
		return "admin/addcars";
	}

	// 添加数据
	@RequestMapping("addCars.action")
	public String addCars(Cars cars) {
		cars.setAddtime(VeDate.getStringDateShort());
		cars.setHits("0");
		cars.setStatus("待租");
		this.carsService.insertCars(cars);
		return "redirect:/cars/createCars.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteCars.action")
	public String deleteCars(String id) {
		this.carsService.deleteCars(id);
		return "redirect:/cars/getAllCars.action";
	}

	// 批量删除数据
	@RequestMapping("deleteCarsByIds.action")
	public String deleteCarsByIds() {
		String[] ids = this.getRequest().getParameterValues("carsid");
		if (ids != null) {
			for (String carsid : ids) {
				this.carsService.deleteCars(carsid);
			}
		}
		return "redirect:/cars/getAllCars.action";
	}

	// 更新数据
	@RequestMapping("updateCars.action")
	public String updateCars(Cars cars) {
		this.carsService.updateCars(cars);
		return "redirect:/cars/getAllCars.action";
	}

	// 更新状态
	@RequestMapping("status.action")
	public String status(String id) {
		String status = "";
		Cars cars = this.carsService.getCarsById(id);
		if (status.equals(cars.getStatus())) {
			status = "";
		}
		cars.setStatus(status);
		this.carsService.updateCars(cars);
		return "redirect:/cars/getAllCars.action";
	}

	// 显示全部数据
	@RequestMapping("getAllCars.action")
	public String getAllCars(String number) {
		List<Cars> carsList = this.carsService.getAllCars();
		PageHelper.getUserPage(carsList, "cars", "getAllCars", 10, number, this.getRequest());
		return "admin/listcars";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryCarsByCond.action")
	public String queryCarsByCond(String cond, String name, String number) {
		Cars cars = new Cars();
		if (cond != null) {
			if ("carsno".equals(cond)) {
				cars.setCarsno(name);
			}
			if ("image".equals(cond)) {
				cars.setImage(name);
			}
			if ("price".equals(cond)) {
				cars.setPrice(name);
			}
			if ("cateid".equals(cond)) {
				cars.setCateid(name);
			}
			if ("areaxid".equals(cond)) {
				cars.setAreaxid(name);
			}
			if ("shopsid".equals(cond)) {
				cars.setShopsid(name);
			}
			if ("recommend".equals(cond)) {
				cars.setRecommend(name);
			}
			if ("special".equals(cond)) {
				cars.setSpecial(name);
			}
			if ("color".equals(cond)) {
				cars.setColor(name);
			}
			if ("workdate".equals(cond)) {
				cars.setWorkdate(name);
			}
			if ("pailiang".equals(cond)) {
				cars.setPailiang(name);
			}
			if ("youhao".equals(cond)) {
				cars.setYouhao(name);
			}
			if ("addtime".equals(cond)) {
				cars.setAddtime(name);
			}
			if ("hits".equals(cond)) {
				cars.setHits(name);
			}
			if ("status".equals(cond)) {
				cars.setStatus(name);
			}
			if ("contents".equals(cond)) {
				cars.setContents(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.carsService.getCarsByLike(cars), "cars", nameList, valueList, 10, number,
				this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querycars";
	}

	// 按主键查询数据
	@RequestMapping("getCarsById.action")
	public String getCarsById(String id) {
		Cars cars = this.carsService.getCarsById(id);
		this.getRequest().setAttribute("cars", cars);
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		List<Areax> areaxList = this.areaxService.getAllAreax();
		this.getRequest().setAttribute("areaxList", areaxList);
		List<Shops> shopsList = this.shopsService.getAllShops();
		this.getRequest().setAttribute("shopsList", shopsList);
		return "admin/editcars";
	}

	@RequestMapping("getCars.action")
	public String getCars(String id) {
		Cars cars = this.carsService.getCarsById(id);
		this.getRequest().setAttribute("cars", cars);
		return "admin/qrcode";
	}

}
