package com.book.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.pojo.BookInfo;
import com.book.pojo.Category;
import com.book.service.BookService;
import com.mysql.jdbc.StringUtils;

@WebServlet("/index")
public class IndexAccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 获取所有的分类类型
		List<Category> categories = bookService.listCategories();
		// 获取当前页码
		String sCurrentPage = request.getParameter("currentPage");
		if(StringUtils.isNullOrEmpty(sCurrentPage)) {
			sCurrentPage = "1";
		}
		Integer currentPage = Integer.valueOf(sCurrentPage);
		// 获取所有书籍信息
		List<BookInfo> books = bookService.listBook(currentPage);
		// 获取书籍数量
		Integer count = bookService.bookCount();
		// 调用服务，生成分页导航字符串
		String navStr = bookService.bookNavStr(currentPage, count);
		// 获取总页数
		Integer countPage = count%bookService.PAGESIZE==0?
				count/bookService.PAGESIZE:count/bookService.PAGESIZE+1;
		// 给request设置属性
		request.setAttribute("categories", categories);
		request.setAttribute("books", books);
		request.setAttribute("count", count);
		request.setAttribute("countPage",countPage);
		request.setAttribute("pageSize", bookService.PAGESIZE);
		request.setAttribute("navStr", navStr);
		
		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}












