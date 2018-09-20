package kr.itedu.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.board.ActionForward;
import kr.itedu.board.common.Utils;
import kr.itedu.board.service.BoardService;

public class BoardDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		int bid = Utils.getParamInt(request.getParameter("bid"));
		int btype = Utils.getParamInt(request.getParameter("btype"));
		
		BoardService service = new BoardService();
		service.boardDelete(btype, bid);
		forward.setPath("boardList.bo?page=1&btype=" + btype);
		forward.setRedirect(true);
		return forward;
	}


}
