package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Shops;

@Repository("shopsDAO") // Repository标签定义数据库连接的访问 Spring中直接
@Mapper
public interface ShopsDAO {

	/**
* ShopsDAO 接口 可以按名称直接调用shops.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包shops.xml里的insertShops配置 返回值0(失败),1(成功)
	public int insertShops(Shops shops);

	// 更新数据 调用entity包shops.xml里的updateShops配置 返回值0(失败),1(成功)
	public int updateShops(Shops shops);

	// 删除数据 调用entity包shops.xml里的deleteShops配置 返回值0(失败),1(成功)
	public int deleteShops(String shopsid);

	// 查询全部数据 调用entity包shops.xml里的getAllShops配置 返回List类型的数据
	public List<Shops> getAllShops();

	// 按照Shops类里面的值精确查询 调用entity包shops.xml里的getShopsByCond配置 返回List类型的数据
	public List<Shops> getShopsByCond(Shops shops);

	// 按照Shops类里面的值模糊查询 调用entity包shops.xml里的getShopsByLike配置 返回List类型的数据
	public List<Shops> getShopsByLike(Shops shops);

	// 按主键查询表返回单一的Shops实例 调用entity包shops.xml里的getShopsById配置
	public Shops getShopsById(String shopsid);

}


