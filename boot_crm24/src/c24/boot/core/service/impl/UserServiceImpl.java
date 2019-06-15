package c24.boot.core.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import c24.boot.common.utils.PageBean;
import c24.boot.core.dao.CustomerDao;
import c24.boot.core.dao.UserDao;
import c24.boot.core.po.Customer;
import c24.boot.core.po.User;
import c24.boot.core.service.UserService;
@Service("USerService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	private CustomerDao  customerDao;
	
	public User findUser(String usercode, String password) {
		User user= this.userDao.findUser(usercode, password);
		return user;
	}

	@Override
	public int createCustomer(Customer customer) {
	    return customerDao.createCustomer(customer);
	}

	@Override
	public List<User> selectUserList() {
		
		return userDao.selectUserList();
	}

	@Override
	public int deleteUser(Integer id) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(id);
	}

	@Override
	public int selectCount() {
		return userDao.selectCount();
	}

	@Override
	public PageBean<User> findByPage(int currentPage) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		PageBean<User> pageBean = new PageBean<User>();
		
	    //封装当前页数
        pageBean.setCurrPage(currentPage);
        
		//每页显示的数据
		int pageSize=1;
		pageBean.setPageSize(pageSize);
		
		//封装总记录数
		int totalCount = userDao.selectCount();
		pageBean.setTotalCount(totalCount);
		
		//封装总页数
		double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);//向上取整
        pageBean.setTotalPage(num.intValue());
      
		map.put("start",(currentPage-1)*pageSize);
		map.put("size", pageBean.getPageSize());
		//封装每页显示的数据
		List<User> lists = userDao.findByPage(map);
		pageBean.setLists(lists);
		
		return pageBean;
	}

	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
       User user=userDao.getUserById(id);
		
		return user;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}

	@Override
	public int createUser(String usercode, String username, String password) {
		// TODO Auto-generated method stub
		return userDao.createUser(usercode, username,password);
		
	}
	
}
