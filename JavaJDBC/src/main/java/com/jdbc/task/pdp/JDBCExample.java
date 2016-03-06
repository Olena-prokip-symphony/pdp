package com.jdbc.task.pdp;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JDBCExample {

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
			createDbUserTable();
			insertRecordIntoDbUserTable();
			// selectRecordsFromDbUserTable();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void createDbUserTable() throws SQLException {

		Connection dbConnection = null;
		Statement statement = null;

		String createTableSQL = "CREATE table IF NOT EXISTS public.nuser (" + "nuser_id bigserial NOT NULL, "
				+ "name character varying(20) NOT NULL, " + "created_on timestamp NOT NULL, "
				+ "PRIMARY KEY (nuser_id) " + ")";

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			statement.execute(createTableSQL);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
	}

	private static void insertRecordIntoDbUserTable() throws SQLException {
		Connection dbConnection = null;
		Statement statement = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yy");
		String insertTableSQL = "INSERT INTO public.nuser"
				+ "(nuser_id, name, created_on) values ( 10, 'Olena', to_date('" + simpleDateFormat.format(new Date())
				+ "', 'dd/mm/yy'))";

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			statement.executeUpdate(insertTableSQL);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}

	}

	private static void selectRecordsFromTable() throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "SELECT nuser_id, name FROM nuser WHERE nuser_id = ?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, 1);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				String userid = rs.getString("nuser_id");
				String username = rs.getString("name");

				System.out.println("nuser_id : " + userid);
				System.out.println("name : " + username);

			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}

}