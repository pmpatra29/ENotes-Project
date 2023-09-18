package com.Db;

import java.sql.Connection;
import java.sql.DriverManager;

import static com.Db.DBInfo.driver;
import static com.Db.DBInfo.dbURL;
import static com.Db.DBInfo.uName;
import static com.Db.DBInfo.pWord;

public class DBConnection {
	private static Connection con;

	private DBConnection() {
	}

	static {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(dbURL, uName, pWord);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getCon() {
		return con;
	}
}
