package com.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.entity.Areax;

@Repository("areaxDAO") // Repository标签定义数据库连接的访问 Spring中直接
@Mapper
public interface AreaxDAO {

	/**
* AreaxDAO 接口 可以按名称直接调用areax.xml配置文件的SQL语句
 */

	// 插入数据 调用entity包areax.xml里的insertAreax配置 返回值0(失败),1(成功)
	public int insertAreax(Areax areax);

	// 更新数据 调用entity包areax.xml里的updateAreax配置 返回值0(失败),1(成功)
	public int updateAreax(Areax areax);

	// 删除数据 调用entity包areax.xml里的deleteAreax配置 返回值0(失败),1(成功)
	public int deleteAreax(String areaxid);

	// 查询全部数据 调用entity包areax.xml里的getAllAreax配置 返回List类型的数据
	public List<Areax> getAllAreax();

	// 按照Areax类里面的值精确查询 调用entity包areax.xml里的getAreaxByCond配置 返回List类型的数据
	public List<Areax> getAreaxByCond(Areax areax);

	// 按照Areax类里面的值模糊查询 调用entity包areax.xml里的getAreaxByLike配置 返回List类型的数据
	public List<Areax> getAreaxByLike(Areax areax);

	// 按主键查询表返回单一的Areax实例 调用entity包areax.xml里的getAreaxById配置
	public Areax getAreaxById(String areaxid);

}


