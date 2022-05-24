

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class empServlet
 */
@WebServlet("/empServlet")
public class empServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public empServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		empDAO dao = new empDAO();
		ArrayList<empVO> list = dao.list();
		
		out.print("<html><head><title>Result form employees</title></head><body>");
		out.print("<table border=1><tr><th>ID</th><th>이름</th><th>매니저이름</th><th>파트이름</th></tr>");
		for (int i=0; i<list.size();i++) {
			empVO mvo = list.get(i);
			int employee_id = mvo.getEmployee_id();
			String emp_name = mvo.getEmp_name();
//			int manager_id = mvo.getManager_id();
//			int department_id = mvo.getDepartment_id();
			String manager_name = mvo.getManager_name();
			String department_name =mvo.getDepartment_name();
			
			out.print("<tr><td>"+employee_id+"</td><td>"+emp_name+"</td><td>"+manager_name+"</td><td>"+department_name+"</td></tr>");
		}
		out.print("</table></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
