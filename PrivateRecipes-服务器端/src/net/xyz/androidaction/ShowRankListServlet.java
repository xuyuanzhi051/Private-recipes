package net.xyz.androidaction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.xyz.entitys.RankList;
import net.xyz.service.RankListService;

/**
 * 向客户端展示菜谱排行界面
 */
@WebServlet("/ShowRankListServlet")
public class ShowRankListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowRankListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		RankListService rankListService = new RankListService();
		List<RankList> rankLists = rankListService.getRankLists();
		for (RankList rankList : rankLists) {
			writer.write(rankList.getRankNum() + "!!!" + rankList.getMenuImg() + "!!!" + rankList.getMenuType() + "!!!"
					+ rankList.getMenuName() + "!!!" + rankList.getLikenumber());
			writer.write("&&&");
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
