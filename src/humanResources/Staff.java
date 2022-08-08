package humanResources;
/**
 * abstract class Staff: thông tin cớ bản của 1 nhân viên
 * - có các thuộc tính 
 * 		+id: mã nhân viên
 * 		+ name: tên nhân viênn
 * 		+ starDay: ngày bắt đâu vào làm
 * 		+ department: bộ phận
 * 		+ age: tuổi
 * 		+interval: số ngày nghỉ
 * 		+ coefficientsSalary: hệ số lương
 * - Có các phương thức
 * 		+ các phương thức getter và setter
 * 		+ abstract void displayformatio()
 * 		+ String toString: trả về String thông tin cơ bản của 1 nhân viên
 * @author VuongPhamhd
 *
 */
public abstract class Staff {
	// mã số nhân viên / tên/ ngày bắt đầu làm việc/ phan lam viec
	private String id, name, starDay,department;
	// tuổi / hệ số lương/số ngày nghỉ
	private int age,  interval;
	private double coefficientsSalary;
	// hàm hiển thị thông tin nhân viên
	public abstract void displayformatio();
	
	

	// các hàm getter và setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStarDay() {
		return starDay;
	}

	public void setStarDay(String starDay) {
		this.starDay = starDay;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getCoefficientsSalary() {
		return coefficientsSalary;
	}

	public void setCoefficientsSalary(double coefficientsSalary) {
		this.coefficientsSalary = coefficientsSalary;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	// ham toString
	public String toString() {
		return 	String.format("%-15s%-2s", id,"|") 
				+String.format("%-20s%-2s", name,"|")
				+String.format("%-5s%-2s", age,"|")
				+String.format("%-10s%-2s", coefficientsSalary,"|")
				+String.format("%-15s%-2s", starDay,"|")
				+String.format("%-15s%-2s",interval,"|" )
				+String.format("%-30s%-2s",department,"|" );
	}

}
