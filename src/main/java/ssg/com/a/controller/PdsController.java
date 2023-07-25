package ssg.com.a.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ssg.com.a.dto.PdsDto;
import ssg.com.a.service.PdsService;
import util.PdsUtil;

@Controller
public class PdsController {

	@Autowired
	PdsService service;
	
	@GetMapping("pdslist.do")
	public String pdslist(Model model) {
		System.out.println("PdsController pdslist() " + new Date());
		
		List<PdsDto> list = service.pdslist();		
		model.addAttribute("pdslist", list);
		
		return "pdslist";
	}
	
	@GetMapping("pdswrite.do")
	public String pdswrite() {
		System.out.println("PdsController pdswrite() " + new Date());		
		return "pdswrite";
	}
	
	@PostMapping("pdsupload.do")
	public String pdsupload(PdsDto pds, 
							@RequestParam(value = "fileupload", required = false)
							MultipartFile fileupload,
							HttpServletRequest request) {
		System.out.println("PdsController pdsupload() " + new Date());
		
		// filename 취득
		String filename = fileupload.getOriginalFilename();
		System.out.println("filename:" + filename);
		
		// DB에 저장을 위해서
		pds.setFilename(filename); // 원본파일저장
		
		// Upload 경로 설정 - 경로를 가져오기위해 리퀘스트 필요!! --- upload 앞에 '/' 중요하다!
		// tomcat서버에 올리는 소스코드
		String fupload = request.getServletContext().getRealPath("/upload");		
		
		// 서버에 올리다가 파일이 없어질 수도 있다. 폴더에 저장하는 것은 파일이 없어지지 않는다. 
		
		// 폴더
//		String fupload = "d:\\tmp";
		
		System.out.println("파일업로드경로:" + fupload);
		
		// 파일명의 변경 data.txt -> 날짜형 자료형로 바꿔야한다. 즉, 32323232.txt
		String newfilename = PdsUtil.getNewfileName(filename);		
		System.out.println("newfilename:" + newfilename);
		
		// DB에 저장을 위해서
		pds.setNewfilename(newfilename);
		
		// 파일 업로드
		File file = new File(fupload + "/" + newfilename);
		
		try {
			// 실제 파일에 업로드 되는 부분!! 
			FileUtils.writeByteArrayToFile(file, fileupload.getBytes());
			
			// DB에 저장
			boolean isS = service.uploadPds(pds);
			if(isS) {
				System.out.println("파일 업로드 성공!");
			}else {
				System.out.println("파일 업로드 실패");
			}
			
		} catch (IOException e) {			 
			e.printStackTrace();
		}		
		
//		return "pdswrite"; // 에러나기전에 확인해보려고 넣었지롱
		
		return "redirect:/pdslist.do";
	}
	
	@GetMapping("pdsdetail.do")
	public String pdsdetail(int seq, Model model) {
		System.out.println("PdsController pdsdetail() " + new Date());
		
		PdsDto pds = service.getPds(seq);
		model.addAttribute("pds", pds);
		
		return "pdsdetail";
	}
	
//	@GetMapping("filedownload.do")
	@PostMapping("filedownload.do")
	public String filedownload(int seq, String filename, String newfilename, 
								Model model, HttpServletRequest request) {
		// 경로 설정
		String fupload = request.getServletContext().getRealPath("/upload");
		
		// 폴더에 올려 놓은 경우
//		String fupload = "d:\\tmp"; 이게 필요합니다요.
		
		// 다운로드 받을 파일
		File downloadFile = new File(fupload + "/" + newfilename);  // 기능은 그냥 받아들이자! 사용법을 익히자!!
		
		model.addAttribute("downloadFile", downloadFile);
		model.addAttribute("filename", filename);		// 원본 파일명
		model.addAttribute("seq", seq);
		
		return "downloadView";
	}
}
