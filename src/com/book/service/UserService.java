package com.book.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.session.SqlSession;

import com.book.dao.UserMapper;
import com.book.pojo.BookUser;
import com.book.pojo.User;
import com.book.tools.MyBatisUtil;


public class UserService {
	/**
	 * 根据账户和密码查询用户
	 * @param userId
	 * @param userPsw
	 * @return 成功返回用户对象，失败返回null
	 */
	public User findUserByIdAndPsw(String userId,String userPsw) {
		// 去除两端空格
		userId = userId.trim();
		userPsw = userPsw.trim();
		// 加密账户和密码
	//	userId =  DigestUtils.md5Hex(userId);
	//	userPsw = DigestUtils.md5Hex(userPsw);
		// 调用数据查询
		SqlSession sqlSession = MyBatisUtil.open();
		User result = sqlSession.getMapper(UserMapper.class)
				.findUserByIdAndPsw(userId, userPsw);
		sqlSession.commit();
		MyBatisUtil.close(sqlSession);
		// 返回结果
		return result;
	}
	
	public User findUserById(String userId) {
	SqlSession sqlSession=MyBatisUtil.open();
	 User  re=sqlSession.getMapper(UserMapper.class).findid(userId);
		
		sqlSession.close();
		return re;
		
		
		
	}
	
	public  int  addBookUser(User user) {
		SqlSession session=MyBatisUtil.open();
		Integer ss=session.getMapper(UserMapper.class).ins(user.getUserId(),user.getUserPsw(),user.getUserName(),
				1);
		
		
		return ss;
	}
}
