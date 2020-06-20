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
 * 通过客户端提交的用户名来向数据库中查找数据
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
		// 获取输出流对象
		PrintWriter writer = response.getWriter();
		// 获取客户端提交的用户名

		String userName = request.getParameter("username");
		// 获取UserService
		UserService userService = new UserService();
		User user = userService.searchUserByname(userName);
		if (user == null) {
			writer.write("该用户不存在");
			return;
		}
		// 向客户端返回信息
		writer.write("<h1 align='center'>用户信息</h1>");
		writer.write("<table border='1'");
		writer.write("<tr align='center'>");
		writer.write("<th>用户id</th>");
		writer.write("<th>用户账号</th>");
		writer.write("<th>用户密码</th>");
		writer.write("</tr>");
		writer.write("<tr align='center'>");
		writer.write("<td>" + user.getId() + "</td>");
		writer.write("<td>" + user.getUsername() + "</td>");
		writer.write("<td>" + user.getPassword() + "</td>");
		writer.write("</tr>");
		writer.write("</table>");
		writer.write("<a href='UserInfoServlet'>返回</a>");
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
