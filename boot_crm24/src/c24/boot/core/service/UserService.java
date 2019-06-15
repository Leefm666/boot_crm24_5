package c24.boot.core.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import c24.boot.common.utils.PageBean;
import c24.boot.core.po.Customer;
import c24.boot.core.po.User;

public interface UserService {
	public User findUser(String usercode,String password);
	public int createCustomer(Customer customer);
	public List<User> selectUserList();
	public int deleteUser(Integer id);
    int selectCount();
    PageBean<User> findByPage(int currentPage);
    public User getUserById(Integer id);
	public int updateUser(User user);
	public int createUser( String usercode, String username, String password);
}
