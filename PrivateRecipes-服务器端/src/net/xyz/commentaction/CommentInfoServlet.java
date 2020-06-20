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
 * 菜谱评论展示页
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
		// 获取网络输出流
		PrintWriter writer = response.getWriter();
		// 获取评论信息
		CommentService commentService = new CommentService();
		List<UserComment> allComments = commentService.getAllComments();
		writer.write("<h1 align='center'>评论管理模块</h1>");
		writer.write("<table border='1' aligh='center'>");
		writer.write("<tr aligh='center'>");
		writer.write("<th>评论ID</th>");
		writer.write("<th>菜谱ID</th>");
		writer.write("<th>用户ID</th>");
		writer.write("<th>评论内容</th>");
		writer.write("<th>删除评论</th>");
		writer.write("</tr>");
		// 展示评论信息信息
		for (UserComment userComment : allComments) {
			writer.write("<tr align='center'>");
			writer.write("<td>" + userComment.getCommentId() + "</td>");
			writer.write("<td>" + userComment.getMenuId() + "</td>");
			writer.write("<td>" + userComment.getUserId() + "</td>");
			writer.write("<td>" + userComment.getMenuComment() + "</td>");
			writer.write("<td><a href='DeleteCommentByCommentId?commentId=" + userComment.getCommentId()
					+ "'>删除评论</a></td>");
			writer.write("</tr>");
		}
		writer.write("</table>");

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
