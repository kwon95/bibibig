import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class empDAO {
	private Statement stmt;
	private Connection conn;
	
	public ArrayList<empVO> list(){
		ArrayList<empVO> list = new ArrayList<empVO>();
		try {
			connDB();
			String query = "select a.employee_id,a.emp_name,b.emp_name manager_name,c.department_name"+
			"from employees a,employees b,departments c "+
			"where a.manager_id=b.employee_id and a.department_id=c.department_id(+)";
			this.stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				int employee_id = rs.getInt("employee_id");
				String emp_name = rs.getString("emp_name");
//				int manager_id = rs.getInt("manager_id");
//				int department_id = rs.getInt("department_id");
				String manager_name =rs.getString("manager_name");
				String department_name = rs.getString("department_name");
				
				empVO mvo =new empVO();
				mvo.setEmployee_id(employee_id);
				mvo.setEmp_name(emp_name);
//				mvo.setManager_id(manager_id);
//				mvo.setDepartment_id(department_id);
				mvo.setManager_name(manager_name);
				mvo.setDepartment_name(department_name);
				list.add(mvo);	
			}
			rs.close();//memory반납
			stmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	private void connDB() {
		String driver = "oracle.jdbc.driver.OracleDriver";//버젼마다다름
		String url="jdbc:oracle:thin:@localhost:1521:orcl";//데이터베이스 주소
		String userid = "ora_user";
		String passcode = "human123";
		try {
			Class.forName(driver);
			this.conn = DriverManager.getConnection(url,userid,passcode);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
