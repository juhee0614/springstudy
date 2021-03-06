package com.kh.myapp.member.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kh.myapp.member.dao.MemberDAO;
import com.kh.myapp.member.dto.MemberDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberSVCImpl implements MemberSVC {

	@Autowired
	private final MemberDAO memberDAO;
	
	//회원가입

	@Override
	public int joinMember(MemberDTO memberDTO) {
	
		int result =0;
		result = memberDAO.joinMember(memberDTO);
		return result;
	}
	@Override
	public int modifyMember(MemberDTO memberDTO) {
		
		return memberDAO.modifyMember(memberDTO);
	}
	@Override
	public MemberDTO searchMember(String id) {
	
		return memberDAO.searchMember(id);
	}
	@Override
	public int deleteMember(String id) {
		
		return memberDAO.deleteMember(id);
	}
	@Override
	public List<MemberDTO> memberList() {
		
		return memberDAO.memberList();
	}

}
