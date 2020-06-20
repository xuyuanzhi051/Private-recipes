package net.xyz.menuaction;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.xyz.entitys.Menu;
import net.xyz.service.MenuService;

/**
 * �������׵��������
 */
@WebServlet("/MenuDetailsServlet")
public class MenuDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MenuDetailsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ�������׵�����
		String menuName = request.getParameter("menuName");
		// ��ȡMenuService
		MenuService menuService = new MenuService();
		Menu menu = menuService.SearchMenuByMenuName(menuName);
		// ��ȡ�������
		PrintWriter writer = response.getWriter();
		writer.write("<h1 align='center'>��������</h1>");
		writer.write("<table border='1'>");
		writer.write("<tr align='center'>");
		writer.write("<th>����Id</th>");
		writer.write("<th>��������</th>");
		writer.write("<th>��������</th>");
		writer.write("<th>����ͼƬ</th>");
		writer.write("<th>����ԭ����</th>");
		writer.write("<th>���ײ���</th>");
		writer.write("</tr>");
		writer.write("<tr>");
		writer.write("<td>" + menu.getMenuId() + "</td>");
		writer.write("<td>" + menu.getMenuName() + "</td>");
		writer.write("<td>" + menu.getMenuType() + "</td>");
		writer.write("<td><img src='" + menu.getMenuImg() + "'></td>");
		writer.write("<td>" + menu.getMenuMaterial() + "</td>");
		writer.write("<td>" + menu.getMenuSteps() + "</td>");
		writer.write("</tr>");
		writer.write("</table>");
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
