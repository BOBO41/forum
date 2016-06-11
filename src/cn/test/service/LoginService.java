package cn.test.service;

import java.util.List;

import cn.test.model.Message;
import cn.test.model.User;

public interface LoginService {
	
	//��½У�飬����user�������session
    public User loginCheck(User user);
    
    //�õ������б����ڵ�½��ĳ�����ת
    public List<Message> getMessages(int currentPage, int pageSize ) ;
    
    //�õ���ҳ�������ڵ�½��ĳ�����ת
    public int getPageCount(int pageSize );
}
