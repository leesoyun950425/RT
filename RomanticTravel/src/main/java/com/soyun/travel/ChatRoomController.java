package com.soyun.travel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatRoomController {

	@Autowired
	ChatRoomDAO chatroomDAO;

	@Autowired
	MemberDAO memberDAO;

	@Autowired
	CourseDAO courseDAO;

	@Autowired
	TypeADAO typeADAO;

	@RequestMapping("companion")
	public void companion(String leader, String inputId, Model model) {
		CompanionDTO dto = new CompanionDTO();
		
		inputId = "asdf1";
		MemberDTO memberDTO = new MemberDTO();
		memberDTO = memberDAO.select(inputId);
		dto.setThumb(memberDTO.getThumb());

		leader = memberDTO.getName() + "_" + inputId;
		ChatRoomDTO chatroomDTO = chatroomDAO.select(leader);
		dto.setLeader(chatroomDTO.getLeader());
		String inwon = chatroomDTO.getMembers();
		if (inwon.contains(",")) {
			int in = inwon.split(",").length;
		} else {
			int in = 1;
			dto.setInwon(in);
			dto.setLimit(chatroomDTO.getLimitMember());
		}
		
		CourseDTO courseDTO = new CourseDTO();
		courseDTO = courseDAO.select(inputId);
		dto.setPlace_name(courseDTO.getPlace_name());
		
		TypeADTO typeADTO = new TypeADTO();
		typeADTO = typeADAO.select(inputId);
		int days = Integer.parseInt(typeADTO.getDay_start()); 
		int term = days+typeADTO.getTravel_day();
		dto.setStart(days);
		dto.setTerm(term);
		
		model.addAttribute("dto",dto);	
		
	}

	
}
