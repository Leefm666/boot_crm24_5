package c24.boot.core.service;

import c24.boot.common.utils.Page;
import c24.boot.core.po.Customer;

public interface CustomerService {
	public Page<Customer> findCustomerList(Integer page,Integer rows,String custName,String custSource,String custIndustry,String custLevel);
	public int createCustomer(Customer customer);
	public Customer getCustomerById(Integer id);
	public int updateCustomer(Customer customer);
	public int deleteCustomer(Integer id);
}
