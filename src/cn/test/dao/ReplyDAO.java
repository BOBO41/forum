package cn.test.dao;

import java.util.List;

public interface ReplyDAO<T> {

	//ͨ������id���ظ����µĻظ��б�
	public List<T> getReplys(String messageid);

	//��ҳ���ػظ��б�
	public List<T> getPageByReplys(String messageid,int currentPage, int pageSize);

	//������ҳ��
	public int getPageCount(String messageid,int pageSize);
	
	//���ӻظ�
	public void add(T t); 
	
	public void delete(T t); 
	
	public void deleteReplys(String messageid); 
	

}
