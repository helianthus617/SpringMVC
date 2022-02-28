package com.atguigu.bean;

public class Press {
	String city;
	String province;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	@Override
	public String toString() {
		return "press [city=" + city + ", province=" + province + "]";
	}
	public Press() {
		super();
	}

	public Press(String city, String province) {
		super();
		this.city = city;
		this.province = province;
	}
	
}
