package fr.fms.dao;

import java.sql.Connection;
import java.util.ArrayList;

import exBDD.BddConnection;


public interface Dao<T> {
public Connection connection = BddConnection.getConnection();
public void create (T obj);
public T selectById(int id);
public boolean update (T obj);
public boolean delete (T obj);
public ArrayList<T> readAll();
}
