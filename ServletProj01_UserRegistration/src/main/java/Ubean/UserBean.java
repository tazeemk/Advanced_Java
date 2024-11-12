package Ubean;
import java.io.*;
public class UserBean implements Serializable 
{
public UserBean() {

}
	private long roll_no;
	private String name;
	private String fname;
	private String dept;
	private String addr;
	public long getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(long roll_no) {
		this.roll_no = roll_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}
