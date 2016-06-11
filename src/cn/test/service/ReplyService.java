package cn.test.service;

import java.util.List;


import cn.test.model.Reply;

public interface ReplyService {
	
	//��ҳ��ûظ��б�
	public List<Reply> getReplys(String messageid,int currentPage, int pageSize);

	//�õ��ظ���ҳ��
	public int getPageCount(String messageid,int pageSize);
	
	//��ӻظ�
	public void addReply(String id,String messageid,String replymessage);
	
	public void deleteReply(String replyid);

}
