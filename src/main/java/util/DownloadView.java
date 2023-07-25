package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import ssg.com.a.service.PdsService;

public class DownloadView extends AbstractView{
	@Autowired
	PdsService service;		// PdsService 접근 가능, Controller의 전유물이 아니다!

	@Override									// 맵으로 만든 데이터를 받아라는 의미
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("DownloadView renderMergedOutputModel");
		
		File downloadFile = (File)model.get("downloadFile");
		String filename = (String)model.get("filename");
		int seq = (Integer)model.get("seq");
		
		System.out.println("filename" + filename);
		System.out.println("seq" + seq);
		
		response.setContentType(this.getContentType());	// 설정해줘야한다.
		response.setContentLength((int)downloadFile.length());  // 다운로드 길이 값 설정
		
		// 원본파일 이름이 한글명으로 되어있는 경우, 이 소스코드가 필요하다!
		filename = URLEncoder.encode(filename, "utf-8");
				
		// 다운로드 받는 윈도우*******									    // 쌍따옴표로 묶어준다!
		response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");  // 원본 파일이름을 넣어줘야한다
		response.setHeader("Content-Transfer-Encoding", "binary;");
		response.setHeader("Content-Length", "" + downloadFile.length());
		response.setHeader("Pragma", "no-cache;");
		response.setHeader("Expires", "-1;"); 	// -1 의미는 유효기간이 없다는 의미
		
		OutputStream os = response.getOutputStream();
		FileInputStream fis = new FileInputStream(downloadFile);
		
		// 실제로 데이터를 기입
		FileCopyUtils.copy(fis, os);  // fis에 있는 파일을 os에 넣어라는 의미
		
		// download count 증가
		if(fis != null) {
			fis.close();
		}
		
	}
}
