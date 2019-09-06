package com.soyun.travel;

public class ChatRoomDTO {
	private String members;
	private String chatRoomName;
	private String createTime;
	private int chatRoomNum;
	private int limitMember;
	private String leader;
	private String thumbnail;
	
	public String getMembers() {
		return members;
	}
	public void setMembers(String members) {
		this.members = members;
	}
	public String getChatRoomName() {
		return chatRoomName;
	}
	public void setChatRoomName(String chatRoomName) {
		this.chatRoomName = chatRoomName;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public int getChatRoomNum() {
		return chatRoomNum;
	}
	public void setChatRoomNum(int chatRoomNum) {
		this.chatRoomNum = chatRoomNum;
	}
	public int getLimitMember() {
		return limitMember;
	}
	public void setLimitMember(int limitMember) {
		this.limitMember = limitMember;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
}
