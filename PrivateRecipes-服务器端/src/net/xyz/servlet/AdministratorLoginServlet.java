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
 * 检测管理员用户名密码是否正确
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
		// 获取请求参数
		String administratorName = request.getParameter("administratorname");
		String administratorPassword = request.getParameter("administratorpassword");
		// 构建一个管理员对象
		Administrator admin = new Administrator();
		admin.setAdministratorName(administratorName);
		admin.setAdministratorPassword(administratorPassword);
		// 获取AdminService
		AdministratorService adminService = new AdministratorService();
		if (adminService.isExistAdministrator(admin)) {// 存在此用户

			response.sendRedirect("adminfunction.html");
		} else {// 不存在此用户
			response.getWriter().write("登录失败");
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
