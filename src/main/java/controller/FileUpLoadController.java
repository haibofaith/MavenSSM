package controller;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUpLoadController {
	private static Logger log = LoggerFactory.getLogger(RequestController.class);
	@RequestMapping(value="/upload",method=RequestMethod.GET)
	public String fileUpload() {
		return "upload";
	}
	
	@RequestMapping(value="/doUpload",method=RequestMethod.POST)
	public String doUpload(@RequestParam("file")MultipartFile file) throws IOException {
		if (!file.isEmpty()) {
			log.debug("文件拷贝中------",file.getOriginalFilename());
			FileUtils.copyInputStreamToFile(file.getInputStream(),new File("/Users/user/eclipse-workspace/mvnStudy01/src/main/resources/uploadimg",System.currentTimeMillis()+file.getOriginalFilename()));
		}	
		return "successupload";
	}
}
