package cn.test.dao;

public interface BaseDAO<T> {
	// ���
	public void add(T t);

	// ��ѯ
	public T get(T t);

	// ɾ��
	public void delete(T t);

	// ����
	public void update(T t);

}
