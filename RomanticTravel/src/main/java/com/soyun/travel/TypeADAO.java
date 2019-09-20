package com.soyun.travel;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TypeADAO {

	@Autowired
	SqlSessionTemplate mymy;
	
	public TypeADTO select(String leader) {
		return mymy.selectOne("typeADAO.select",leader);
	}
	
	public List<TypeADTO> typeASelectAll(String choice_public){
		return mymy.selectList("typeADAO.typeASelectAll",choice_public);
	}
}
