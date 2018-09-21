package kr.itedu.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.board.ActionForward;
import kr.itedu.board.BoardVO;
import kr.itedu.board.common.Utils;
import kr.itedu.board.common.Var;
import kr.itedu.board.service.BoardService;

public class BoardRegAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setPath(Var.TEMPLATE_1);
		
		int bid = Utils.getParamInt(request.getParameter("bid"));
		int btype = Utils.getParamInt(request.getParameter("btype"));
		int reg = Utils.getParamInt(request.getParameter("reg"));
		if(reg==0) {
				request.setAttribute("title", "글쓰기");
				request.setAttribute("content", "boardReg");		
			if(bid==0) {} 
			else {
				BoardService service = new BoardService();
				BoardVO vo = service.getBoardDetail(bid, btype);
				request.setAttribute("vo", vo);				
			}
		} else {
			if(bid==0) {
				String title = request.getParameter("btitle");
				String content = request.getParameter("bcontent");
				
				BoardService service = new BoardService();
				service.boardInsert(title, content, btype);		
				forward.setPath("boardList.bo?page=1&btype=" + btype);
				forward.setRedirect(true);			
			} else {
				String title = request.getParameter("btitle");
				String content = request.getParameter("bcontent");
				
				BoardService service = new BoardService();
				service.boardUpdate(title, content, btype, bid);		
				forward.setPath("boardList.bo?page=1&btype=" + btype);
				forward.setRedirect(true);	
			}
		}
		return forward;
	}
}
