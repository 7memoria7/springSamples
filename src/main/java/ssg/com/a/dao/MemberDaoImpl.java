package ssg.com.a.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ssg.com.a.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{
	
	@Autowired
	SqlSession session; // 세션이 연결되도록 설정
//	SqlSessionTemplate session; 둘중에 하나 사용하면 된다.

	String ns = "Member.";
	@Override
	public int idcheck(String id) {
		
		int count = session.selectOne(ns + "idcheck", id);
	//	int count = session.selectOne("Member.idcheck", id);	
		return count;
	}
	@Override
	public int addmember(MemberDto dto) {
		
		return session.insert(ns + "addmember", dto);
	}
	@Override
	public MemberDto login(MemberDto dto) {
		return session.selectOne(ns + "loginmsg", dto);
	}
	
	
}
