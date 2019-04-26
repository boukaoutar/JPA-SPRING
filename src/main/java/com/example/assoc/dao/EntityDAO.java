package com.example.assoc.dao;

import java.util.List;

public interface EntityDAO<T> {
	
	public T save(T p);
	public List<T> findAll();
	public T findOne(Integer id);
	public T update(T p);
	public void delete(Integer id);
	

}
