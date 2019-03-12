package com.emp.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.model.service.EmpService;
import com.emp.model.service.EmpServiceImpl;

/**
 * Servlet implementation class EmpSearchEndServlet
 */
@WebServlet("/empSearchEnd.do")
public class EmpSearchEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmpService service = new EmpServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpSearchEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String searchType = request.getParameter("searchType");
		String keyword = request.getParameter("keyword");
		String gender = request.getParameter("gender");
		String hireDate = request.getParameter("hireDate");
		
		/*SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date to = null;
		try {
			to = (Date) transFormat.parse(hireDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(to);*/

		Map<String, Object> map = new HashMap();
		map.put("searchType", searchType);
		map.put("keyword", keyword);
		map.put("gender", gender);
		map.put("salary", request.getParameter("salary"));
		map.put("sal", request.getParameter("sal"));
		map.put("hireDate", hireDate);
		map.put("hdate", request.getParameter("hdate"));
		map.put("job", request.getParameterValues("job"));
		List<Map> list = service.selectSearch(map);
		System.out.println(list);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/views/emp/search1.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
