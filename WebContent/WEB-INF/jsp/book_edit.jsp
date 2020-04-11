
<%@page import="java.util.List"%>
<%@page import="com.book.pojo.Category"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="com.book.pojo.BookInfo"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>图书网后台管理系统</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/mgr.css"/>
  </head>  
  <body>
    <div id="container">
    	<!-- header -->
    	<%@ include file="admin_include/header.jsp" %>
    	<!-- /header -->
    	<div id="main">
			<div class="section-left">    	
				<h2>编辑图书信息</h2>
				<form action="book-edit.html" method="post">
				<%
				
			BookInfo  book=	((BookInfo)session.getAttribute("bookInfo")); %>
					<input type="hidden" name="bookId" value="1" />
					<input type="hidden" name="bphotoOld" value="fzdxl.jpg" />
					<p>图书书名：<input type="text" name="btitle" value="<%=book.getBookName() %>"  /></p>
					<p>图书作者：<input type="text" name="bauthor" value="<%=book.getAuthor() %>"  /></p>
					<p>图书分类：
						<select name="bcategoryid">		
						<%
				
			List<Category> bo=	(List<Category> )session.getAttribute("categories");
					for(Category x: bo)	{
						
						if(book.getCategory().getId() == x.getId()){
							out.write("<option value='"+x.getId()+"' selected='selected'>"+x.getCategory()+"</option>");
						}
						else{
							out.write("<option value='"+x.getId()+"'>"+x.getCategory()+"</option>");
						}
					
					}
					%>	
						</select>
					</p>
					<p>图书售价：<input type="text" name="bprice" value="<%=book.getPrice() %>" /></p>
					<p>图书出版社：<input type="text" name="bpublisher" value="<%=book.getPublisher() %>"  /></p>  
					<p>当前图片：<img width="150" height="90" src="${pageContext.request.contextPath}/static/photo/<%=book.getPhoto() %>" /></p> 
					<p>图书图片：<input type="file" name="photo"  /></p>    				 				
					<p><input type="submit" value=" 修 改 "  />&nbsp;</p>					
				</form>
			</div>
			<div class="section-right"></div>			
			<div class="cf"></div>
		</div>  	
		<!-- footer -->
		<%@ include file="admin_include/footer.jsp" %>
		<!-- /footer -->
	</div>
  </body>
</html>
