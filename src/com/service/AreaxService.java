package com.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Areax;
@Service("areaxService")
public interface AreaxService {
	// 插入数据 调用areaxDAO里的insertAreax配置
	public int insertAreax(Areax areax);

	// 更新数据 调用areaxDAO里的updateAreax配置
	public int updateAreax(Areax areax);

	// 删除数据 调用areaxDAO里的deleteAreax配置
	public int deleteAreax(String areaxid);

	// 查询全部数据 调用areaxDAO里的getAllAreax配置
	public List<Areax> getAllAreax();

	// 按照Areax类里面的字段名称精确查询 调用areaxDAO里的getAreaxByCond配置
	public List<Areax> getAreaxByCond(Areax areax);

	// 按照Areax类里面的字段名称模糊查询 调用areaxDAO里的getAreaxByLike配置
	public List<Areax> getAreaxByLike(Areax areax);

	// 按主键查询表返回单一的Areax实例 调用areaxDAO里的getAreaxById配置
	public Areax getAreaxById(String areaxid);

}

