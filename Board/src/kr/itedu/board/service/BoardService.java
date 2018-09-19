package kr.itedu.board.service;

import java.util.ArrayList;

import kr.itedu.board.BoardVO;
import kr.itedu.board.common.BoardDAO;

public class BoardService {

	public ArrayList<BoardVO> getBoardList(int btype) {		
		ArrayList<BoardVO> data = null;
		BoardDAO dao = BoardDAO.getInstance();
		data = dao.getBoardList(btype);
		return data ;
	}
	
	public BoardVO getBoardDetail(int bid, int btype) {
		BoardVO vo = null;
		BoardDAO dao = BoardDAO.getInstance();
		vo = dao.getBoardDetail(bid, btype);
		return vo ;
	}
	
	public void boardInsert(String title, String content, int btype) {
		BoardDAO dao = BoardDAO.getInstance();
		dao.boardInsert(title, content, btype);
	}	
	
	public void boardUpdate(String title, String content, int btype, int bid) {
		BoardDAO dao = BoardDAO.getInstance();
		dao.boardUpdate(title, content, btype, bid);
	}
	
	public void boardDelete(int btype, int bid) {
		BoardDAO dao = BoardDAO.getInstance();
		dao.boardDelete(btype, bid);
	}
 }