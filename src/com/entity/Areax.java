package com.entity;
import com.util.VeDate;
public class Areax {
	private String areaxid = "A"+VeDate.getStringId();//生成主键编号
	private String areaxname;//区域名称
	private String addtime;//创建日期
	private String memo;//备注
	public String getAreaxid() { return areaxid; }
	public void setAreaxid(String areaxid) { this.areaxid = areaxid; }
	public String getAreaxname() { return this.areaxname; }
	public void setAreaxname(String areaxname) { this.areaxname = areaxname; }
	public String getAddtime() { return this.addtime; }
	public void setAddtime(String addtime) { this.addtime = addtime; }
	public String getMemo() { return this.memo; }
	public void setMemo(String memo) { this.memo = memo; }

// 重载方法 生成JSON类型字符串 
@Override
public String toString() {
return "Areax [areaxid="+this.areaxid+", areaxname="+this.areaxname+", addtime="+this.addtime+", memo="+this.memo+"]";
}



}




