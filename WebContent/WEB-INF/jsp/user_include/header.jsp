<%@page import="com.book.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib  prefix="c"  uri="http://java.sun.com/jstl/core_rt" %>
		<div id="header">
    		<div id="tool-bar">&nbsp;&nbsp; 欢迎光临智远图书网，
    		<c:if test="${user. role !=1}">
    		[<a href="${pageContext.request.contextPath}/login">请登录</a>]&nbsp;
    		</c:if>
    		<c:if test="${user. role ==1}">
    		[<a>${user.userName }</a>]&nbsp;
    		</c:if>
    		[<a href="${pageContext.request.contextPath}/userLogin">免费注册</a>]&nbsp;&nbsp;&nbsp;
    		<a href="index.html">首页</a>&nbsp;|&nbsp;
    		<a href="cart.html">购物车</a>&nbsp;|&nbsp;
    		<a href="#">我的订单</a>&nbsp;|&nbsp;<a href="#">帮助</a></div>
    		<h1>智远图书网-<span style="font-size: 48px; font-family: Arial; font-weight: lighter;">Book</span></h1>
    	</div>