package net.xyz.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.xyz.entitys.User;
import net.xyz.service.UserInfomationService;
import net.xyz.service.UserService;

/**
 * 注册新用户
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取客户端提交的信息
		InputStream in = request.getInputStream();
		BufferedReader read = new BufferedReader(new InputStreamReader(in, "utf-8"));
		String str = read.readLine();
		System.out.println(str);
		if (str != null) {
			String info[] = str.split(",");
			System.out.println(info[0]);
			System.out.println(info[1]);
			// 获取提交的数据
			String userName = info[0];
			String passWord = info[1];
			// 封装成一个用户对象
			User user = new User();
			user.setUsername(userName);
			user.setPassword(passWord);
			// 注册新用户
			UserService userService = new UserService();
			if (userService.registUser(user)) {
				// 根据注册的用户名获取用户的id
				User user1 = userService.searchUserByname(userName);
				// 向userInfomation中添加此条用户的信息
				// 获取UserInfomationService
				UserInfomationService userInfomationService = new UserInfomationService();
				userInfomationService.adduserInfomation(user1.getId(), userName);
				response.getWriter().write("注册成功");
			} else {
				response.getWriter().write("注册失败");
			}
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
