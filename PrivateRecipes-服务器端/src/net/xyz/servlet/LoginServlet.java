package net.xyz.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.xyz.entitys.User;
import net.xyz.service.UserService;

/**
 * �û���¼����,��¼�ɹ�����1����¼ʧ�ܷ���-1
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ�û���������
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		// ����һ���û�����
		User user = new User();
		user.setUsername(userName);
		System.out.println(userName);
		user.setPassword(passWord);
		System.out.println(passWord);
		UserService userService = new UserService();
		User flag = userService.login(user);
		if (flag != null) {
			response.getWriter().write("1");
		} else {
			response.getWriter().write("-1");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
