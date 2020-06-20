package net.xyz.useraction;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.xyz.entitys.User;
import net.xyz.service.UserService;

/**
 * ͨ���ͻ����ύ���û����������ݿ��в�������
 */
@WebServlet("/SearchUserByNameServlet")
public class SearchUserByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchUserByNameServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ���������
		PrintWriter writer = response.getWriter();
		// ��ȡ�ͻ����ύ���û���

		String userName = request.getParameter("username");
		// ��ȡUserService
		UserService userService = new UserService();
		User user = userService.searchUserByname(userName);
		if (user == null) {
			writer.write("���û�������");
			return;
		}
		// ��ͻ��˷�����Ϣ
		writer.write("<h1 align='center'>�û���Ϣ</h1>");
		writer.write("<table border='1'");
		writer.write("<tr align='center'>");
		writer.write("<th>�û�id</th>");
		writer.write("<th>�û��˺�</th>");
		writer.write("<th>�û�����</th>");
		writer.write("</tr>");
		writer.write("<tr align='center'>");
		writer.write("<td>" + user.getId() + "</td>");
		writer.write("<td>" + user.getUsername() + "</td>");
		writer.write("<td>" + user.getPassword() + "</td>");
		writer.write("</tr>");
		writer.write("</table>");
		writer.write("<a href='UserInfoServlet'>����</a>");
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
