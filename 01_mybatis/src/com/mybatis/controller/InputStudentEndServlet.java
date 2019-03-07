package com.mybatis.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.MybatisService;
import com.mybatis.model.service.MybatisServiceImpl;
import com.mybatis.model.vo.Student;

/**
 * Servlet implementation class InputStudentEndServlet
 */
@WebServlet("/inputStudentEnd.do")
public class InputStudentEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MybatisService service = new MybatisServiceImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InputStudentEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		String memberName = request.getParameter("memberName");
		String gender = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String hobby = request.getParameter("hobby");
		Student s = new Student(memberId, memberPwd, memberName, gender, age, email, phone, address, hobby);
		int result = service.insertStudent(s);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append(result > 0 ? "입력완료" : "입력실패");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
