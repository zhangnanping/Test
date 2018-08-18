package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import entity.User;

/**
 * Servlet implementation class SaveUserServlet
 */
public class SaveUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveUserServlet() {
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
		String userCode=request.getParameter("userCode");
		String userName=request.getParameter("userName");
		String userPassword=request.getParameter("userPassword");
		String gender=request.getParameter("gender");
		String birthday=request.getParameter("birthday");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		String userRole=request.getParameter("userRole");
		User u1=(User)request.getSession().getAttribute("userSession");
		if(u1==null){
			out.print("<script>alert('读取不到用户，请登陆！');location.href='login.jsp'</script>");
			return;
		}
		User user=new User();
		Timestamp dateNow=new Timestamp(System.currentTimeMillis());
		Date reDate=new Date(System.currentTimeMillis());
		user.setUserCode(userCode);
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		user.setGender(Integer.valueOf(gender));
		user.setBirthday(Date.valueOf(birthday));
		user.setPhone(phone);
		user.setAddress(address);
		user.setUserRole(Integer.valueOf(userRole));
		user.setCreatedBy(u1.getCreatedBy());
		user.setCreationDate(reDate);
		int result=new UserDao().addUser(user);
		if(result>0){
			request.getRequestDispatcher("TiaozhuanServlet").forward(request, response);
		}else{
			out.print("<script>alert('添加失败！');history.back()</script>");
		}

	}

}
