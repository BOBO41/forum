package cn.test.dao;

import java.util.List;

public interface UserDAO<T> {

	// �����û�
	T getById(String id);

	// id�����û�
	public List<T> getUsersById(String id);

	// ����û�
	public void addUser(T t);

	// �޸�����
	public void updateUser(T t);
}
