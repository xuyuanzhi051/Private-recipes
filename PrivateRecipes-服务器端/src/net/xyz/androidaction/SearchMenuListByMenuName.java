package net.xyz.androidaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.xyz.entitys.MenuList;
import net.xyz.service.MenuListService;

/**
 * 通过菜谱名查询出菜谱对象
 */
@WebServlet("/SearchMenuListByMenuName")
public class SearchMenuListByMenuName extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchMenuListByMenuName() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		InputStream in = request.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
		String str = reader.readLine();
		if (str != null) {
			System.out.println(str);
			// 根据菜谱名向客户端返回一个菜谱列表
			MenuListService menuListService = new MenuListService();
			MenuList menuList = menuListService.searchMenuListByMenuName(str);
			response.getWriter().write(menuList.getMenuImg() + "&&&" + menuList.getMenuName() + "&&&"
					+ menuList.getMenuType() + "&&&" + menuList.getMenuLikes());
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
