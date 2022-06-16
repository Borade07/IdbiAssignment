package com.idbiass;

import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.idbiass.dao.IdbiDAO;
import com.idbiass.dto.IdbiDTO;
import com.idbiass.logic.IdbiLogic;

/**
 * Servlet implementation class IdbiServlet
 */
@WebServlet("/")
public class IdbiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IdbiLogic idbiLogic;
    
    public void init() {
    	idbiLogic = new IdbiLogic();
    }
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdbiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			
			insertUser(request, response);
//			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		response.sendRedirect("IdbiRegSucc.jsp");
//		RequestDispatcher dispatcher = request.getRequestDispatcher("IdbiRegister.jsp");
//        dispatcher.forward(request, response);
	}



	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		String moNumber = request.getParameter("moNumber");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		IdbiDTO idbiDtoObj = new IdbiDTO();
		idbiDtoObj.setfName(fName);
		idbiDtoObj.setlName(lName);
		idbiDtoObj.setMoNumber(moNumber);
		idbiDtoObj.setGender(gender);
		idbiDtoObj.setEmail(email);
		
		IdbiDAO idbiDaoObj = new IdbiLogic().insertUser(idbiDtoObj);
		IdbiLogic.insertData(idbiDaoObj);
		
//		int i=Integer.parseInt(request.getParameter("email"));
		String e = request.getParameter("email");
		String a = request.getParameter("fName");
		IdbiDAO ecistingUser = IdbiLogic.selectUser(e,a);
		request.setAttribute("listUser", ecistingUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("IdbiRegSucc.jsp");
		dispatcher.forward(request, response);
//		System.out.println(ecistingUser.getId());
//		System.out.println("pringing id");
//		System.out.println(ecistingUser.getfName());
//		System.out.println("up or down /");
//		System.out.println(ecistingUser.getlName());
//		
//		System.out.println(ecistingUser.getMoNumber());
//		System.out.println("date");
//		System.out.println(ecistingUser.getRegDate());
//		System.out.println(ecistingUser.getRegTime());
//		System.out.println(ecistingUser.getGender());
//		System.out.println(ecistingUser.getEmail());
//	}
	}
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
