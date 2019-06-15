package c24.boot.core.po;
import java.io.Serializable;
/**
 * 鐢ㄦ埛鎸佷箙鍖栫被
 */
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer user_id;      //鐢ㄦ埛id 
	private String user_code;     //鐢ㄦ埛璐﹀彿
	private String user_name;     //鐢ㄦ埛鍚嶇О
	private String user_password; //鐢ㄦ埛瀵嗙爜
	private Integer user_state;   //鐢ㄦ埛鐘舵�
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public Integer getUser_state() {
		return user_state;
	}
	public void setUser_state(Integer user_state) {
		this.user_state = user_state;
	}
}
