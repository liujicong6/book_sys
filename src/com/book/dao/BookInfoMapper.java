package com.book.dao;

import com.book.pojo.BookInfo;

public interface BookInfoMapper {
	/**
	 * 添加新书籍到数据库中
	 * @param book
	 * @return 1-成功 0-失败
	 */
	int addNewBook(BookInfo book);
}
