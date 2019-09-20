package com.soyun.travel;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatRoomController {

	MemberDTO memberDTO;
	ChatRoomDTO chatroomDTO;
	CourseDTO courseDTO;
	TypeADTO typeADTO;
	
	@Autowired
	ChatRoomDAO chatroomDAO;
	@Autowired
	MemberDAO memberDAO;
	@Autowired
	CourseDAO courseDAO;
	@Autowired
	TypeADAO typeADAO;
	@Autowired
	CompanionServiceImpl companion;

	// 동행자 신청 리스트
	@RequestMapping("companion")
	public void companion(Model model,HttpSession session) {
		model.addAttribute("companionResult", companion.companionList());
	}

	@RequestMapping("detail")
	public void detail(String leader, Model model) {
		List<ChatRoomDTO> list = chatroomDAO.chatSelectAll();
		String inputId = "";
		
		for (int i = 0; i < list.size(); i++) {
			leader = list.get(i).getLeader();
			String[] id = leader.split("_");
			inputId = id[1];
			
		}
		courseDTO = courseDAO.select(inputId);
		typeADTO = typeADAO.select(inputId);
		int days = Integer.parseInt(typeADTO.getDay_start());
		int term = days + typeADTO.getTravel_day();
		
		
		model.addAttribute("leader",leader);
		model.addAttribute("typeA", typeADTO);
		model.addAttribute("course", courseDTO);
		model.addAttribute("term", term);

	}
}
