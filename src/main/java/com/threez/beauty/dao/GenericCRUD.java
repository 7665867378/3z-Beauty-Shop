package com.threez.beauty.dao;

import java.util.List;


/*
 * NOTE: This is only created for software development and not part of the design. NOT IN DIAGRAMS
 * */
public interface GenericCRUD<E> {
	
	List<E> getAll();
	E get(E object);
	E getById(Integer id);
	E save(E object);
	E update(E object);
	E delete(E object);
}
