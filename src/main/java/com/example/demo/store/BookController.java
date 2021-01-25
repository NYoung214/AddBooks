package com.example.demo.store;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController extends HttpServlet {
	private List<Book> books;
	private static final long serialVersionUID = 1L;
	
	@Autowired
	BookCrudRepository bookRepo;
	
	@RequestMapping("/book_list")
	public String show(Model model) {
		try {
			books = (List<Book>) bookRepo.findAll();
			if(books.isEmpty()) {
				model.addAttribute("errors", "<span style='color:red'>Database is empty</span>");
			}else {
				model.addAttribute("books", books);				
			}
			return "index";			
		}catch(Exception e) {
			model.addAttribute("errors", "<span style='color:red'>Database is empty</span>");
			return "index";
		}

	}
	
	@RequestMapping("/add")
    public String doPost(HttpServletRequest request,HttpServletResponse response, Model model) throws ServletException, IOException {
		String name = request.getParameter("name");
		String genre = request.getParameter("genre");
		String price = request.getParameter("price");
		String valid = validate(name,genre,price);
		if(valid.isEmpty()) {
			bookList(name,genre,price);	
			books = (List<Book>) bookRepo.findAll();				
			model.addAttribute("books", books);	
		}else {
			PrintWriter out = response.getWriter();
			model.addAttribute("errors",valid);
		}
		return "index";
	}

	private String validate(String name, String genre, String price) {
		StringBuilder err = new StringBuilder();
		boolean valid = true;
		err.append("<span style='color:red'>");
		if(name.isEmpty()==true || name.trim().length() <= 0 || name == null) {
			err.append("Name is invalid.\n");
			valid = false;
		}
		if(genre.isEmpty()==true || genre.trim().length() <= 0 || genre == null) {
			err.append("Genre is invalid.\n");
			valid = false;
		}
		try {
			Float.parseFloat(price);
		}catch(Exception e) {
			err.append("Price is invalid.\n</span>");
			valid = false;
			return err.toString();
		}
		if(valid){
			err.delete(0, err.length());
		}else {
			err.append("</span>");
		}
		return err.toString();
	}
		
	public void bookList(String name, String genre, String price) {
		Book book = new Book();
		book.setName(name);
		book.setGenre(genre);
		book.setPrice(Float.parseFloat(price));
		bookRepo.save(book);
	}
	

	
	
}
