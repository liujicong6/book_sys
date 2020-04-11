package com.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.StringUtils;

import com.book.pojo.User;
import com.book.service.UserService;

/**
 * Servlet implementation class userLogin
 */
@WebServlet("/userLogin")
public class userLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
private UserService userService=new UserService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String userId = request.getParameter("loginId");
		String userPsw = request.getParameter("loginPsw");
		String reLoginPsw = request.getParameter("reLoginPsw");
		String userName = request.getParameter("name");
		String code = request.getParameter("code");
		
		if(StringUtils.isNullOrEmpty(userId) || StringUtils.isNullOrEmpty(userPsw) 
				|| StringUtils.isNullOrEmpty(reLoginPsw) 
				|| StringUtils.isNullOrEmpty(userName)
				|| StringUtils.isNullOrEmpty(code)) {
			request.setAttribute("error","任何信息都不能为空");
			request.getRequestDispatcher("/WEB-INF/jsp/user_regist.jsp").forward(request, response);
			return;
		}
		if(userPsw.equals(reLoginPsw) == false) {
			request.setAttribute("error","密码和确认密码必须相同");
			request.getRequestDispatcher("/WEB-INF/jsp/user_regist.jsp").forward(request, response);
			return;
		}
		if(code.equals("2648") == false) {
			request.setAttribute("error","验证码不对");
			request.getRequestDispatcher("/WEB-INF/jsp/user_regist.jsp").forward(request, response);
			return;
		}
		if(userService.findUserById(userId) != null) {//判断一般账户是否存在
			request.setAttribute("error","账户已经存在");
			request.getRequestDispatcher("/WEB-INF/jsp/user_regist.jsp").forward(request, response);
			return;
		}
		User user = new User(userId, userPsw, userName, 1);
		userService.addBookUser(user);
		request.getSession().setAttribute("user",user);
	
		
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/user_login.jsp").forward(request,response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
