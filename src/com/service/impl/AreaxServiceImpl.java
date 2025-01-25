package com.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.AreaxDAO;
import com.entity.Areax;
import com.service.AreaxService;

@Service("areaxService")
public class AreaxServiceImpl implements AreaxService {
	@Autowired
	private AreaxDAO areaxDAO;
	@Override // 继承接口的新增 返回值0(失败),1(成功)
	public int insertAreax(Areax areax) {
		return this.areaxDAO.insertAreax(areax);
	}

	@Override // 继承接口的更新 返回值0(失败),1(成功)
	public int updateAreax(Areax areax) {
		return this.areaxDAO.updateAreax(areax);
	}

	@Override // 继承接口的删除 返回值0(失败),1(成功)
	public int deleteAreax(String areaxid) {
		return this.areaxDAO.deleteAreax(areaxid);
	}

	@Override // 继承接口的查询全部
	public List<Areax> getAllAreax() {
		return this.areaxDAO.getAllAreax();
	}

	@Override // 继承接口的按条件精确查询
	public List<Areax> getAreaxByCond(Areax areax) {
		return this.areaxDAO.getAreaxByCond(areax);
	}

	@Override // 继承接口的按条件模糊查询
	public List<Areax> getAreaxByLike(Areax areax) {
		return this.areaxDAO.getAreaxByLike(areax);
	}

	@Override // 继承接口的按主键查询 返回Entity实例
	public Areax getAreaxById(String areaxid) {
		return this.areaxDAO.getAreaxById(areaxid);
	}

}

