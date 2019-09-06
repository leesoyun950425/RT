package com.soyun.travel;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ChatRoomDAO {

	@Autowired
	SqlSessionTemplate mymy;
	
	public ChatRoomDTO select(String leader) {
		return mymy.selectOne("chatroomDAO.select",leader);
	}
}
