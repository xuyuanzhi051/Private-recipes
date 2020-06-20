package net.xyz.androidaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
 * 根据用户上传的手机号 将数据库中的评论发送给用户
 */
@WebServlet("/ShowCommentServlet")
public class ShowCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowCommentServlet() {
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
			UserService userService = new UserService();
			User user = userService.searchUserByname(str);
			CommentService commentService = new CommentService();
			List<UserComment> userComments = commentService.getCommentsByUserId(user.getId());

			for (UserComment userComment : userComments) {
				response.getWriter().write(userComment.getUserId() + "!!!" + userComment.getMenuId() + "!!!"
						+ userComment.getMenuComment() + "!!!");
				response.getWriter().write("&&&");
				System.out.print(userComment.getUserId() + "!!!" + userComment.getMenuId() + "!!!"
						+ userComment.getMenuComment() + "!!!" + "&&&");
			}
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
