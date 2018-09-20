package kr.itedu.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.board.ActionForward;
import kr.itedu.board.common.Var;

public class BoardHomeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setPath(Var.TEMPLATE_1);
		
		request.setAttribute("title", "Home");
		request.setAttribute("content", "home");

		return forward;
	}
}
