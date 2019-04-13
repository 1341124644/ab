package com.qianfeng.service.impl;

import java.util.List;

import com.qianfeng.dao.EmployeeDao;
import com.qianfeng.dao.impl.EmployeeDaoImpl;
import com.qianfeng.entity.Employee;
import com.qianfeng.service.EmployeeService;

public class EmployeeServieImpl implements EmployeeService {
	// 数据访问层对象
	private EmployeeDao empDao = new EmployeeDaoImpl();
	
	@Override
	public void addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		// 添加前，先判断是否有同名的员工，如果有，不能添加
		Employee employee = empDao.findByName(emp.getName());
		if(employee != null){
			throw new RuntimeException("存在同名员工，不能添加");
		}
		// 添加数据
		EmployeeDao empDao = new EmployeeDaoImpl();
		empDao.add(emp);
	}

	@Override
	public List<Employee> findAllEemployee() {
		// TODO Auto-generated method stub
		List<Employee> list = null;
		try {
			list = empDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException("查询所用用户数据异常");
		}
		return list;
	}

	@Override
	public void deleteEmpById(Integer id) {
		// TODO Auto-generated method stub
		
		// 判断删除的数据是否存在
		// 删除
		empDao.deleteById(id);
		
	}

	@Override
	public Employee findEmpById(Integer id) {
		// TODO Auto-generated method stub
		return empDao.findById(id);
	}

	@Override
	public void updateEmp(Employee emp) {
		// TODO Auto-generated method stub
		
		// 判断是否是否存在
		
		// 更新
		empDao.update(emp);
		
	}

	@Override
	public Employee login(String name, String password) {
		// TODO Auto-generated method stub
		Employee emp = empDao.findByName(name);
		if (emp == null) {
			throw new RuntimeException("用户名错误");
		}
		if(!emp.getPassword().equals(password)) {
			throw new RuntimeException("密码错误");
		}
		return emp;
	}
}
