package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import entity.Page;
import entity.Role;
import entity.User;

/**
 * Servlet implementation class TiaozhuanServlet
 */
public class TiaozhuanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TiaozhuanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String queryname=request.getParameter("queryname");
		String queryUserRole=request.getParameter("queryUserRole");
		String currentPageNo=request.getParameter("pageIndex");
		if(queryname==null){
			queryname="";
		}
		if(queryUserRole==null||"0".equals(queryUserRole)){
			queryUserRole="";
		}
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("userName", queryname);
		map.put("userRole", queryUserRole);
		int totalCount=new UserDao().moHu1(map);;//×ÜÊýÁ¿
		int totalPageCount=totalCount%5==0?totalCount/5:totalCount/5+1;
		Page aa=new Page();
		System.out.println(currentPageNo);
		aa.setTotalCount(totalCount);
		aa.setTotalPageCount(totalPageCount);
		if(currentPageNo!=null){
			aa.setCurrentPageNo(Integer.valueOf(currentPageNo));
		}
		map.put("qishiye",(aa.getCurrentPageNo()-1)*5);
		List<User> list=new UserDao().moHu(map);
		List<Role> roleList=new UserDao().chaxun();
		request.setAttribute("totalPageCount", aa.getTotalPageCount());
		request.setAttribute("currentPageNo", aa.getCurrentPageNo());
		request.setAttribute("totalCount", aa.getTotalCount());
		request.setAttribute("aa", aa);
		request.setAttribute("roleList", roleList);
		request.setAttribute("userList", list);
		request.getRequestDispatcher("jsp/userlist.jsp").forward(request, response);
	}

}
