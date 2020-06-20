package net.xyz.androidaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.xyz.entitys.MenuDetails;
import net.xyz.service.MenuDetailsService;

/**
 * 根据获取的用户id向客户端提供菜谱详情信息
 */
@WebServlet("/ShowMenuDetailsServlet")
public class ShowMenuDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowMenuDetailsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		InputStream in = request.getInputStream();
		BufferedReader read = new BufferedReader(new InputStreamReader(in, "utf-8"));
		String menuId = read.readLine();

		System.out.println("菜单Id是:" + menuId);
		if (menuId != null) {
			// 获取MenuDetailsService
			MenuDetailsService menuDetailsService = new MenuDetailsService();
			MenuDetails menuDetails = menuDetailsService.selectMenuDetailsByMenuId(Integer.valueOf(menuId));
			response.getWriter()
					.write(menuDetails.getDetailsMenuImg() + "&&&" + menuDetails.getDetailsMenuName() + "&&&"
							+ menuDetails.getDetailsMenuType() + "&&&" + menuDetails.getDetailsMenuLikeNumber() + "&&&"
							+ menuDetails.getDetailsMenuMeterial() + "&&&" + menuDetails.getDetailsMenuSteps() + "&&&"
							+ menuDetails.getDetailsMenuCommonts());

		}

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
