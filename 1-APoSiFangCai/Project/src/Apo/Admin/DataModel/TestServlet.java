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

@WebServlet("/TestServlet")
@MultipartConfig
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("UTF-8");
		
		Part part = request.getPart("dish_img");
		String img = "" ;
		if(part!=null && part.getSize()>0){
			String fileName = part.getSubmittedFileName();
			String path = getServletContext().getRealPath("/Public/dishimg")+File.separator+fileName;
			part.write(path);
			img = "/Public/dishimg/"+fileName ;
			System.out.println(path+"-------");
		}

		//接收表单数据
		String DishName = request.getParameter("DishName");
		String Material = request.getParameter("Material");
		String MarketPrice = request.getParameter("MarketPrice");
		String MemberPrice = request.getParameter("MemberPrice");
		String Description = request.getParameter("Description"); 
		String Clssify = request.getParameter("Clssify");
		
		System.out.println(DishName+MarketPrice+Material + MemberPrice + Description+Clssify);
		//调用添加菜单的方法
		try {
			int i = Apo.Add_Menu(DishName, Material, MarketPrice, MemberPrice, Clssify, Description, img);
			
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
