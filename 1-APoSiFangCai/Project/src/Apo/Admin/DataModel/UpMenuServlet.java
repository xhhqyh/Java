package Apo.Admin.DataModel;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Apo.Hui.Db.DbHelper;
import Apo.Hui.Db.DbUtil;

/**
 * @author 小灰灰
 * @version 2017年8月2日下午3:01:20
 * 类说明:
 *		修改菜单Servlet
*/

@WebServlet("/UpMenuServlet")
@MultipartConfig
public class UpMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpMenuServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("UTF-8");
		
		//接收表单数据
		String DishName = request.getParameter("DishName");
		String Material = request.getParameter("Material");
		String MarketPrice = request.getParameter("MarketPrice");
		String MemberPrice = request.getParameter("MemberPrice");
		String Description = request.getParameter("Description"); 
		String Clssify = request.getParameter("Clssify");
		String Menu_Id = request.getParameter("Menu_Id");

		Part part = request.getPart("dish_img");
		
		System.out.println(DishName+MarketPrice+Material + MemberPrice + Description+Clssify+Menu_Id);
		
		String img = "" ;
		//图片处理块
		if(part!=null && part.getSize()>0){
			String fileName = part.getSubmittedFileName();
			String path = getServletContext().getRealPath("/Public/dishimg")+File.separator+fileName;
			part.write(path);
			img = "/Public/dishimg/"+fileName ;
			System.out.println(path+"-------");
		}
		
		
		//调用添加菜单的方法
		try {
			int i = Apo.Menu_Update(Menu_Id,DishName, Material, MarketPrice, MemberPrice, Clssify, Description, img);
			
			if(i == 1){
				response.sendRedirect("./Admin/menu_message_list.jsp");
			}else{
				response.sendRedirect("./Admin/new_menu.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
