package net.xyz.useraction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.xyz.entitys.User;
import net.xyz.service.UserService;

/**
 * ����չʾ�����û�����ϸ��Ϣ
 */
@WebServlet("/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserInfoServlet() {
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
		// ��ȡ�û���Ϣ
		UserService userService = new UserService();
		List<User> users = userService.getUsers();
		writer.write("<h1 align='center'>�û�����ģ��</h1>");
		writer.write("<table border='1' aligh='center'>");
		writer.write("<tr aligh='center'>");
		writer.write("<th>�û�ID</th>");
		writer.write("<th>�û��˺�</th>");
		writer.write("<th>�û�����</th>");
		writer.write("<th>ɾ���û�</th>");
		writer.write("</tr>");
		// չʾ�û���Ϣ
		for (User user : users) {
			writer.write("<tr align='center'>");
			writer.write("<td>" + user.getId() + "</td>");
			writer.write("<td>" + user.getUsername() + "</td>");
			writer.write("<td>" + user.getPassword() + "</td>");
			writer.write("<td><a href='DeleteUserServlet?userId=" + user.getId() + "'>ɾ���û�</a></td>");
			writer.write("</tr>");
		}
		writer.write("</table>");
		writer.write("<a href='searchUserByName.html'>�����û�</a>");
		writer.write("<a href='adminfunction.html'>������ҳ</a>");
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
