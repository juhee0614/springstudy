package com.kh.myapp.member.dao;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.kh.myapp.member.dto.MemberDTO;

import lombok.extern.slf4j.Slf4j;


@SpringBootTest
@Slf4j
public class MemberDAOImplTest {

	@Autowired
	private JdbcTemplate jt;
	MemberDAOImpl memberDAOImpl;
	
	@BeforeEach
	void init() {
		memberDAOImpl = new MemberDAOImpl(jt);
	}
	@Test
	@DisplayName("회원가입")
	@Disabled
	void joinMember() {
		
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setId("test11@test.com");
		memberDTO.setPwd("1234");
		memberDTO.setNickname("테스터11");
		
		int result =memberDAOImpl.joinMember(memberDTO);
		Assertions.assertThat(result).isEqualTo(1);
	}
	
	@Test
	@DisplayName("회원수정")
	@Disabled
	void modifyMember() {
	
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setId("test@test.com");
		memberDTO.setPwd("9999");
		memberDTO.setNickname("테스터1");
		
		int result = memberDAOImpl.modifyMember(memberDTO);
		
		Assertions.assertThat(result).isEqualTo(1);
		
	}
	
	@Test
	@DisplayName("회원탈퇴")
	@Disabled
	void deleteMember() {
		
		int result = memberDAOImpl.deleteMember("test11@test.com");
		Assertions.assertThat(result).isEqualTo(1);
		
	}
	
	@Test
	@DisplayName("회원조회")
	@Disabled
	void searchMember() {
		MemberDTO expected = new MemberDTO();
		
		expected.setId("test@test.com");
		expected.setPwd("9999");
		expected.setNickname("테스터1");
		MemberDTO result = memberDAOImpl.searchMember("test@test.com");
		Assertions.assertThat(expected).isEqualToComparingFieldByField(result);
		//log.info("memberDTO:{}",memberDTO.toString());
	}
	
	@Test
	@DisplayName("회원전체조회")
	@Disabled
	void memberList() {
		
		List<MemberDTO> list = memberDAOImpl.memberList();
		//목록 다 나열 
//		for(MemberDTO mdto : list) {
//			log.info(mdto.toString());			
//		}
		//목록count가 5개면 참!
		Assertions.assertThat(list.size()).isEqualTo(5);
	}
	
}






