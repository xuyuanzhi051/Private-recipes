package net.xyz.userinfomationaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.xyz.entitys.UserInfomation;
import net.xyz.service.UserInfomationService;

/**
 * 更新用户个人信息
 */
@WebServlet("/UpdateUserInfomationServlet")
public class UpdateUserInfomationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUserInfomationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取用户提交的字符串信息,解析为UserInfomation对象，并把提交后的修改更新到数据库
		InputStream in = request.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
		String infomation = reader.readLine();
		System.out.println(infomation);
		String infomations[] = infomation.split("&&&");
		// 将获取到的信息封装成一个UserInfomation对象
		UserInfomation userInfomation = new UserInfomation();
		userInfomation.setUserTel(infomations[0]);
		userInfomation.setUserName(infomations[1]);
		userInfomation.setUserSex(infomations[2]);
		userInfomation.setHobbys(infomations[3]);
		// 获取UserInfomationService
		UserInfomationService userInfomationService = new UserInfomationService();
		int b = userInfomationService.updateUserInfomationServiceByTel(userInfomation);
		if (b != 0) {
			System.out.println("更改成功");
		} else {
			System.out.println("更改失败");
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
