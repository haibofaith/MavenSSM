package controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Book;
import service.IBookService;

@Controller
public class HelloController {
//	private static Logger log = LoggerFactory.getLogger(HelloController.class);
	@Resource  
	private IBookService iBookService;
	
	@RequestMapping(value="d.do",produces="text/html;charset=UTF-8")
	public @ResponseBody String viewBook() {
		List<Book> bl = iBookService.getBookByName("大明春色");
		System.out.println(bl.toString());
		return bl.toString();
	}
}
