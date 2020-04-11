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

/**
 * Servlet implementation class gai
 */
@WebServlet("/gai")
public class gai extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService=new BookService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Integer id = Integer.valueOf(request.getParameter("id"));
		BookInfo bookInfo=bookService.sel(id);
		List<Category>  categories=bookService.listCategories();
		request.getSession().setAttribute("categories", categories);
		request.getSession().setAttribute("bookInfo", bookInfo);
		request.getRequestDispatcher("/WEB-INF/jsp/book_edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
