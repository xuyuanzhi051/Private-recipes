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
import net.xyz.service.RankListService;

/**
 * ����ĳ�����׵��������������׵ĵ������
 */
@WebServlet("/SelectRankByMenuName")
public class SelectRankByMenuName extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectRankByMenuName() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String menuName = request.getParameter("menuName");
		// ��ȡ���������
		PrintWriter writer = response.getWriter();
		// ��ȡ������Ϣ
		RankListService rankListService = new RankListService();
		RankList rk = rankListService.selectRankByMenuName(menuName);
		writer.write("<h1 align='center'>���׵�����Ϣ����ҳ��</h1>");
		writer.write("<table border='1' align='center'>");
		writer.write("<tr aligh='center'>");
		writer.write("<th>��������</th>");
		writer.write("<th>��������</th>");
		writer.write("</tr>");
		// չʾ������Ϣ��Ϣ

		writer.write("<tr align='center'>");
		writer.write("<td>" + rk.getMenuName() + "</td>");
		writer.write("<td>" + rk.getLikenumber() + "</td>");

		writer.write("</tr>");

		writer.write("</table>");

		writer.write("</br>");
		writer.write("<a href='MenuLikeInfoServlet'>����</a>");
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
