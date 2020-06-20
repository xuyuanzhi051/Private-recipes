package net.xyz.menuaction;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.xyz.entitys.Menu;
import net.xyz.service.MenuService;

/**
 * ����µĲ���
 */
@WebServlet("/AddNewMenuServlet")
public class AddNewMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddNewMenuServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ͻ��˽��ղ���,�����ͼƬ�ڳ�Ա������ֻ����ͼƬ�����·����
		String menuName = request.getParameter("menuName");
		String menuType = request.getParameter("menuType");
		String menuImg = request.getParameter("menuImg");
		String menuMaterial = request.getParameter("menuMaterial");
		String menuSteps = request.getParameter("menuSteps");
		// ��ͼƬ���浽վ�㱾�أ�ͼƬ���ƺͲ�������һ��
		System.out.println(menuImg);
		InputStream in = new FileInputStream(menuImg);

		// ��ȡվ���Ŀ¼
		String path = this.getServletContext().getRealPath("/");
		FileOutputStream out = new FileOutputStream(path + "menuImgs/" + menuName + ".jpg");// ����ͼƬ�Բ�����������
		// ѭ����дͼƬ
		int len = -1;
		while ((len = in.read()) != -1) {
			out.write(len);
			out.flush();
		}
		// �ر���
		in.close();
		out.close();
		// �����ݿ�����Ӳ��׼�¼
		// �����յ��Ĳ�����װ��һ��Menu����
		Menu menu = new Menu();
		menu.setMenuName(menuName);
		menu.setMenuType(menuType);
		menu.setMenuImg("menuImgs/" + menuName + ".jpg");
		menu.setMenuMaterial(menuMaterial);
		menu.setMenuSteps(menuSteps);
		// ��ȡMenuService
		MenuService menuService = new MenuService();
		menuService.addMenu(menu);
		response.getWriter().write("��ӳɹ�");
		response.getWriter().write("</br>");
		response.getWriter().write("<a href='MenuInfoServlet'>������ҳ</a>");

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
