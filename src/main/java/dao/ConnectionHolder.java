package dao;

import java.sql.Connection;

public class ConnectionHolder {

    private static ThreadLocal<Connection> connection = new ThreadLocal<>();

    public static Connection getConnection() {
        return connection.get();
    }

    public static void setConnection(Connection con) {
        connection.set(con);
    }
}
