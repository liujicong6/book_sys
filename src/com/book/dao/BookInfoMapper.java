package com.book.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.book.pojo.BookInfo;

public interface BookInfoMapper {
	/**
	 * 添加新书籍到数据库中
	 * @param book
	 * @return 1-成功 0-失败
	 */
	int addNewBook(BookInfo book);
	/**
	 * 查询书籍信息
	 * @param from-起始索引（0开始）
	 * @param pageSize-每页数量
	 * @return 书籍信息列表
	 */
	List<BookInfo> listBook(
			@Param("from") Integer from,@Param("pageSize") Integer pageSize);
	/**
	 * 返回书籍数量
	 * @return
	 */
	Integer bookCount();
}




