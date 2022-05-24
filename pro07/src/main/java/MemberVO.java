//database table 같은구조+getter/setter
public class MemberVO {
	private String id;
	private String pwd;
	private String name;
	private String mobile;
	private String joinDate;
	public MemberVO() {
	}
	public String getId() {
		return id;
	}
	public String getPwd() {
		return pwd;
	}
	public String getName() {
		return name;
	}
	public String getMobile() {
		return mobile;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	
}
