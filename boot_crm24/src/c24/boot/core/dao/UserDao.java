package c24.boot.core.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import c24.boot.core.po.Customer;
import c24.boot.core.po.User;

public interface UserDao {
	public User findUser(@Param("usercode") String usercode,@Param("password") String password);
	public List<User> selectUserList();
	public int deleteUser(Integer id);    
    int selectCount();  
    List<User> findByPage(HashMap<String,Object> map);
    public User getUserById(Integer id);
	public int updateUser(User user);
	public int createUser(@Param("usercode") String usercode,@Param("username") String username,@Param("userpassword") String password);
}
