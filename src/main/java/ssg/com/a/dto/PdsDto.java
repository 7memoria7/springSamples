package ssg.com.a.dto;

import java.io.Serializable;

// Personal Data Store
public class PdsDto implements Serializable{
	private int seq;
	private String id;
	private String title;
	private String content;
// 만약 답글이 필요하다면 추가로 해줘야한다. ref, depth
	
	private String filename;    // 원본 파일명		abc.txt
	private String newfilename;	// 업로드 파일명	32424232323.txt
	
	private int readcount;
	private int downcount;		// download한 count
	private String regdate;		// 등록일
	
	public PdsDto() {
	}

	//  외부에서 들어오는 4가지 생성자 id, title, content, filename
	public PdsDto(String id, String title, String content, String filename) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.filename = filename;
	}

	public PdsDto(int seq, String id, String title, String content, String filename, String newfilename, int readcount,
			int downcount, String regdate) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.filename = filename;
		this.newfilename = newfilename;
		this.readcount = readcount;
		this.downcount = downcount;
		this.regdate = regdate;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getNewfilename() {
		return newfilename;
	}

	public void setNewfilename(String newfilename) {
		this.newfilename = newfilename;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public int getDowncount() {
		return downcount;
	}

	public void setDowncount(int downcount) {
		this.downcount = downcount;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "PdsDto [seq=" + seq + ", id=" + id + ", title=" + title + ", content=" + content + ", filename="
				+ filename + ", newfilename=" + newfilename + ", readcount=" + readcount + ", downcount=" + downcount
				+ ", regdate=" + regdate + "]";
	}	
}
