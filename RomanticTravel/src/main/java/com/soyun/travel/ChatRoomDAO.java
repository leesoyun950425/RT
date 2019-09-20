package com.soyun.travel;

import java.util.List;

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
	public ChatRoomDTO select(int num) {
		return mymy.selectOne("chatroomDAO.select",num);
	}
	
	public List<ChatRoomDTO> chatSelectAll() {
		return mymy.selectList("chatroomDAO.chatSelectAll");
	}
}
