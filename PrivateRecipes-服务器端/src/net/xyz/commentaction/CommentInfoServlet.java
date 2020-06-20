package net.xyz.commentaction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.xyz.entitys.User;
import net.xyz.entitys.UserComment;
import net.xyz.service.CommentService;
import net.xyz.service.UserService;

/**
 * ��������չʾҳ
 */
@WebServlet("/CommentInfoServlet")
public class CommentInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommentInfoServlet() {
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
		CommentService commentService = new CommentService();
		List<UserComment> allComments = commentService.getAllComments();
		writer.write("<h1 align='center'>���۹���ģ��</h1>");
		writer.write("<table border='1' aligh='center'>");
		writer.write("<tr aligh='center'>");
		writer.write("<th>����ID</th>");
		writer.write("<th>����ID</th>");
		writer.write("<th>�û�ID</th>");
		writer.write("<th>��������</th>");
		writer.write("<th>ɾ������</th>");
		writer.write("</tr>");
		// չʾ������Ϣ��Ϣ
		for (UserComment userComment : allComments) {
			writer.write("<tr align='center'>");
			writer.write("<td>" + userComment.getCommentId() + "</td>");
			writer.write("<td>" + userComment.getMenuId() + "</td>");
			writer.write("<td>" + userComment.getUserId() + "</td>");
			writer.write("<td>" + userComment.getMenuComment() + "</td>");
			writer.write("<td><a href='DeleteCommentByCommentId?commentId=" + userComment.getCommentId()
					+ "'>ɾ������</a></td>");
			writer.write("</tr>");
		}
		writer.write("</table>");

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
