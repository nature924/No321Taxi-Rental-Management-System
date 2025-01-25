package com.entity;
import com.util.VeDate;
public class Orders {
	private String ordersid = "O"+VeDate.getStringId();//生成主键编号
	private String ordercode;//预约单号
	private String usersid;//用户
	private String carsid;//车辆
	private String addtime;//下单日期
	private String thestart;//开始日期
	private String theend;//结束日期
	private String total;//预计费用
	private String status;//状态
	private String memo;//备注
	private String realname;// 映射数据
	private String carsno;// 映射数据
	public String getOrdersid() { return ordersid; }
	public void setOrdersid(String ordersid) { this.ordersid = ordersid; }
	public String getOrdercode() { return this.ordercode; }
	public void setOrdercode(String ordercode) { this.ordercode = ordercode; }
	public String getUsersid() { return this.usersid; }
	public void setUsersid(String usersid) { this.usersid = usersid; }
	public String getCarsid() { return this.carsid; }
	public void setCarsid(String carsid) { this.carsid = carsid; }
	public String getAddtime() { return this.addtime; }
	public void setAddtime(String addtime) { this.addtime = addtime; }
	public String getThestart() { return this.thestart; }
	public void setThestart(String thestart) { this.thestart = thestart; }
	public String getTheend() { return this.theend; }
	public void setTheend(String theend) { this.theend = theend; }
	public String getTotal() { return this.total; }
	public void setTotal(String total) { this.total = total; }
	public String getStatus() { return this.status; }
	public void setStatus(String status) { this.status = status; }
	public String getMemo() { return this.memo; }
	public void setMemo(String memo) { this.memo = memo; }
	public String getRealname() { return this.realname; }
	public void setRealname(String realname) { this.realname = realname; }
	public String getCarsno() { return this.carsno; }
	public void setCarsno(String carsno) { this.carsno = carsno; }

// 重载方法 生成JSON类型字符串 
@Override
public String toString() {
return "Orders [ordersid="+this.ordersid+", ordercode="+this.ordercode+", usersid="+this.usersid+", carsid="+this.carsid+", addtime="+this.addtime+", thestart="+this.thestart+", theend="+this.theend+", total="+this.total+", status="+this.status+", memo="+this.memo+", realname="+this.realname+", carsno="+this.carsno+"]";
}



}




