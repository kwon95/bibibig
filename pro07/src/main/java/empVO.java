
public class empVO {
	int employee_id;
	String emp_name;
//	int manager_id;
//	int department_id;
	String manager_name;
	String department_name;
	public empVO() {

	}
	public int getEmployee_id() {
		return employee_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public String getManager_name() {
		return manager_name;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}	
}
