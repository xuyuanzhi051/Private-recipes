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
 * �������Ĳ��׵���Ϣ
 */
@WebServlet("/updateMenuByIdServlet")
public class updateMenuByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateMenuByIdServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ͻ��˽��ղ���,��װ��һ��menu����

		int menuId = Integer.valueOf(request.getParameter("menuId"));
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
		System.out.println(path);
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
		menu.setMenuId(menuId);
		menu.setMenuName(menuName);
		menu.setMenuType(menuType);
		menu.setMenuImg("menuImgs/" + menuName + ".jpg");
		menu.setMenuMaterial(menuMaterial);
		menu.setMenuSteps(menuSteps);
		// ��ȡMenuService
		MenuService menuService = new MenuService();
		int b = menuService.updateMenuById(menu);
		if (b != 0) {
			response.getWriter().write("�޸ĳɹ�");
		}

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
