package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Cars;

@Service("carsService")
public interface CarsService {
	// 插入数据 调用carsDAO里的insertCars配置
	public int insertCars(Cars cars);

	// 更新数据 调用carsDAO里的updateCars配置
	public int updateCars(Cars cars);

	// 删除数据 调用carsDAO里的deleteCars配置
	public int deleteCars(String carsid);

	// 查询全部数据 调用carsDAO里的getAllCars配置
	public List<Cars> getAllCars();

	public List<Cars> getCarsByNews();

	public List<Cars> getCarsByHot();

	public List<Cars> getCarsByCate(String cateid);

	// 按照Cars类里面的字段名称精确查询 调用carsDAO里的getCarsByCond配置
	public List<Cars> getCarsByCond(Cars cars);

	// 按照Cars类里面的字段名称模糊查询 调用carsDAO里的getCarsByLike配置
	public List<Cars> getCarsByLike(Cars cars);

	// 按主键查询表返回单一的Cars实例 调用carsDAO里的getCarsById配置
	public Cars getCarsById(String carsid);

}
