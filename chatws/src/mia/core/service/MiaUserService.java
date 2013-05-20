package mia.core.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import mia.core.dao.MiaUserMapper;
import mia.core.model.MiaUser;

public class MiaUserService implements MiaUserServiceLocal {

	@Override
	public MiaUser getUserByUserLogin(String username) {
		
		SqlSessionFactory sqlMapper = MyBatisService.getSessionFactory();
		SqlSession sqlSession = sqlMapper.openSession(true);

		MiaUserMapper mapper = sqlSession.getMapper(MiaUserMapper.class);
		
		MiaUser user = mapper.getUserByUserLogin(username);
		
		sqlSession.close();
		
		return user;
	}

}
