package com.xybc.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.xybc.mapper.mysql"},sqlSessionFactoryRef = "mysqlSqlSessionFactory")
//这里一定要注意，这个basePackages是你的mapper接口及service所在的包名，而下面的红线所标注的classpath是mapper.xml所在的位置，这个xml是配置文件，处在resources里，他的路径也要格外区分开。
public class MysqlDataSourceConfig {
	@Bean(name="mysqlDataSource")
	//下面的注解作用就是从application.properties中读取以这个字符串开头的那些配置，设置为数据源的配置
	@ConfigurationProperties(prefix ="spring.datasource.mysql")
	public DataSource mysqlDataSource(){
		return DataSourceBuilder.create().build();
	}
	@Bean(name="mysqlSqlSessionFactory")
	public SqlSessionFactory mysqlSqlSessionFactory(@Qualifier("mysqlDataSource") DataSource dataSource)throws Exception{
		SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mysqlMapper/*.xml"));
		System.out.println("config mysqlSqlSessionFactory success.");
		return bean.getObject();
	}
	@Bean(name = "mysqlTransactionManager")
	public DataSourceTransactionManager mysqlTransactionManager(@Qualifier("mysqlDataSource")DataSource dataSource){
		return new DataSourceTransactionManager(dataSource);
	}
	@Bean(name="mysqlSqlSessionTemplate")
	public SqlSessionTemplate mysqlSqlSessionTemplate(@Qualifier("mysqlSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}