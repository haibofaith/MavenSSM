package controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Book;
import service.IBookService;

@Controller
public class JsonController {
	private static Logger log = LoggerFactory.getLogger(JsonController.class);
	@Resource  
	private IBookService iBookService;
	
	@RequestMapping(value="h.do")
	public @ResponseBody List<Book> viewBook() {
		List<Book> bl = iBookService.getBookByName("大明春色");
		log.debug("---------------------json-------------------");
		return bl;
	}
}
