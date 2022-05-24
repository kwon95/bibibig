

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> list = dao.listMember();
		
		out.print("<html><head><title>Result form t_member</title></head><body>");
		out.print("<table border=1><tr><th>ID</th><th>��й�ȣ</th><th>�̸�</th><th>�����</th><th>�����</th><th>�۾�����</th></tr>");//head line
		for (int i=0; i<list.size();i++) {
			MemberVO mvo = list.get(i);
			String id = mvo.getId();
			String pwd = mvo.getPwd();
			String name = mvo.getName();
			String mobile = mvo.getMobile();
			String joindate = mvo.getJoinDate();
			out.print("<tr><td>"+id+"</td><td>"+pwd+"</td><td>"+name+"</td><td>"+mobile+
					"</td><td>"+joindate+"</td><td><a href='update?id="+id+"'>����</a>&nbsp;"+
					"<a href='delete?id="+id+"'>����</a></td></tr>");
		}
		out.print("</table><a href='addnew.html'>�߰�</a></body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
