package ssg.com.a.dto;

import java.io.Serializable;

// BBS Bulletin Board System
public class BbsDto implements Serializable{  // 직렬화
	
	private int seq;		// sequence 글번호
	private String id;		// 작성자
	
	private int ref;		// 그룹번호(글번호)
	private int step;		// 행번호
	private int depth;		// 깊이
	
	private String title;
	private String content;
	private String wdate;
	
	private int del;
	private int readcount;	// 조회수
	
	public BbsDto() {
	}

	public BbsDto(String id, String title, String content) { // 이거는 로그인 한 사람이 입력하는 부분이다
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public BbsDto(int seq, String id, int ref, int step, int depth, String title, String content, String wdate, int del,
			int readcount) {
		super();
		this.seq = seq;
		this.id = id;
		this.ref = ref;
		this.step = step;
		this.depth = depth;
		this.title = title;
		this.content = content;
		this.wdate = wdate;
		this.del = del;
		this.readcount = readcount;
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

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
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

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
}
