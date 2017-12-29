package dao;

import exception.DBException;

import java.sql.Connection;

public interface DaoFactory {

    UserDao getUserDao();

}
