package cn.test.service;

import cn.test.model.User;

public interface PasswordService {
	
	//�޸�����
	public Boolean passwordChange(User u ,String pwd1 ,String pwd2);

}
