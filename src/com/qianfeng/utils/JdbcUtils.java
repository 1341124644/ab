package com.qianfeng.utils;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	private static ComboPooledDataSource datasource = null;
	
	static{
		// 创建连接池对象,默认读取src下的配置文件
		datasource = new ComboPooledDataSource();
	}
	// apache提供的DBUtils 通过QueryRunner调用相关方法进行增删改查
	public static QueryRunner getQueryRunner(){
		
		// 参数是数据库连接池的对象
		// 通过该方法，将Dbutils和数据库连接池关联到一起了
		QueryRunner queryRunner = new QueryRunner(datasource);
		return queryRunner;
	}
}
