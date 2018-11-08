package com.thinkive.dzjf.title.change.tool;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;


/**
 * @desc mybatis逆向工程工具类
 * @author changez@thinkive.com
 * @time 2018年9月11日 下午5:07:09
 */
@Slf4j
public class MybatisGeneratorTable {

	public static void main(String[] args) throws Exception {
		
		log.info("start generator table to bean and mapper xml files");
		try {
			
			MybatisGeneratorTable generatorSqlmap = new MybatisGeneratorTable();
			generatorSqlmap.generator();
		} catch (Exception e) {
			
			log.error("generator failed, errInfo={}", e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void generator() throws Exception {

		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		
		// 指定逆向工程配置文件
		File configFile = new File("E:/java/eclipse-jee-luna-SR2-win32-x86_64/workspace/rocketmq-trade-parent/rocketmq-trade-dao/src/main/resources/mybatis/generator/mybatis-generator.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
	}

}
