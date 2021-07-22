package com.kh.myapp.member.dao;


import java.util.List;

import com.kh.myapp.member.dto.MemberDTO;

public interface MemberDAO {
	//회원가입
	int joinMember(MemberDTO memberDTO);
	
	//회원 수정
	int modifyMember(MemberDTO memberDTO);
	
	//회원조회
	MemberDTO searchMember(String id);
	
	//회원삭제
	int deleteMember(String id);
	
	//회원전체조회
	List<MemberDTO> memberList();
}
