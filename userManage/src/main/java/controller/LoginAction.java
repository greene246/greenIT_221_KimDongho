package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.UserDAO;
import user.UserDTO;

/**
 * Servlet implementation class LoginAction
 */
// @WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// doGet() �޼ҵ� : http request method - GET
		
		UserDAO dao = UserDAO.getInstance();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// UserDAO�� ���� addUser(UserDTO userDto);
		// UserDTO user = new UserDTO(name);
		// dao.addUser(user);
		
		UserDTO user = new UserDTO(id, pw);
		
		// UserDAO�� ���� getUser
		
		// �Ķ���� ���� �ĺ��ϰ�,
		// ������ ������ ���� ó���� �и��� �� ����
		String url = "";
		if(dao.loginUser(user) != null){
			// session.setAttribute("log", user.getUserCode());
			HttpSession session = request.getSession();
			session.setAttribute("log", url);
			// url = "_03_main.jsp";
			url = "./main";
		}
		else{
			System.out.println("�α��ν���");
			url = "_00_login.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// doPost() �޼ҵ� : http request method - GET
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
