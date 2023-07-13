package ssg.com.a.dao;

import ssg.com.a.dto.MemberDto;

public interface MemberDao {
	
	public int idcheck(String id);
	
	int addmember(MemberDto dto);
	
	MemberDto login(MemberDto dto);
}
