package org.lanqiao.entity;

import java.util.Date;
import java.util.List;

public class Admin {

	private int id;
	private String aname;
	private String apwd;	
	private String acname;
	private String atel;
	private String aemail;
	private byte aimg;
	private String by001;
	private String by002;
	private int by003;
	private Date by004;
	private Date createtime;
    private String createuser;
    private Date updatetime;
    private String updateuser;
    
    private List<Role> lr;//该用户所有的角色
    private List<Priv> lp;//该用户的权限集合
    private String roleList;
    
    /**
	 * 提供前台页面使用el表达式可以获取角色名，如：  账单管理员，业务账号
	 * @return
	 */
	public String getLr_string() {
		String lr_string = "";
		if(lr != null) {
			for(int i = 0 ; i < lr.size() ;i++) {
				if(i == lr.size()-1)
					lr_string+=lr.get(i).getRname();
				else
					lr_string+=lr.get(i).getRname()+",";
			}
		}
		return lr_string;
	}
	
	public Admin() {
	}

	public Admin(int id, String aname, String apwd, String acname, String atel, String aemail, byte aimg, String by001,
			String by002, int by003, Date by004, Date createtime, String createuser, Date updatetime,
			String updateuser) {
		super();
		this.id = id;
		this.aname = aname;
		this.apwd = apwd;
		this.acname = acname;
		this.atel = atel;
		this.aemail = aemail;
		this.aimg = aimg;
		this.by001 = by001;
		this.by002 = by002;
		this.by003 = by003;
		this.by004 = by004;
		this.createtime = createtime;
		this.createuser = createuser;
		this.updatetime = updatetime;
		this.updateuser = updateuser;
	}

	
	public Admin(int id, String aname, String atel, String aemail) {
		this.id = id;
		this.aname = aname;
		this.atel = atel;
		this.aemail = aemail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getApwd() {
		return apwd;
	}

	public void setApwd(String apwd) {
		this.apwd = apwd;
	}

	public String getAcname() {
		return acname;
	}

	public void setAcname(String acname) {
		this.acname = acname;
	}

	public String getAtel() {
		return atel;
	}

	public void setAtel(String atel) {
		this.atel = atel;
	}

	public String getAemail() {
		return aemail;
	}

	public void setAemail(String aemail) {
		this.aemail = aemail;
	}

	public byte getAimg() {
		return aimg;
	}

	public void setAimg(byte aimg) {
		this.aimg = aimg;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getCreateuser() {
		return createuser;
	}

	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getUpdateuser() {
		return updateuser;
	}

	public void setUpdateuser(String updateuser) {
		this.updateuser = updateuser;
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

	public List<Role> getLr() {
		return lr;
	}

	public void setLr(List<Role> lr) {
		this.lr = lr;
	}

	public List<Priv> getLp() {
		return lp;
	}

	public void setLp(List<Priv> lp) {
		this.lp = lp;
	}

	public String getRoleList() {
		String roleList = "";
		List<Role> lr = this.getLr();
		if(lr != null) {
			for(Role role : lr) {
				roleList+=role.getRname()+",";
			}
		}
		/*System.out.println("Admin"+roleList);*/
		return roleList;
	}

	public void setRoleList(String roleList) {
		this.roleList = roleList;
	}
	
	
	

	@Override
	public String toString() {
		return "Admin [id=" + id + ", aname=" + aname + ", apwd=" + apwd + ", acname=" + acname + ", atel=" + atel
				+ ", aemail=" + aemail + ", aimg=" + aimg + ", by001=" + by001 + ", by002=" + by002 + ", by003=" + by003
				+ ", by004=" + by004 + ", createtime=" + createtime + ", createuser=" + createuser + ", updatetime="
				+ updatetime + ", updateuser=" + updateuser + ", lr=" + lr + ", lp=" + lp + "]";
	}
	
}
