package kr.itedu.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.board.ActionForward;
import kr.itedu.board.common.Utils;
import kr.itedu.board.service.BoardService;

public class BoardCommentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		int bid = Utils.getParamInt(request.getParameter("bid"));
		int btype = Utils.getParamInt(request.getParameter("btype"));
		String t_comment = request.getParameter("t_comment");
		
		BoardService service = new BoardService();		
		service.boardComment(bid, btype, t_comment);
		forward.setPath("boardDetail.bo?btype=" + btype + "&bid=" + bid);
		forward.setRedirect(true);	
		
		return forward;
	}

}
