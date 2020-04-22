package db.connection.mysql.connection.model;

public class Manager {

	private Employee employee;
	private String departmentName;


	public Manager() {};

	public Manager(Employee employee, String departmentName) {
		this.employee = employee;
		this.departmentName = departmentName;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Manager{");
		sb.append("employee=").append(employee);
		sb.append(", departmentName='").append(departmentName).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
