package mia.core.service;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class MyBatisService {

	private static String resource = "mia/core/dao/xml/mybatisConfig.xml";
	private static Reader reader = null;
	private static SqlSessionFactory sqlMapper = null;
	private static Logger logger = Logger.getLogger(MyBatisService.class.getName());

	public static synchronized SqlSessionFactory getSessionFactory() {
		if (sqlMapper == null) {
			try {
				reader = Resources.getResourceAsReader(resource);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			} catch (IOException e) {
				logger.warn("Error SQL Session: " + e.toString());
			}
		}

		return sqlMapper;
	}
}
