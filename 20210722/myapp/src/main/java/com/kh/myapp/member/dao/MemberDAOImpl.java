package com.kh.myapp.member.dao;

import java.lang.reflect.Member;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.myapp.member.dto.MemberDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
@RequiredArgsConstructor//멤버필드가 final인 필드를 매개변수로 하는 생성자를 자동 만들어준다.
public class MemberDAOImpl implements MemberDAO {
	
	private final JdbcTemplate jdbcTemplate;
	
	/**
	 * 회원가입
	 */
	@Override
	public int joinMember(MemberDTO memberDTO) {
		log.info("int joinMember(MemberDTO memberDTO) 호출됨!");
		log.info("id:{}, pwd:{}, nickname:{}",
				memberDTO.getId(),memberDTO.getPwd(),memberDTO.getNickname());
		
		
		String sql="insert into member values(?,?,?)";
		
		int result = jdbcTemplate.update(sql, 
																		memberDTO.getId(),
																		memberDTO.getPwd(),
																		memberDTO.getNickname());
		
		log.info("result:{}",result);
		return result;
	}
	//회원수정
	@Override
	public int modifyMember(MemberDTO memberDTO) {
		StringBuilder sql = new StringBuilder();
		sql.append("update member ");
		sql.append("  set pwd =?, ");
		sql.append("    nickname =? ");
		sql.append("  where id=? ");
		
		int rows = jdbcTemplate.update(
													sql.toString(),	
													memberDTO.getPwd(),
													memberDTO.getNickname(),
													memberDTO.getId());
		
		return rows;
	}
	//회원조회
	@Override
	public MemberDTO searchMember(String id) {
		StringBuilder sql = new StringBuilder();
		sql.append("select id,pwd,nickname ");
		sql.append("from member ");
		sql.append("where id=? ");
		
		MemberDTO memberDTO = jdbcTemplate.queryForObject(
				sql.toString(),
				new BeanPropertyRowMapper<>(MemberDTO.class),
				id);
		
		return memberDTO;
	}
	//회원삭제
	@Override
	public int deleteMember(String id) {
		StringBuilder sql = new StringBuilder();
		sql.append ("delete from member ");
    sql.append ("where id=? ");
    
    int rows=jdbcTemplate.update(sql.toString(), id);
    
		return rows;
	}
	//회원전체조회
	@Override
	public List<MemberDTO> memberList() {
		String sql = "select id,pwd,nickname from member ";
		List<MemberDTO> list = jdbcTemplate.query(
															sql, 
															new BeanPropertyRowMapper<>(MemberDTO.class));
		
		return list;
	}

}
