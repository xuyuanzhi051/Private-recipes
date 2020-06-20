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
import net.xyz.service.CommentService;
import net.xyz.service.MenuListService;

/**
 * 删除评论接口 根据用户提交的信息删除评论信息
 */
@WebServlet("/DeleteCommentByUserIDandMenuId")
public class DeleteCommentByUserIDandMenuId extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteCommentByUserIDandMenuId() {
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
		String[] strs = str.split("&&&");
		if (str != null) {
			System.out.println(str);
			CommentService commentDaoService = new CommentService();
			commentDaoService.deleteCommentByUserIdandMenuId(Integer.valueOf(strs[0]), Integer.valueOf(strs[0]));
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
