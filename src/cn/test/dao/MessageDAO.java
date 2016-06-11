package cn.test.dao;

import java.util.List;

public interface MessageDAO<T> {
	
	//�������������б�
	public List<T> getAllMessages() ;
	
	//�������
	public void addMessage(T t) ;
	
	//��ҳ�������������б�
	public List<T> getPageByMessages(int currentPage, int pageSize) ;
	
	//ͨ��ÿҳ��С������ҳ��
	public int getPageCount(int pageSize) ;
	
	//ͨ��id��������
	public T getById(String id);
	
	public void deleteById(T t);
	
	//���ݱ����ҳ�������������б�
	public List<T> getPageByMessagesByTitle(String keyword, int currentPage, int pageSize) ;
	
	//���ݱ���ͨ��ÿҳ��С������ҳ��
	public int getPageCountByTitle(String keyword, int pageSize) ;
	 
}
