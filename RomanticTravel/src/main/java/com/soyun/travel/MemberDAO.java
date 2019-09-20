package com.soyun.travel;

import java.util.List;

import javax.mail.Session;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	@Autowired
	SqlSessionTemplate mymy;
	
	public void insert(MemberDTO memberDTO) {
		mymy.insert("memberDAO.insert",memberDTO);
	}
	
	public MemberDTO select(String inputId) {
		return mymy.selectOne("memberDAO.select",inputId);
	}
	
	public List<MemberDTO> selectCompanion2(MemberDTO inputId) {
		return mymy.selectList("memberDAO.select",inputId);
	}
	
	public int selectCnt(MemberDTO memberDTO) {
		return mymy.selectOne("memberDAO.selectCnt",memberDTO);
	}
	public int selectCnt2(MemberDTO memberDTO) {
		return mymy.selectOne("memberDAO.selectCnt2",memberDTO);
	}
	public int selectCnt3(String inputId) {
		return mymy.selectOne("memberDAO.selectCnt3",inputId);
	}
	public MemberDTO selectId(MemberDTO memberDTO) {
		return mymy.selectOne("memberDAO.selectId",memberDTO);
	}
	public MemberDTO selectPw(MemberDTO memberDTO) {
		return mymy.selectOne("memberDAO.selectPw",memberDTO);
	}
	public void update(String id) {
		mymy.update("memberDAO.update",id);
	}
	public void updatePw(MemberDTO memberDTO) {
		mymy.update("memberDAO.updatePw",memberDTO);
	}
	public void updateAll(MemberDTO memberDTO) {
	      mymy.update("memberDAO.updateAll",memberDTO);
	   }
	public void delete(String inputId) {
		mymy.delete("memberDAO.delete",inputId);
	}
	
	public List<String> selectAll(){
		return mymy.selectList("memberDAO.selectAll");
	}
	
	public void userAuth(String email) {
		mymy.update("memberDAO.memberAuth", email);
	}
}
