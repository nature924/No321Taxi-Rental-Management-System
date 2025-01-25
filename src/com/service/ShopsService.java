package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Shops;
@Service("shopsService")
public interface ShopsService {
	// 插入数据 调用shopsDAO里的insertShops配置
	public int insertShops(Shops shops);

	// 更新数据 调用shopsDAO里的updateShops配置
	public int updateShops(Shops shops);

	// 删除数据 调用shopsDAO里的deleteShops配置
	public int deleteShops(String shopsid);

	// 查询全部数据 调用shopsDAO里的getAllShops配置
	public List<Shops> getAllShops();

	// 按照Shops类里面的字段名称精确查询 调用shopsDAO里的getShopsByCond配置
	public List<Shops> getShopsByCond(Shops shops);

	// 按照Shops类里面的字段名称模糊查询 调用shopsDAO里的getShopsByLike配置
	public List<Shops> getShopsByLike(Shops shops);

	// 按主键查询表返回单一的Shops实例 调用shopsDAO里的getShopsById配置
	public Shops getShopsById(String shopsid);

}

