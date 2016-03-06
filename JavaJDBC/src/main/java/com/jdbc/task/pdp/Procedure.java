package com.jdbc.task.pdp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Procedure {

	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/testjdbc";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "postgres";

	private static Connection getDBConnection() {
		Connection dbConnection = null;
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;

	}

	public static void main(String[] argv) {
		try {
			storedInsert();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void storedInsert() throws SQLException {

		Connection dbConnection = null;
		CallableStatement callableStatement = null;

		String insertStoreProc = "{call insertINnuser(?,?,?)}";

		try {
			dbConnection = getDBConnection();
			callableStatement = dbConnection.prepareCall(insertStoreProc);

			callableStatement.setInt(1, 115);
			callableStatement.setString(2, "Blah");
			callableStatement.setDate(3, new Date(System.currentTimeMillis()));

			callableStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (callableStatement != null) {
				callableStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
	}
}

