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
import javax.servlet.jsp.JspWriter;

import org.apache.ibatis.annotations.Param;

import dao.UserDao;
import entity.Page;
import entity.User;

/**
 * Servlet implementation class Denglu
 */
public class Denglu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String userCode=request.getParameter("userCode");
		String userPassword=request.getParameter("userPassword");
		User user=new User();
		user.setUserCode(userCode);
		user.setUserPassword(userPassword);
		user=new UserDao().verifyUser(user);
		if(null==user){
			out.print("<script>history.back();alert('账号或者密码不正确');</script>");
			return;
		}
		int totalCount=new UserDao().findCount();//总数量
		int totalPageCount=totalCount%5==0?totalCount/5:totalCount/5+1;
		Page aa=new Page();
		aa.setTotalCount(totalCount);
		aa.setTotalPageCount(totalPageCount);
		List<User> list=new UserDao().selectAll((aa.getCurrentPageNo()-1)*5);
		request.setAttribute("aa", aa);
		request.setAttribute("userList", list);
		request.getSession().setAttribute("userSession", user);
		request.setAttribute("totalPageCount", aa.getTotalPageCount());
		request.setAttribute("currentPageNo", aa.getCurrentPageNo());
		request.setAttribute("totalCount", aa.getTotalCount());
		request.getRequestDispatcher("jsp/userlist.jsp?totalCount="+totalCount).forward(request, response);
	}

}
