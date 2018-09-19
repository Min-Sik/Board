package kr.itedu.board.common;
	
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnector {
	
	public static Connection getConn() throws SQLException {
		Connection conn = null;
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/oracleDB");
			conn = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection c) {
		close(c, null, null);
	}
	
	public static void close(PreparedStatement p) {
		close(null, p, null);
	}
	
	public static void close(ResultSet r) {
		close(null, null, r);
	}
	
	public static void close(PreparedStatement p, ResultSet r) {
		close(null, p, r);
	}
	
	public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		if(conn!=null) {
			try { conn.close(); } catch (Exception e) {}
		}
		if(ps!=null) {
			try { ps.close(); } catch (Exception e) {}
		}
		if(rs!=null) {
			try { rs.close(); } catch (Exception e) {}
		}
	}
}