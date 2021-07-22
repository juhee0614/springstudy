package com.kh.myapp.member.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.myapp.member.dto.MemberDTO;
import com.kh.myapp.member.svc.MemberSVC;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member")
@Slf4j
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberSVC memberSVC;
	
	//회원가입양식 출력 (가져오는것은 get으로 하며, a양식으로 주로이용됨)
	@GetMapping("/joinForm")
	public String joinForm() {
		log.info("String joinForm() 호출!");
		
		
		return "member/joinForm";
	}
	//회원가입처리 (전송은 post로 하며 form 양식으로 주로이용됨)
	//@PostMapping("/join")
	public String join(@RequestParam String id,
										@RequestParam String pwd,
										@RequestParam String nickname) {
		log.info("String join() 호출!");
//		log.info("id:{}",id);
//		log.info("pwd:{}",pwd);
//		log.info("nickname:{}",nickname);
		
		log.info("id:{}, pwd:{}, nickname:{}",id,pwd,nickname);
		
		return "redirect:/";
	}
	
	//회원가입
	@PostMapping("/join")
	public String join2(MemberDTO memberDTO) {
		log.info("String join() 호출!");
//		log.info("id:{}",id);
//		log.info("pwd:{}",pwd);
//		log.info("nickname:{}",nickname);
		
		log.info("id:{}, pwd:{}, nickname:{}",
				memberDTO.getId(),memberDTO.getPwd(),memberDTO.getNickname());
		
		
		memberSVC.joinMember(memberDTO);
		
		return "redirect:/";
	}
	//회원수정
	@PostMapping("/modify")
	@ResponseBody
	public String modify(MemberDTO memberDTO) {
		String msg = "";
		
		int result = memberSVC.modifyMember(memberDTO);
		
		msg = (result==1)?"ok" :"nok";
		return msg; 
	}
	//회원조회
	@GetMapping("/one")
	@ResponseBody
	public String one(@RequestParam("id") String id) {
		MemberDTO memberDTO = memberSVC.searchMember(id);
		
		return memberDTO.toString();
	}
	//회원탈퇴
	@GetMapping("/delete")
	@ResponseBody
	public String del(@RequestParam("id") String id) {
		String msg ="";
		
		int result = memberSVC.deleteMember(id);
		msg = (result ==1)? "ok" :"nok";
		return msg;
	}
	//회원전체조회
	@GetMapping("/all")
	@ResponseBody
	public String all() {
		List<MemberDTO> list = memberSVC.memberList();
		
		return list.toString();
	}
	
}




