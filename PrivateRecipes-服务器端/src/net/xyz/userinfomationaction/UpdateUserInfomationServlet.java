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
 * �����û�������Ϣ
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
		// ��ȡ�û��ύ���ַ�����Ϣ,����ΪUserInfomation���󣬲����ύ����޸ĸ��µ����ݿ�
		InputStream in = request.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
		String infomation = reader.readLine();
		System.out.println(infomation);
		String infomations[] = infomation.split("&&&");
		// ����ȡ������Ϣ��װ��һ��UserInfomation����
		UserInfomation userInfomation = new UserInfomation();
		userInfomation.setUserTel(infomations[0]);
		userInfomation.setUserName(infomations[1]);
		userInfomation.setUserSex(infomations[2]);
		userInfomation.setHobbys(infomations[3]);
		// ��ȡUserInfomationService
		UserInfomationService userInfomationService = new UserInfomationService();
		int b = userInfomationService.updateUserInfomationServiceByTel(userInfomation);
		if (b != 0) {
			System.out.println("���ĳɹ�");
		} else {
			System.out.println("����ʧ��");
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
