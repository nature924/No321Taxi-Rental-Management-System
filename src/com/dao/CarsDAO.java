package com.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Cars;

@Repository("carsDAO") // Repository标签定义数据库连接的访问 Spring中直接
@Mapper
public interface CarsDAO {

	/**
	 * CarsDAO 接口 可以按名称直接调用cars.xml配置文件的SQL语句
	 */

	// 插入数据 调用entity包cars.xml里的insertCars配置 返回值0(失败),1(成功)
	public int insertCars(Cars cars);

	// 更新数据 调用entity包cars.xml里的updateCars配置 返回值0(失败),1(成功)
	public int updateCars(Cars cars);

	// 删除数据 调用entity包cars.xml里的deleteCars配置 返回值0(失败),1(成功)
	public int deleteCars(String carsid);

	// 查询全部数据 调用entity包cars.xml里的getAllCars配置 返回List类型的数据
	public List<Cars> getAllCars();

	public List<Cars> getCarsByNews();

	public List<Cars> getCarsByHot();

	public List<Cars> getCarsByCate(String cateid);

	// 按照Cars类里面的值精确查询 调用entity包cars.xml里的getCarsByCond配置 返回List类型的数据
	public List<Cars> getCarsByCond(Cars cars);

	// 按照Cars类里面的值模糊查询 调用entity包cars.xml里的getCarsByLike配置 返回List类型的数据
	public List<Cars> getCarsByLike(Cars cars);

	// 按主键查询表返回单一的Cars实例 调用entity包cars.xml里的getCarsById配置
	public Cars getCarsById(String carsid);

}
