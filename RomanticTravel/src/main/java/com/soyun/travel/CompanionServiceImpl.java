package com.soyun.travel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanionServiceImpl {
	
	@Autowired
	TypeADAO typeADAO;
	@Autowired
	MemberDAO memberDAO;
	@Autowired
	CourseDAO courseDAO;
	
	public String companionList() {
		List<TypeADTO> list = typeADAO.typeASelectAll("공개");
		String companionListHtml = "";
		for (int i = 0; i < list.size(); i++) {
			TypeADTO typeADTO = list.get(i);
			MemberDTO memberDTO = memberDAO.select(typeADTO.getId());
			String[] courseStart = courseDAO.placeSelectStart(1).split(" ");
			String[] courseEnd = courseDAO.placeSelectEnd(typeADTO.getNo()).split(" ");
			
			String[] start = typeADTO.getDay_start().split(" ");
			String[] end = typeADTO.getDay_end().split(" ");
			
			companionListHtml += "<tr>\r\n" + 
					"		<td><img id='img' src='resources/img/"+memberDTO.getThumb()+"'></td>\r\n" + 
					"		<td>"+typeADTO.getId()+"</td>\r\n" + 
					"		<td>"+typeADTO.getCurrent_mem()+"/"+typeADTO.getMax_mem()+"</td>\r\n" + 
					"		<td>"+courseStart[0]+courseStart[1]+"</td>\r\n" + 
					"		<td>"+courseEnd[0]+courseEnd[1]+"</td>\r\n" + 
					"		<td>"+start[0]+"~"+end[0]+"</td>\r\n" + 
					"		<td><button class = 'detail' value = '"+typeADTO.getId()+"'>자세히보기</button>\r\n" + 
					"		<input type='hidden' value=''></td>\r\n" + 
					"	</tr>";
		}
		return companionListHtml;
	}
}
