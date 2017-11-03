package controller;

import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Course;

@Controller
public class BindRequetController {
	private static Logger log = LoggerFactory.getLogger(RequestController.class);
	
	@RequestMapping(value="/loginp",method=RequestMethod.GET)
	public String getCourse() {
		return "login";
	}
	
	//重定向："redirect:/loginp"回到上面的loginp请求
	//不用重定向：直接成功jsp页面
	@RequestMapping(value="/save",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	public String saveCourse(Course course,Model model) {
		log.error(ReflectionToStringBuilder.toString(course));
//		model.put("course",ReflectionToStringBuilder.toString(course));
		model.addAttribute("course", ReflectionToStringBuilder.toString(course));
		return "success";
	}
	
	@RequestMapping(value="/save2",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	public String saveCourse2(@ModelAttribute Course course) {
		log.error("-----"+ReflectionToStringBuilder.toString(course));
		return "success";
	}
	
	
}
