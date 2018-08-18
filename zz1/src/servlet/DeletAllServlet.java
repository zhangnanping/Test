package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import dao.UserDao;

/**
 * Servlet implementation class DeletAllServlet
 */
public class DeletAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletAllServlet() {
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
		System.out.println("jinlaile");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String[] ids=request.getParameterValues("uid[]");
		Integer[] intids=new Integer[ids.length];
		System.out.println(intids);
		for (int i = 0; i < ids.length; i++) {
			intids[i]=Integer.valueOf(ids[i]);
		}
		int i=new UserDao().shanChu(intids);
		Map<String, String> map=new HashMap<>();
		map.put("delResult", "false");
		if(i>0){
			map.put("delResult", "true");
		}
		String json=JSON.toJSONString(map);
		out.println(json);
		
	}

}
