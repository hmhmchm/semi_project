package test.com.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class BoardDeleteController
 */
@WebServlet({ "/login.do", "/logout.do", "/loginOK.do","/h_home.do" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("doGet:" + sPath);

		if (sPath.equals("/login.do")) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else if (sPath.equals("/logout.do")) {
			HttpSession session = request.getSession();
			session.removeAttribute("member_id");
			response.sendRedirect("login.do");
		} else if (sPath.equals("/h_home.do")) {
			request.getRequestDispatcher("main/main.jsp").forward(request, response);
		} 



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("doPost:" + sPath);

		if (sPath.equals("/loginOK.do")) {
			new LoginAction().execute(request, response);
		}
	}// end doPost

}
