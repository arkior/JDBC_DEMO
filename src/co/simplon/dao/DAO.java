package co.simplon.dao;

import java.util.List;

public interface  DAO<T> 
{

	public abstract void ajouter(T t);
	
	public abstract List<T>lister();
	
	public abstract boolean delete(T t);
	
	public abstract T find(int t);
	
	public abstract boolean update(T t);
}
