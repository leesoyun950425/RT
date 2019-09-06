package com.soyun.travel;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TypeADAO {

	@Autowired
	SqlSessionTemplate mymy;
	
	public TypeADTO select(String inputId) {
		return mymy.selectOne("typeADAO.select",inputId);
	}
}
