package cn.test.service;

import java.util.List;

import cn.test.model.MAndR;
import cn.test.model.Reply;

public interface MAndRService {
	
	
	//��ҳ��ûظ��б�
	public List<MAndR> getReplys(String id,int currentPage, int pageSize);

	//�õ��ظ���ҳ��
	public int getPageCount(String id,int pageSize);
	
	public void deleteReply(String replyid);
	

}
