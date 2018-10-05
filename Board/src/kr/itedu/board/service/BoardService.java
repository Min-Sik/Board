package kr.itedu.board.service;

import java.util.ArrayList;

import kr.itedu.board.BoardVO;
import kr.itedu.board.CommentVO;
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
	
	public int boardPage(int btype) {
		BoardDAO dao = BoardDAO.getInstance();
		int result = dao.boardPage(btype);
		if(result%10==0) {
			return result/10;
		} else {
			return result/10 + 1;
		}
	}
	
	public void commentInsert(int bid, int btype, String t_comment) {
		BoardDAO dao = BoardDAO.getInstance();
		dao.commentInsert(bid, btype, t_comment);
	}
	
	public ArrayList<BoardVO> getBoardPage(int btype, int page) {
		ArrayList<BoardVO> data = null;
		BoardDAO dao = BoardDAO.getInstance();
		data = dao.getBoardPage(btype, page);
		return data ;
	}
	
	public ArrayList<CommentVO> getComment(int bid, int btype) {
		BoardDAO dao = BoardDAO.getInstance();
		ArrayList<CommentVO> list = dao.getComment(bid, btype);
		return list;
	}
	
	public void commentDelete(int cid) {
		BoardDAO dao = BoardDAO.getInstance();
		dao.commentDelete(cid);
	}
	
	public void commentDeleteAll(int bid) {
		BoardDAO dao = BoardDAO.getInstance();
		dao.commentDeleteAll(bid);
	}
 }
