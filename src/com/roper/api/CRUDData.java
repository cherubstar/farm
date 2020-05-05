package com.roper.api;

import java.util.List;

public interface CRUDData<T> {

	void deleteByUserName(String userName);
	
	void deleteByUserId(Integer id);
	
	T query(Object...index);
	
	T queryByUserName();
	
	List<T> queryAllByUserName();
}
