package controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Book;
import service.IBookService;

@Controller
public class RequestController {
	private static Logger log = LoggerFactory.getLogger(RequestController.class);
	@Resource  
	private IBookService iBookService;
	
	@RequestMapping(value="d.do",produces="text/html;charset=UTF-8")
	public @ResponseBody String viewBook() {
		List<Book> bl = iBookService.getBookByName("大明春色");
		System.out.println(bl.toString());
		//添加error日志
		log.error("----log-----");
		return "你好";
	}
	
	//Get请求
	@RequestMapping(value="e.do",produces="text/html;charset=UTF-8")
	public @ResponseBody String viewBookByName(@RequestParam(name="name",defaultValue="大明春色")String name) {
		List<Book> bl = iBookService.getBookByName(name);
		System.out.println(bl.toString());
		//添加error日志
		log.error("----log-----");
		return "你好";
	}
	
	//	Post请求
	@RequestMapping(value="f.do",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	public @ResponseBody String postBookByName(String name) {
		System.out.println(name.toString());
		List<Book> bl = iBookService.getBookByName(name);
		//添加error日志
		log.error("----log-----"+bl.toString());
		return "你好";
	}
	
	//	get请求,Rest风格
	@RequestMapping(value="/view/{name}",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	public @ResponseBody String restBookByName(@PathVariable("name")String name) {
		List<Book> bl = iBookService.getBookByName(name);
		System.out.println(bl.toString());
		//添加error日志
		log.error("----log-----");
		return "你好";
	}
	
	//古老风格HttpServlet与SpringMVC的结合
	@RequestMapping(value="/view2",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	public @ResponseBody String httpServletBookByName(HttpServletRequest request) {
		List<Book> bl = iBookService.getBookByName(request.getParameter("name"));
		System.out.println(bl.toString());
		//添加error日志
		log.error("----log-----");
		return "你好：古老风格HttpServlet与SpringMVC的结合";
	}
}
