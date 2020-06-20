package net.xyz.menuaction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.xyz.entitys.Menu;
import net.xyz.service.MenuService;

/**
 * �����б�չʾҳ
 */
@WebServlet("/MenuInfoServlet")
public class MenuInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MenuInfoServlet() {
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
		PrintWriter writer = response.getWriter();
		// ��ȡMenuService
		MenuService menuService = new MenuService();
		List<Menu> menus = menuService.getMenus();
		// ��ӡ���

		writer.write("<h1 align='center'>����ģ��</h1>");
		writer.write("<table border='1' align='center'>");
		writer.write("<tr align='center'>");
		writer.write("<th>����id</th>");
		writer.write("<th>��������</th>");
		writer.write("<th>��������</th>");
		writer.write("<th>�����޸�</th>");
		writer.write("<th>ɾ������</th>");
		writer.write("</tr>");
		for (Menu menu : menus) {
			writer.write("<tr >");
			writer.write("<td>" + menu.getMenuId() + "</td>");
			writer.write("<td>" + menu.getMenuName() + "</td>");
			writer.write("<td><a href='MenuDetailsServlet?menuName=" + menu.getMenuName() + "'>�������</a></td>");
			writer.write("<td><a href='updateMenuById.jsp?menuId=" + menu.getMenuId() + "'>�����޸�</a></td>");
			writer.write("<td><a href='DeleteMenuServlet?menuId=" + menu.getMenuId() + "'>ɾ��</a></td>");
			writer.write("</tr>");
		}
		writer.write("</table>");
		writer.write("<a href='addNewMenu.html'>��������</a>");
		writer.write("</br>");
		writer.write("<a href='searchMenuByName.html'>��������</a>");
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
