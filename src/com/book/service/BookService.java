package com.book.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.book.dao.BookInfoMapper;
import com.book.dao.CategoryMapper;
import com.book.pojo.BookInfo;
import com.book.pojo.Category;
import com.book.tools.MyBatisUtil;

public class BookService {
	/**
	 * 添加新的分类
	 * @param category
	 * @return 1-成功 0-失败
	 */
	public int addNewCategory(String category) {
		// 保存返回结果
		int result = 0;
		// 去除两端空格
		String name = category.trim();
		SqlSession sqlSession = MyBatisUtil.open();
		// 查询此分类是否存在
		Category res = sqlSession.getMapper(CategoryMapper.class).findCategoryByName(name);
		// 不存在此分类
		if(res == null) {
			// 添加分类到数据库
			result = sqlSession.getMapper(CategoryMapper.class).addNewCategory(name);
		}
		// 提交事务（增删改）
		sqlSession.commit();
		MyBatisUtil.close(sqlSession);
		// 返回结果
		return result;
	}
	/**
	 * 获取所有的分类信息
	 * @return
	 */
	public List<Category> listCategories(){
		SqlSession sqlSession = MyBatisUtil.open();
		List<Category> categories = sqlSession
				.getMapper(CategoryMapper.class).listCategories();
		sqlSession.commit();
		MyBatisUtil.close(sqlSession);
		return categories;
	}
	/**
	 * 根据id删除分类
	 * @param id
	 * @return 1-成功 0-失败
	 */
	public int deleteCategoryById(Integer id) {
		int result = 0;
		SqlSession sqlSession = MyBatisUtil.open();
		result = sqlSession.getMapper(CategoryMapper.class).deleteCategoryById(id);
		sqlSession.commit();
		MyBatisUtil.close(sqlSession);
		return result;
	}
	/**
	 * 添加新书籍到数据库中
	 * @param book
	 * @return 1-成功 0-失败
	 */
	public int addNewBook(BookInfo book) {
		int result = 0;
		SqlSession sqlSession = MyBatisUtil.open();
		result = sqlSession.getMapper(BookInfoMapper.class).addNewBook(book);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
}






















