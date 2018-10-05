package kr.itedu.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kr.itedu.board.ActionForward;
import kr.itedu.board.common.Utils;
import kr.itedu.board.service.BoardService;

public class CommentDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		int bid = Utils.getParamInt(request.getParameter("bid"));
		int cid = Utils.getParamInt(request.getParameter("cid"));
		int btype = Utils.getParamInt(request.getParameter("btype"));
		
		BoardService service = new BoardService();
		service.commentDelete(cid);
		
		forward.setPath("boardDetail.bo?btype=" + btype + "&bid=" + bid);
		forward.setRedirect(true);
		
		return forward;
	}
}
