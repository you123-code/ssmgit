package org.lanqiao.entity;

import java.util.Date;
import java.util.List;

public class Role {

	private int id;
	private String rname;
	private String by001;
	private String by002;
	private int by003;
	private Date by004;
	private String createuser;
	private Date createtime;
	private String updateuser;
	private Date updatetime;
	
	private List<Priv> lp;

	public Role(Integer id) {
		this.id=id;
	}

	public String getPrivs() {
		String s = "";
		if(lp != null) {
			for(Priv p : lp) {
				s+=p.getName()+",";
			}
		}
		return s;
	}
	public List<Priv> getLp() {
		return lp;
	}

	public void setLp(List<Priv> lp) {
		this.lp = lp;
	}
	
	public Role() {
	}

	public Role(int id, String rname, String by001, String by002, int by003, Date by004, String createuser,
			Date createtime, String updateuser, Date updatetime) {
		this.id = id;
		this.rname = rname;
		this.by001 = by001;
		this.by002 = by002;
		this.by003 = by003;
		this.by004 = by004;
		this.createuser = createuser;
		this.createtime = createtime;
		this.updateuser = updateuser;
		this.updatetime = updatetime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getCreateuser() {
		return createuser;
	}

	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getUpdateuser() {
		return updateuser;
	}

	public void setUpdateuser(String updateuser) {
		this.updateuser = updateuser;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getBy001() {
		return by001;
	}

	public void setBy001(String by001) {
		this.by001 = by001;
	}

	public String getBy002() {
		return by002;
	}

	public void setBy002(String by002) {
		this.by002 = by002;
	}

	public int getBy003() {
		return by003;
	}

	public void setBy003(int by003) {
		this.by003 = by003;
	}

	public Date getBy004() {
		return by004;
	}

	public void setBy004(Date by004) {
		this.by004 = by004;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", rname=" + rname + ", by001=" + by001 + ", by002=" + by002 + ", by003=" + by003
				+ ", by004=" + by004 + ", createuser=" + createuser + ", createtime=" + createtime + ", updateuser="
				+ updateuser + ", updatetime=" + updatetime + ", lp=" + lp + "]";
	}
	
	
}
