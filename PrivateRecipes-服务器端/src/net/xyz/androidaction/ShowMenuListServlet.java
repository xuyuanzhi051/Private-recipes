package net.xyz.androidaction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.xyz.entitys.MenuList;
import net.xyz.service.MenuListService;

/**
 * 向客户端展示菜谱列表界面 将数据库中的菜谱信息发送到客户端
 */
@WebServlet("/ShowMenuListServlet")
public class ShowMenuListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowMenuListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取网络输出流
		PrintWriter write = response.getWriter();
		// 获取MenuService
		MenuListService menuService = new MenuListService();
		List<MenuList> menuLists = menuService.getMenuLists();
		for (MenuList menuList : menuLists) {
			String list = menuList.getMenuId() + "!!!" + menuList.getMenuImg() + "!!!" + menuList.getMenuName() + "!!!"
					+ menuList.getMenuType() + "!!!" + menuList.getMenuLikes() + "&&&";
			write.write(list);
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
