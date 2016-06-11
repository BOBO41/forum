package cn.test.service;

import java.util.List;

import cn.test.model.Message;

public interface MessageService {

	//��ҳ�õ������б�
	public List<Message> getMessages(int currentPage, int pageSize);

	//�õ���ҳ��
	public int getPageCount(int pageSize);
	
	//ͨ��messageid�õ�����
	public Message getMessage(String messageid);
	
	public void deleteMessage(String messageid);
	
	public void addMessage(String title,String article ,String id);

}
