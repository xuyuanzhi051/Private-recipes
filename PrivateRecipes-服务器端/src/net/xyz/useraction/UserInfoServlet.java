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
 * 用于展示所有用户的详细信息
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
		// 获取网络输出流
		PrintWriter writer = response.getWriter();
		// 获取用户信息
		UserService userService = new UserService();
		List<User> users = userService.getUsers();
		writer.write("<h1 align='center'>用户管理模块</h1>");
		writer.write("<table border='1' aligh='center'>");
		writer.write("<tr aligh='center'>");
		writer.write("<th>用户ID</th>");
		writer.write("<th>用户账号</th>");
		writer.write("<th>用户密码</th>");
		writer.write("<th>删除用户</th>");
		writer.write("</tr>");
		// 展示用户信息
		for (User user : users) {
			writer.write("<tr align='center'>");
			writer.write("<td>" + user.getId() + "</td>");
			writer.write("<td>" + user.getUsername() + "</td>");
			writer.write("<td>" + user.getPassword() + "</td>");
			writer.write("<td><a href='DeleteUserServlet?userId=" + user.getId() + "'>删除用户</a></td>");
			writer.write("</tr>");
		}
		writer.write("</table>");
		writer.write("<a href='searchUserByName.html'>搜索用户</a>");
		writer.write("<a href='adminfunction.html'>返回首页</a>");
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
