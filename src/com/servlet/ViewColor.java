package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ViewColor
 */
@WebServlet("/viewColor.do")
public class ViewColor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewColor() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);

		if(session==null)
		{
			response.sendRedirect("index.html");
		}
		else
		{
			ArrayList<String> list=(ArrayList<String>)session.getAttribute("list");
			list.add((String)session.getAttribute("colorSelected"));
			session.setAttribute("list", list);

			PrintWriter pw=response.getWriter();
			pw.print("<html><body>");

			ArrayList<String> list1=(ArrayList<String>)session.getAttribute("list");
			for(String s:list1)
				pw.print("<br>"+s+"<br>");

			pw.print("<a href='index.html'> Index Page to add more color</a>");

			pw.print("<form action=\"signOut.do\" method=\"post\">" +
					"<input type=\"submit\" value=\"sign-out\"></form>");

			pw.print("</body></html>");



		}
	}

}
