package domain;

public class MemberVO {
	/*create table member3 (
	id varchar(100) not null,
	pwd varchar(100) not null,
	nick_name varchar(100) not null,
	reg_at datetime default current_timestamp,
	last_login datetime not null,
	primary key(id));*/
	private String id;
	private String pwd;
	private String nick_name;
	private String phone;
	private String addr;
	private String reg_at;
	private String last_login;
	
	public MemberVO() {}
	
	//login(id,pwd)
	public MemberVO(String id,String pwd) {
		this.id=id;
		this.pwd=pwd;
	}
	//join,modify(id,pwd,nick_name)
	public MemberVO(String id,String pwd,String nick_name,String phone,String addr) {
		this.id=id;
		this.pwd=pwd;
		this.nick_name=nick_name;
		this.phone=phone;
		this.addr=addr;
	}
	//list(all)
	public MemberVO(String id,String pwd,String nick_name,String phone,String addr,String reg_at,String last_login) {
		this.id=id;
		this.pwd=pwd;
		this.nick_name=nick_name;
		this.phone=phone;
		this.addr=addr;
		this.reg_at=reg_at;
		this.last_login=last_login;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public String getReg_at() {
		return reg_at;
	}

	public void setReg_at(String reg_at) {
		this.reg_at = reg_at;
	}

	public String getLast_login() {
		return last_login;
	}

	public void setLast_login(String last_login) {
		this.last_login = last_login;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}
