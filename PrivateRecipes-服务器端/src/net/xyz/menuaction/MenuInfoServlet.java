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
 * 菜谱列表展示页
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
		// 获取输出对象
		PrintWriter writer = response.getWriter();
		// 获取MenuService
		MenuService menuService = new MenuService();
		List<Menu> menus = menuService.getMenus();
		// 打印表格

		writer.write("<h1 align='center'>菜谱模块</h1>");
		writer.write("<table border='1' align='center'>");
		writer.write("<tr align='center'>");
		writer.write("<th>菜谱id</th>");
		writer.write("<th>菜谱名称</th>");
		writer.write("<th>菜谱详情</th>");
		writer.write("<th>菜谱修改</th>");
		writer.write("<th>删除菜谱</th>");
		writer.write("</tr>");
		for (Menu menu : menus) {
			writer.write("<tr >");
			writer.write("<td>" + menu.getMenuId() + "</td>");
			writer.write("<td>" + menu.getMenuName() + "</td>");
			writer.write("<td><a href='MenuDetailsServlet?menuName=" + menu.getMenuName() + "'>详情介绍</a></td>");
			writer.write("<td><a href='updateMenuById.jsp?menuId=" + menu.getMenuId() + "'>菜谱修改</a></td>");
			writer.write("<td><a href='DeleteMenuServlet?menuId=" + menu.getMenuId() + "'>删除</a></td>");
			writer.write("</tr>");
		}
		writer.write("</table>");
		writer.write("<a href='addNewMenu.html'>新增菜谱</a>");
		writer.write("</br>");
		writer.write("<a href='searchMenuByName.html'>菜谱搜索</a>");
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
