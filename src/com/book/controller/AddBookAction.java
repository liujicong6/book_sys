package com.book.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.book.pojo.BookInfo;
import com.book.pojo.Category;
import com.book.service.BookService;
import com.mysql.jdbc.StringUtils;

@WebServlet("/add_book")
public class AddBookAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 声明变量，用于获取前端数据
		String bookName = null,author = null,publisher = null,photo = null;
		Double price = null;
		Category category = null;
		try {
			String realPath = getServletContext().getRealPath("/static/file");
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletContext servletContext = this.getServletConfig().getServletContext();
			File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
			factory.setRepository(repository);
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(2*1024*1024);	// 2M
			upload.setHeaderEncoding("UTF-8");
			List<FileItem> items = upload.parseRequest(request);
			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext()) {
			    FileItem item = iter.next();
			    if (item.isFormField()) {
			    	String name = item.getFieldName();
					String value = item.getString();
					if(StringUtils.isNullOrEmpty(value)) {
						request.setAttribute("message",name+"内容不能为空");
						request.getRequestDispatcher("/book_mgr").forward(request,response);
						return;
					}
					if(name.equals("bookName")) {
						bookName = new String(value.getBytes("ISO-8859-1"),"utf-8");
					}
					else if(name.equals("author")) {
						author = new String(value.getBytes("ISO-8859-1"),"utf-8");
					}
					else if(name.equals("categoryId")) {
						category = new Category();
						category.setId(Integer.valueOf(value));
					}
					else if(name.equals("price")) {
						price = Double.valueOf(value);
					}
					else {
						publisher = new String(value.getBytes("ISO-8859-1"),"utf-8");
					}
			    } else {					
			        String fileName = item.getName();	
			        String contentType = item.getContentType();
			        if(contentType.equals("image/png") 
			        		|| contentType.equals("image/jpeg")
			        		|| contentType.equals("image/gif")) {
			        	String rand = UUID.randomUUID().toString();
			        	photo = rand+fileName.substring(fileName.lastIndexOf("."));
				        File uploadedFile = new File(realPath,photo);
				        item.write(uploadedFile);
				     }
			        else {
			        	request.setAttribute("message", "只能为PNG或JPG或GIF图片");
			        	request.getRequestDispatcher("/book_mgr").forward(request,response);
			        	return;
			        }
			    }
			}
			// 保存到数据库
	        BookInfo book = new BookInfo(null,bookName,author,
	        		publisher,price,photo,category);
	        bookService.addNewBook(book);
	        // 返回相应数据
	        request.setAttribute("message", "添加书籍成功");
        	request.getRequestDispatcher("/book_mgr").forward(request,response);
	        return;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
