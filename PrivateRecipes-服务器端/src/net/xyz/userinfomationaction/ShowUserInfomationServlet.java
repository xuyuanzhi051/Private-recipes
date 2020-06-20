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
 * չʾ�û���Ϣ���� �����û����ݹ�������Ϣ ����ͻ��˷����û�������Ϣ
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
		System.out.println("��¼ �û��ĵ绰��" + userTel);
		// ��ȡUserInfomationService
		UserInfomationService userInfomationService = new UserInfomationService();
		UserInfomation userInfomation = userInfomationService.selectUserInfomationByTel(userTel);
		if (userInfomation != null) {

			System.out.println(userInfomation.toString());
			// ���û���Ϣƴ�ӳ��ַ��������ظ��ͻ���
			String infomation = userInfomation.getUserTel() + "&&&" + userInfomation.getUserName() + "&&&"
					+ userInfomation.getUserImg() + "&&&" + userInfomation.getUserSex() + "&&&"
					+ userInfomation.getHobbys();
			response.getWriter().write(infomation);

		}
		// �ر���
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
