package kr.itedu.board.common;

import static kr.itedu.board.common.DBConnector.close;
import static kr.itedu.board.common.DBConnector.getConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.itedu.board.BoardVO;

public class BoardDAO {
	
	private static BoardDAO dao;
	
	private BoardDAO() {} //private 생성자
	
	public static BoardDAO getInstance() { //싱글톤 : 하나의 객체만 생성
		if(dao==null) {
			dao = new BoardDAO();
		}
		return dao;
	}
	
	public ArrayList<BoardVO> getBoardList(int btype) {
		ArrayList<BoardVO> data = new ArrayList<BoardVO>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;		
		String query = " select * from t_board" + btype + " order by bid desc ";
		
		try {
			conn = getConn();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBid(rs.getInt("bid"));
				vo.setBtitle(rs.getString("btitle"));
				vo.setBcontent(rs.getString("bcontent"));
				vo.setBregdate(rs.getString("bregdate"));
				data.add(vo);
			}
		} catch (SQLException e) {
			
		} catch (Exception e) {
			
		} finally {
			close(conn, ps, rs);
		}
		return data;
	}
	
	public BoardVO getBoardDetail(int bid, int btype) {
		BoardVO vo = new BoardVO();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;		
		String query = " select * from t_board" + btype + " where bid = " + bid;
		
		try {
			conn = getConn();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				vo.setBid(rs.getInt("bid"));
				vo.setBtitle(rs.getString("btitle"));
				vo.setBcontent(rs.getString("bcontent"));
				vo.setBregdate(rs.getString("bregdate"));
			}
		} catch (SQLException e) {
			
		} catch (Exception e) {
			
		} finally {
			close(conn, ps, rs);
		}
		return vo;
	}
	
	public void boardInsert(String title, String content, int btype) {
		Connection conn = null;
		PreparedStatement ps = null;		
		String query = " insert into t_board" + btype + " (bid, btitle, bcontent) values "
				+ " ((select nvl(max(bid), 0)+1 from t_board" + btype +"), ? , ?) ";
		
		try {
			conn = getConn();
			ps = conn.prepareStatement(query);
			ps.setString(1, title);
			ps.setString(2, content);
			ps.executeQuery();
		} catch (SQLException e) {

		} catch (Exception e) {
			
		} finally {
			close(conn, ps);
		}
	}
	
	public void boardUpdate(String title, String content, int btype, int bid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;		
		String query = " update t_board" + btype + " set  btitle = ?, bcontent = ? "
				+ " where bid = ? ";
		
		try {
			conn = getConn();
			ps = conn.prepareStatement(query);
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setInt(3, bid);
			rs = ps.executeQuery();
		} catch (SQLException e) {

		} catch (Exception e) {
			
		} finally {
			close(conn, ps, rs);
		}
	}
	
	public void boardDelete(int btype, int bid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;		
		String query = " delete from t_board" + btype + " where bid = " + bid;
		
		try {
			conn = getConn();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

		} catch (SQLException e) {
			
		} catch (Exception e) {
			
		} finally {
			close(conn, ps, rs);
		}
	}
	
	public int boardPage(int btype) {
		int result = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;		
		String query = " select count(*) from t_board" + btype;
		
		try {
			conn = getConn();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("count(*)");
			}
		} catch (SQLException e) {
			
		} catch (Exception e) {
			
		} finally {
			close(conn, ps, rs);
		}
		return result;
	}
	
	public ArrayList<BoardVO> getBoardPage(int btype, int page) {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		String query = " select * from ( " +
						"	select rownum as rnum, z.* from ( " +
						" 		select * from t_board" + btype +
						" 		order by bid desc " +
						"	) z where rownum <= ? "
						+ ") where rnum >= ? ";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;		
	
		try {
			conn = getConn();
			ps = conn.prepareStatement(query);
			ps.setInt(1, page*10);
			ps.setInt(2, (page-1)*10+1);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBid(rs.getInt("bid"));
				vo.setBtitle(rs.getString("btitle"));
				vo.setBcontent(rs.getString("bcontent"));
				vo.setBregdate(rs.getString("bregdate"));
				list.add(vo);
			}
		} catch (SQLException e) {
			
		} catch (Exception e) {
			
		} finally {
			close(conn, ps, rs);
		}
		return list;
	}
}
