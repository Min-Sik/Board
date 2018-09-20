package kr.itedu.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.board.action.Action;
import kr.itedu.board.action.BoardDeleteAction;
import kr.itedu.board.action.BoardDetailAction;
import kr.itedu.board.action.BoardHomeAction;
import kr.itedu.board.action.BoardListAction;
import kr.itedu.board.action.BoardRegAction;

@WebServlet("*.bo")
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardFrontController() {
        super();       
    }
    
    protected void doProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	String reqURI = request.getRequestURI();
    	String ctxPath = request.getContextPath();
    	String comd = reqURI.substring(ctxPath.length());
    	ActionForward forward = null;
    	Action action = null;
    	
    	
    	if(comd.equals("/boardList.bo")) {
    		action = new BoardListAction();
    		try {
    			forward = action.execute(request, response);
    		} catch (Exception e) {
    			//TODO: 예외처리
    			e.printStackTrace();
    		}
    	} else if(comd.equals("/boardDetail.bo")) {
    		action = new BoardDetailAction();
    		try {
    			forward = action.execute(request, response);
    		} catch (Exception e) {
    			//TODO: 예외처리
    			e.printStackTrace();
    		}	
    	} else if(comd.equals("/boardReg.bo")) {
    		action = new BoardRegAction();
    		try {
    			forward = action.execute(request, response);
    		} catch (Exception e) {
    			//TODO: 예외처리
    			e.printStackTrace();
    		}	
    	} else if(comd.equals("/boardDelete.bo")) {
    		action = new BoardDeleteAction();
    		try {
    			forward = action.execute(request, response);
    		} catch (Exception e) {
    			//TODO: 예외처리
    			e.printStackTrace();
    		}
    	} else if(comd.equals("/home.bo")) {
    		action = new BoardHomeAction();
    		try {
    			forward = action.execute(request, response);
    		} catch (Exception e) {
    			//TODO: 예외처리
    			e.printStackTrace();
    		}
    	}
    	 	
    	if(forward!=null) {
    		if(forward.isRedirect()) {
    			response.sendRedirect(forward.getPath());
    		} else {
    			RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
    			rd.forward(request, response); 
    		}
    	}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request, response);
	}

}
