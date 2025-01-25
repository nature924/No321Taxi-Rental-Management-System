package com.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.CarsDAO;
import com.entity.Cars;
import com.service.CarsService;

@Service("carsService")
public class CarsServiceImpl implements CarsService {
	@Autowired
	private CarsDAO carsDAO;

	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertCars(Cars cars) {
		return this.carsDAO.insertCars(cars);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateCars(Cars cars) {
		return this.carsDAO.updateCars(cars);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteCars(String carsid) {
		return this.carsDAO.deleteCars(carsid);
	}

	@Override // 继承接口的查询全部
	public List<Cars> getAllCars() {
		return this.carsDAO.getAllCars();
	}

	@Override // 继承接口的查询全部
	public List<Cars> getCarsByNews() {
		return this.carsDAO.getCarsByNews();
	}

	@Override // 继承接口的查询全部
	public List<Cars> getCarsByHot() {
		return this.carsDAO.getCarsByHot();
	}

	@Override // 继承接口的查询全部
	public List<Cars> getCarsByCate(String cateid) {
		return this.carsDAO.getCarsByCate(cateid);
	}

	@Override // 继承接口的按条件精确查询
	public List<Cars> getCarsByCond(Cars cars) {
		return this.carsDAO.getCarsByCond(cars);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Cars> getCarsByLike(Cars cars) {
		return this.carsDAO.getCarsByLike(cars);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Cars getCarsById(String carsid) {
		return this.carsDAO.getCarsById(carsid);
	}

}
