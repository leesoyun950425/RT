package com.soyun.travel;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDAO {

	@Autowired
	SqlSessionTemplate mymy;
	
	public CourseDTO select(String inputId) {
		return mymy.selectOne("courseDAO.select",inputId);
	}
	
	public String placeSelectStart(int no) {
		return mymy.selectOne("courseDAO.placeSelectStart",no);
	}
	public String placeSelectEnd(int no) {
		return mymy.selectOne("courseDAO.placeSelectEnd",no);
	}
}
