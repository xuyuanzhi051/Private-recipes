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
 * 单个菜谱的详情介绍
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
		// 获取单个菜谱的名称
		String menuName = request.getParameter("menuName");
		// 获取MenuService
		MenuService menuService = new MenuService();
		Menu menu = menuService.SearchMenuByMenuName(menuName);
		// 获取输出对象
		PrintWriter writer = response.getWriter();
		writer.write("<h1 align='center'>菜谱详情</h1>");
		writer.write("<table border='1'>");
		writer.write("<tr align='center'>");
		writer.write("<th>菜谱Id</th>");
		writer.write("<th>菜谱名称</th>");
		writer.write("<th>菜谱类型</th>");
		writer.write("<th>菜谱图片</th>");
		writer.write("<th>菜谱原材料</th>");
		writer.write("<th>菜谱步骤</th>");
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
