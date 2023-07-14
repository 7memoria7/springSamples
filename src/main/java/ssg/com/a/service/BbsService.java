package ssg.com.a.service;

import java.util.List;

import ssg.com.a.dto.BbsDto;
import ssg.com.a.dto.BbsParam;
import ssg.com.a.dto.MemberDto;

public interface BbsService {
	List<BbsDto> bbslist(BbsParam param);
	int getAllBbs(BbsParam param);
	
	boolean bbswrite(BbsDto dto);
	
	BbsDto bbsdetail(int seq);
}
