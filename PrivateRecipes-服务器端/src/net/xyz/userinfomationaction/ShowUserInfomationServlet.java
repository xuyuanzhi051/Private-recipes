package net.xyz.userinfomationaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.xyz.entitys.UserInfomation;
import net.xyz.service.UserInfomationService;

/**
 * 展示用户信息界面 根据用户传递过来的信息 来向客户端返回用户个人信息
 */
@WebServlet("/ShowUserInfomationServlet")
public class ShowUserInfomationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowUserInfomationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InputStream in = request.getInputStream();

		BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
		String userTel = reader.readLine();
		System.out.println("登录 用户的电话是" + userTel);
		// 获取UserInfomationService
		UserInfomationService userInfomationService = new UserInfomationService();
		UserInfomation userInfomation = userInfomationService.selectUserInfomationByTel(userTel);
		if (userInfomation != null) {

			System.out.println(userInfomation.toString());
			// 将用户信息拼接成字符串并返回给客户端
			String infomation = userInfomation.getUserTel() + "&&&" + userInfomation.getUserName() + "&&&"
					+ userInfomation.getUserImg() + "&&&" + userInfomation.getUserSex() + "&&&"
					+ userInfomation.getHobbys();
			response.getWriter().write(infomation);

		}
		// 关闭流
		in.close();
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
