package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import entity.User;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
		String userName=request.getParameter("userName");
		String gender=request.getParameter("gender");
		String birthday=request.getParameter("birthday");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		String userRole=request.getParameter("userRole");
		Timestamp dateNow=new Timestamp(System.currentTimeMillis());
		Date reDate=new Date(System.currentTimeMillis());//获取时间
		User user=(User) request.getSession().getAttribute("userSession");
		if(user==null){
			out.print("<script type='text/javascript'>alert('请先登陆在修改');location='UserQueryAllServlet'</script>");
			return;
		}
		String id =request.getParameter("uid");
		User usa=new User();
		usa.setAddress(address);
		usa.setUserName(userName);
		usa.setGender(Integer.valueOf(gender));
		usa.setBirthday(Date.valueOf(birthday));
		usa.setPhone(phone);
		usa.setUserRole(Integer.valueOf(userRole));
		usa.setId(Integer.valueOf(id));
		usa.setModifyBy(user.getId());
		usa.setModifyDate(reDate);
		int i=new UserDao().xiugai(usa);
		if(i>0){
			out.println("<script>alert('修改成功！');location.href='TiaozhuanServlet'</script>");
		}else{
			out.println("<script>alert('修改失败！');history.back()</script>");
		}
	}

}
