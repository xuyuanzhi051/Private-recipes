package net.xyz.rankaction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.xyz.entitys.RankList;
import net.xyz.entitys.UserComment;
import net.xyz.service.CommentService;
import net.xyz.service.RankListService;

/**
 * 显示菜谱的点赞情况
 */
@WebServlet("/MenuLikeInfoServlet")
public class MenuLikeInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MenuLikeInfoServlet() {
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
		PrintWriter writer = response.getWriter();
		// 获取点赞信息
		RankListService rankListService = new RankListService();
		List<RankList> rankLists = rankListService.getRankLists();
		writer.write("<h1 align='center'>点赞管理模块</h1>");
		writer.write("<table border='1' align='center'>");
		writer.write("<tr aligh='center'>");
		writer.write("<th>菜谱名称</th>");
		writer.write("<th>点赞数量</th>");
		writer.write("</tr>");
		// 展示评论信息信息
		for (RankList rankList : rankLists) {
			writer.write("<tr align='center'>");
			writer.write("<td>" + rankList.getMenuName() + "</td>");
			writer.write("<td>" + rankList.getLikenumber() + "</td>");

			writer.write("</tr>");
		}
		writer.write("</table>");
		writer.write("<a href='selectRankByMenuName.html'>查询单个菜谱的点赞情况</a>");
		writer.write("</br>");
		writer.write("<a href='adminfunction.html'>返回首页</a>");
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
