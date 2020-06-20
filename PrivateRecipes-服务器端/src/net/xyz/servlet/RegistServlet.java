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
 * ע�����û�
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

		// ��ȡ�ͻ����ύ����Ϣ
		InputStream in = request.getInputStream();
		BufferedReader read = new BufferedReader(new InputStreamReader(in, "utf-8"));
		String str = read.readLine();
		System.out.println(str);
		if (str != null) {
			String info[] = str.split(",");
			System.out.println(info[0]);
			System.out.println(info[1]);
			// ��ȡ�ύ������
			String userName = info[0];
			String passWord = info[1];
			// ��װ��һ���û�����
			User user = new User();
			user.setUsername(userName);
			user.setPassword(passWord);
			// ע�����û�
			UserService userService = new UserService();
			if (userService.registUser(user)) {
				// ����ע����û�����ȡ�û���id
				User user1 = userService.searchUserByname(userName);
				// ��userInfomation����Ӵ����û�����Ϣ
				// ��ȡUserInfomationService
				UserInfomationService userInfomationService = new UserInfomationService();
				userInfomationService.adduserInfomation(user1.getId(), userName);
				response.getWriter().write("ע��ɹ�");
			} else {
				response.getWriter().write("ע��ʧ��");
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
