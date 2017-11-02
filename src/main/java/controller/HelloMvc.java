package controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Book;
import model.Person;
import service.IBookService;

@Controller
public class HelloMvc {
	@RequestMapping(value="/a.do",produces="text/html;charset=UTF-8")
	public @ResponseBody String hello() {
		return "你好";
	}
	@Autowired
	Person p;
	
	@RequestMapping(value="/b.do",produces="text/html;charset=UTF-8")
	public @ResponseBody String personWho() {
		p.say();
		return "你好,人类";
	}
	
	@Resource  
    private IBookService bookService = null; 
	
	@RequestMapping(value="/c.do",produces="text/html;charset=UTF-8")
	public @ResponseBody String addrShow(){
		return bookService.getBookById("59cc3a7f3ea44b15c1f92ac0").toString();
	}
	
}
