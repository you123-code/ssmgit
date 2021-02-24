package org.lanqiao.entity;

public class Priv {
	/**
	 * 权限id
	 */
	private int pid;
    /**
     * 对应菜单样式
     */
	private String pclass;
	/**
	 * 对应菜单url地址
	 */
	private String purl;
	/**
	 * 对应菜单名
	 */
	private String name;
	/**
	 * 对应菜单状态
	 */
	private int state;
	
	public Priv(Integer pid) {
		this.pid = pid;
	}
	public Priv(int pid, String pclass, String purl, String name, int state) {

		this.pid = pid;
		this.pclass = pclass;
		this.purl = purl;
		this.name = name;
		this.state = state;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPclass() {
		return pclass;
	}

	public void setPclass(String pclass) {
		this.pclass = pclass;
	}

	public String getPurl() {
		return purl;
	}

	public void setPurl(String purl) {
		this.purl = purl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
}
