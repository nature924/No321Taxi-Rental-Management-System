package com.entity;
import com.util.VeDate;
public class Cars {
	private String carsid = "C"+VeDate.getStringId();//生成主键编号
	private String carsno;//车牌号
	private String image;//图片
	private String price;//出租价格
	private String cateid;//车辆类型
	private String areaxid;//所在区域
	private String shopsid;//所属网点
	private String recommend;//是否推荐
	private String special;//是否特价
	private String color;//车辆颜色
	private String workdate;//上牌日期
	private String pailiang;//排量
	private String youhao;//油耗
	private String addtime;//上架日期
	private String hits;//点击数
	private String status;//车辆状态
	private String contents;//车辆介绍
	private String catename;// 映射数据
	private String areaxname;// 映射数据
	private String shopsname;// 映射数据
	public String getCarsid() { return carsid; }
	public void setCarsid(String carsid) { this.carsid = carsid; }
	public String getCarsno() { return this.carsno; }
	public void setCarsno(String carsno) { this.carsno = carsno; }
	public String getImage() { return this.image; }
	public void setImage(String image) { this.image = image; }
	public String getPrice() { return this.price; }
	public void setPrice(String price) { this.price = price; }
	public String getCateid() { return this.cateid; }
	public void setCateid(String cateid) { this.cateid = cateid; }
	public String getAreaxid() { return this.areaxid; }
	public void setAreaxid(String areaxid) { this.areaxid = areaxid; }
	public String getShopsid() { return this.shopsid; }
	public void setShopsid(String shopsid) { this.shopsid = shopsid; }
	public String getRecommend() { return this.recommend; }
	public void setRecommend(String recommend) { this.recommend = recommend; }
	public String getSpecial() { return this.special; }
	public void setSpecial(String special) { this.special = special; }
	public String getColor() { return this.color; }
	public void setColor(String color) { this.color = color; }
	public String getWorkdate() { return this.workdate; }
	public void setWorkdate(String workdate) { this.workdate = workdate; }
	public String getPailiang() { return this.pailiang; }
	public void setPailiang(String pailiang) { this.pailiang = pailiang; }
	public String getYouhao() { return this.youhao; }
	public void setYouhao(String youhao) { this.youhao = youhao; }
	public String getAddtime() { return this.addtime; }
	public void setAddtime(String addtime) { this.addtime = addtime; }
	public String getHits() { return this.hits; }
	public void setHits(String hits) { this.hits = hits; }
	public String getStatus() { return this.status; }
	public void setStatus(String status) { this.status = status; }
	public String getContents() { return this.contents; }
	public void setContents(String contents) { this.contents = contents; }
	public String getCatename() { return this.catename; }
	public void setCatename(String catename) { this.catename = catename; }
	public String getAreaxname() { return this.areaxname; }
	public void setAreaxname(String areaxname) { this.areaxname = areaxname; }
	public String getShopsname() { return this.shopsname; }
	public void setShopsname(String shopsname) { this.shopsname = shopsname; }

// 重载方法 生成JSON类型字符串 
@Override
public String toString() {
return "Cars [carsid="+this.carsid+", carsno="+this.carsno+", image="+this.image+", price="+this.price+", cateid="+this.cateid+", areaxid="+this.areaxid+", shopsid="+this.shopsid+", recommend="+this.recommend+", special="+this.special+", color="+this.color+", workdate="+this.workdate+", pailiang="+this.pailiang+", youhao="+this.youhao+", addtime="+this.addtime+", hits="+this.hits+", status="+this.status+", contents="+this.contents+", catename="+this.catename+", areaxname="+this.areaxname+", shopsname="+this.shopsname+"]";
}



}




