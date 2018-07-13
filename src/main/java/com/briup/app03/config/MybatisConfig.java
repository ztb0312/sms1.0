package com.briup.app03.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 *
 */
@Configuration
@MapperScan("com.briup.app03.dao")//
public class MybatisConfig {

}
