package com.helloyou.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

public class FileManager {
	public static void deleteFile(HttpSession session,String imageName){
		String path=session.getServletContext().getRealPath(imageName);
		try{
    		File file = new File(path);
    		if(file.delete()){
    			System.out.println(file.getName() + " is deleted!");
    		}else{
    			System.out.println("Delete operation is failed.");
    		}
    	}catch(Exception e){
    		System.out.println("Delete operation is failed.");
    	}
	}
	
	public static String createFile(HttpSession session, MultipartFile file, String realPath){
		String bigImageName=file.getOriginalFilename();
		if(bigImageName==null||bigImageName.isEmpty())
			return null;
		String realName=UUID.randomUUID().toString();
		String path=session.getServletContext().getRealPath(realPath);
		String bigExt = bigImageName.substring(bigImageName.lastIndexOf("."));
		File bigRealFile=new File(path+"/"+realName+bigExt);
		try {
			file.transferTo(bigRealFile);
			return realPath+realName+bigExt;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
