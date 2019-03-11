package com.emp.controller;

import java.io.IOException;
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
		Map<String, String> map = new HashMap();
		map.put("searchType", searchType);
		map.put("keyword", keyword);
		List<Map> list = service.selectSearch(map);
		
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
