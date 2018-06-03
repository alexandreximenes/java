package br.alexandre.livraria.infra;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSave {

	@Autowired
	private HttpServletRequest request;
	
	public String write(String baseFolder, MultipartFile file) {
		
		System.out.println(file.getName());
		System.out.println(file.getContentType());
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		try {
			System.out.println(file.getInputStream());
			System.out.println(file.getBytes());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		String realPath = request.getServletContext().getRealPath("/"+baseFolder);
        
		String path = realPath + "/"+ file.getOriginalFilename();
		try {
		
			file.transferTo(new File(path));
		
		} catch (IllegalStateException | IOException e) {
			throw new RuntimeException(e);
		}
		return baseFolder + "/"+ file.getOriginalFilename();
	}
}
