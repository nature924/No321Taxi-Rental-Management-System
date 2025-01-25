package com.entity;
import com.util.VeDate;
public class Shops {
	private String shopsid = "S"+VeDate.getStringId();//生成主键编号
	private String shopsname;//网点名称
	private String manager;//负责人
	private String addtime;//创建日期
	private String contact;//联系方式
	private String address;//联系地址
	private String memo;//备注
	public String getShopsid() { return shopsid; }
	public void setShopsid(String shopsid) { this.shopsid = shopsid; }
	public String getShopsname() { return this.shopsname; }
	public void setShopsname(String shopsname) { this.shopsname = shopsname; }
	public String getManager() { return this.manager; }
	public void setManager(String manager) { this.manager = manager; }
	public String getAddtime() { return this.addtime; }
	public void setAddtime(String addtime) { this.addtime = addtime; }
	public String getContact() { return this.contact; }
	public void setContact(String contact) { this.contact = contact; }
	public String getAddress() { return this.address; }
	public void setAddress(String address) { this.address = address; }
	public String getMemo() { return this.memo; }
	public void setMemo(String memo) { this.memo = memo; }

// 重载方法 生成JSON类型字符串 
@Override
public String toString() {
return "Shops [shopsid="+this.shopsid+", shopsname="+this.shopsname+", manager="+this.manager+", addtime="+this.addtime+", contact="+this.contact+", address="+this.address+", memo="+this.memo+"]";
}



}




