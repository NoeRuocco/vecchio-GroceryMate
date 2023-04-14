/*

    Il costruttore della classe è stato reso privato per impedire l'istanziazione della classe al di fuori della classe stessa.
    La variabile `instance` è stata dichiarata come statica e privata, in modo che solo la classe stessa possa accedervi.

 */

package com.example.grocerymate.database;

import java.sql.*;

public class ConnectionDB {
    private static ConnectionDB instance;
    private static Connection connection;
    private static final String url = "jdbc:mysql://localhost:3306/grocerymate";
    private static final String user = "root";
    private static final String password = "12345678";

    private ConnectionDB() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }

    public static ConnectionDB getInstance() {
        if (instance == null) {
            instance = new ConnectionDB();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
