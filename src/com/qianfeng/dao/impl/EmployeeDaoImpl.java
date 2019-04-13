package com.qianfeng.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qianfeng.dao.EmployeeDao;
import com.qianfeng.entity.Employee;
import com.qianfeng.utils.JdbcUtils;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		// 定义sql语句
		String sql = "select * from employee";
		// 获得QueryRunner对象
		QueryRunner qr = JdbcUtils.getQueryRunner();
		List<Employee> list = null;
		try {
			
			// 查询使用query方法
			// 因为需要获取多条员工数据，返回的是List的集合，
			// 所以需要创建一个BeanListHandler对象，在构造方法中，体现要自动封装的类是哪个
			list = qr.query(sql, new BeanListHandler<>(Employee.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public void add(Employee emp) {
		// TODO Auto-generated method stub
		String sql = "insert into employee(name,age,sex,phone) values(?,?,?,?)";
		
		QueryRunner qr = JdbcUtils.getQueryRunner();
		
		Object[] params = new Object[]{
				emp.getName(),
				emp.getAge(),
				emp.getSex(),
				emp.getPhone()
		};
		try {
			// 增删改使用update方法
			qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void update(Employee emp) {
		// TODO Auto-generated method stub
		String sql = "update employee set name=?,sex=?,age=?,phone=? where id=?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		Object[] param = new Object[]{
				emp.getName(),
				emp.getSex(),
				emp.getAge(),
				emp.getPhone(),
				emp.getId()
		};
		try {
			qr.update(sql, param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
		String sql = "delete from employee where id=?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		try {
			// 增删改 使用update方法
			qr.update(sql, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public Employee findById(Integer id) {
		// TODO Auto-generated method stub
		
		String sql = "select * from employee where id=?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		Employee emp = null;
		try {
			emp = qr.query(sql, new BeanHandler<>(Employee.class), id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return emp;
	}

	@Override
	public Employee findByName(String name) {
		// TODO Auto-generated method stub
		
		String sql = "select * from ttt where name=?";
		QueryRunner qr = JdbcUtils.getQueryRunner();
		Employee emp = null;
		try {
			emp = qr.query(sql, new BeanHandler<>(Employee.class), name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}

}
