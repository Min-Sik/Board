package kr.itedu.board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.board.ActionForward;
import kr.itedu.board.BoardVO;
import kr.itedu.board.CommentVO;
import kr.itedu.board.common.Utils;
import kr.itedu.board.common.Var;
import kr.itedu.board.service.BoardService;
public class BoardDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setPath(Var.TEMPLATE_1);
		
		int btype = Utils.getParamInt(request.getParameter("btype"));
		int bid = Utils.getParamInt(request.getParameter("bid"));
		
		BoardService service = new BoardService();
		BoardVO vo = service.getBoardDetail(bid, btype);
		ArrayList<CommentVO> data = service.getComment(bid, btype);
		request.setAttribute("title", "게시글");
		request.setAttribute("content", "boardDetail");
		request.setAttribute("vo", vo);
		request.setAttribute("data", data);
		
		return forward;
	}
}
