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
 * ��ʾ���׵ĵ������
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
		// ��ȡ���������
		PrintWriter writer = response.getWriter();
		// ��ȡ������Ϣ
		RankListService rankListService = new RankListService();
		List<RankList> rankLists = rankListService.getRankLists();
		writer.write("<h1 align='center'>���޹���ģ��</h1>");
		writer.write("<table border='1' align='center'>");
		writer.write("<tr aligh='center'>");
		writer.write("<th>��������</th>");
		writer.write("<th>��������</th>");
		writer.write("</tr>");
		// չʾ������Ϣ��Ϣ
		for (RankList rankList : rankLists) {
			writer.write("<tr align='center'>");
			writer.write("<td>" + rankList.getMenuName() + "</td>");
			writer.write("<td>" + rankList.getLikenumber() + "</td>");

			writer.write("</tr>");
		}
		writer.write("</table>");
		writer.write("<a href='selectRankByMenuName.html'>��ѯ�������׵ĵ������</a>");
		writer.write("</br>");
		writer.write("<a href='adminfunction.html'>������ҳ</a>");
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
