package cn.test.service;

import java.util.List;

import cn.test.model.Message;


public interface SearchingService {

		//ͨ��������ң���ҳ��������б�
		public List<Message> getMessagesByTitle(String keyword,int currentPage, int pageSize);

		//ͨ��������ң��õ�������ҳ��
		public int getPageCountByTitle(String keyword,int pageSize);
	
}
