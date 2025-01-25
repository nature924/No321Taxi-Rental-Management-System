package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.ShopsDAO;
import com.entity.Shops;
import com.service.ShopsService;

@Service("shopsService")
public class ShopsServiceImpl implements ShopsService {
	@Autowired
	private ShopsDAO shopsDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertShops(Shops shops) {
		return this.shopsDAO.insertShops(shops);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateShops(Shops shops) {
		return this.shopsDAO.updateShops(shops);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteShops(String shopsid) {
		return this.shopsDAO.deleteShops(shopsid);
	}

	@Override // 继承接口的查询全部
	public List<Shops> getAllShops() {
		return this.shopsDAO.getAllShops();
	}

	@Override // 继承接口的按条件精确查询
	public List<Shops> getShopsByCond(Shops shops) {
		return this.shopsDAO.getShopsByCond(shops);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Shops> getShopsByLike(Shops shops) {
		return this.shopsDAO.getShopsByLike(shops);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Shops getShopsById(String shopsid) {
		return this.shopsDAO.getShopsById(shopsid);
	}

}

