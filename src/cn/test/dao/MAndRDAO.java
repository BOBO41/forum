package cn.test.dao;

import java.util.List;

public interface MAndRDAO<T> {

	// ��ҳ�����ҵĻظ��б�p
	public List<T> getRelysByID(String id, int currentPage, int pageSize);

	// ������ҳ��
	public int getPageCount(String id, int pageSize);

}
