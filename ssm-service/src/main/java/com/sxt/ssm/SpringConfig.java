package com.sxt.ssm;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Controller.class))
@MapperScan(basePackages = "com.sxt.ssm.data")
@EnableTransactionManagement
public class SpringConfig {
	@Bean
	public DataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl(
				"jdbc:mysql://127.0.0.1:3306/store?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8");
		ds.setUsername("jifei");
		ds.setPassword("root");
		ds.setDefaultAutoCommit(false);
		return ds;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) {
		SqlSessionFactoryBean been = new SqlSessionFactoryBean();
		been.setDataSource(dataSource);
		been.setTypeAliasesPackage("com.sxt.ssm.entity");
		Resource[] resources;
		SqlSessionFactory factory = null;
		try {
			resources = new PathMatchingResourcePatternResolver()
					.getResources("classpath*:com/sxt/ssm/data/*Mapper.xml");
			been.setMapperLocations(resources);
			factory = been.getObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return factory;
	}

	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource) {
		DataSourceTransactionManager t = new DataSourceTransactionManager();
		t.setDataSource(dataSource);
		return t;
	}
}
