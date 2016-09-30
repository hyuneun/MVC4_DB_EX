package kr.co.c;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파일명으로 받기
		String ss = request.getRequestURI();
		int idx = ss.lastIndexOf("/");
		StringTokenizer st = new StringTokenizer(ss.substring(idx + 1), ".");
		ss = st.nextToken();
		String command = ss;
		
		String buser = request.getParameter("buser");
		
		BuserInter inter = null;
		SawonInter inter2 = null;
		String prefix = "/view/";
		String surfix = ".jsp";
		String viewName = "";
		
		try {
			if(command.equals("buser")){
				inter = BuserImpl.Instance();
				viewName = prefix + inter.showData(request, response) + surfix;
				request.getRequestDispatcher(viewName).forward(request, response);
			}else if(command.equals("sawon")){
				inter2 = SawonImpl.Instance();
				viewName = prefix + inter2.showData(request, response, buser) + surfix;
				request.getRequestDispatcher(viewName).forward(request, response);
			}
		} catch (Exception e) {
			
		}
	}

}
