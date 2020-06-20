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

import net.xyz.entitys.User;
import net.xyz.service.CommentService;
import net.xyz.service.UserService;

/**
 * 接收用户的评论,并更新到数据库中
 */
@WebServlet("/ReceiveCommentServlet")
public class ReceiveCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReceiveCommentServlet() {
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
			String[] strs = str.split("&&&");
			// 根据用户手机号得到用户id
			UserService userService = new UserService();
			User user = userService.searchUserByname(strs[0]);
			if (user != null) {
				// 向数据库中插入信息
				CommentService commentService = new CommentService();
				System.out.println(user.getId() + strs[1] + strs[2]);
				commentService.addComment(Integer.parseInt(strs[1]), user.getId(), strs[2]);
			}
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
