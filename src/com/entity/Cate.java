package com.entity;

import java.util.ArrayList;
import java.util.List;

import com.util.VeDate;

public class Cate {
	private String cateid = "C" + VeDate.getStringId();// 生成主键编号
	private String catename;// 类型名称
	private String addtime;// 创建日期
	private String memo;// 备注
	private List<Cars> carsList = new ArrayList<Cars>();

	public List<Cars> getCarsList() {
		return carsList;
	}

	public void setCarsList(List<Cars> carsList) {
		this.carsList = carsList;
	}

	public String getCateid() {
		return cateid;
	}

	public void setCateid(String cateid) {
		this.cateid = cateid;
	}

	public String getCatename() {
		return this.catename;
	}

	public void setCatename(String catename) {
		this.catename = catename;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Cate [cateid=" + this.cateid + ", catename=" + this.catename + ", addtime=" + this.addtime + ", memo="
				+ this.memo + "]";
	}

}
