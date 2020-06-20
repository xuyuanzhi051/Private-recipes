package net.xyz.menuaction;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.xyz.entitys.Menu;
import net.xyz.service.MenuService;

/**
 * 用来更改菜谱的信息
 */
@WebServlet("/updateMenuByIdServlet")
public class updateMenuByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateMenuByIdServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 向客户端接收参数,封装成一个menu对象

		int menuId = Integer.valueOf(request.getParameter("menuId"));
		String menuName = request.getParameter("menuName");
		String menuType = request.getParameter("menuType");
		String menuImg = request.getParameter("menuImg");
		String menuMaterial = request.getParameter("menuMaterial");
		String menuSteps = request.getParameter("menuSteps");
		// 将图片保存到站点本地，图片名称和菜谱名称一致
		System.out.println(menuImg);
		InputStream in = new FileInputStream(menuImg);

		// 获取站点根目录
		String path = this.getServletContext().getRealPath("/");
		System.out.println(path);
		FileOutputStream out = new FileOutputStream(path + "menuImgs/" + menuName + ".jpg");// 菜谱图片以菜谱名称命名
		// 循环读写图片
		int len = -1;
		while ((len = in.read()) != -1) {
			out.write(len);
			out.flush();
		}
		// 关闭流
		in.close();
		out.close();
		// 向数据库中添加菜谱记录
		// 将接收到的参数封装成一个Menu对象
		Menu menu = new Menu();
		menu.setMenuId(menuId);
		menu.setMenuName(menuName);
		menu.setMenuType(menuType);
		menu.setMenuImg("menuImgs/" + menuName + ".jpg");
		menu.setMenuMaterial(menuMaterial);
		menu.setMenuSteps(menuSteps);
		// 获取MenuService
		MenuService menuService = new MenuService();
		int b = menuService.updateMenuById(menu);
		if (b != 0) {
			response.getWriter().write("修改成功");
		}

		response.getWriter().write("</br>");
		response.getWriter().write("<a href='MenuInfoServlet'>返回首页</a>");
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
