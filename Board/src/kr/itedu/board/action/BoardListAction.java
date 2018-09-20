package kr.itedu.board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.board.ActionForward;
import kr.itedu.board.BoardVO;
import kr.itedu.board.common.Utils;
import kr.itedu.board.common.Var;
import kr.itedu.board.service.BoardService;

public class BoardListAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		ActionForward forward = new ActionForward();
		forward.setPath(Var.TEMPLATE_1);
		
		BoardService service = new BoardService();
		int btype = Utils.getParamInt(request.getParameter("btype"));
		int page = Utils.getParamInt(request.getParameter("page"));
		int pageLimit = service.boardPage(btype);

		ArrayList<BoardVO> data = service.getBoardPage(btype, page);
		
		request.setAttribute("page", page);
		request.setAttribute("title", Var.TITLES[btype-1]);
		request.setAttribute("content", "boardList");
		request.setAttribute("data", data);
		request.setAttribute("pageLimit", pageLimit);
	
		return forward;
	}
}
