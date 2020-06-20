package net.xyz.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.xyz.entitys.Administrator;
import net.xyz.service.AdministratorService;

/**
 * ������Ա�û��������Ƿ���ȷ
 */
@WebServlet("/AdministratorLoginServlet")
public class AdministratorLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdministratorLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ�������
		String administratorName = request.getParameter("administratorname");
		String administratorPassword = request.getParameter("administratorpassword");
		// ����һ������Ա����
		Administrator admin = new Administrator();
		admin.setAdministratorName(administratorName);
		admin.setAdministratorPassword(administratorPassword);
		// ��ȡAdminService
		AdministratorService adminService = new AdministratorService();
		if (adminService.isExistAdministrator(admin)) {// ���ڴ��û�

			response.sendRedirect("adminfunction.html");
		} else {// �����ڴ��û�
			response.getWriter().write("��¼ʧ��");
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
