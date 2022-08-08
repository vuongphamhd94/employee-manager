package humanResources;
/**
 *  class Employee extends Staff và implements ICalculator : thong tin của 1 nhân viên
 *  - có thêm thuộc tính overtime: thời gian làm thêm 
 *  - Có phương thức getter và setter của thời gian làm thêm
 *  - viết lại hàm salary: lương của nhân viên-  hệ số lương * 3 000 000 + thời gian làm thêm * 200 000
 *  - Viết lại hàm displayformatio: in ra thông tin của 1 nhân viên
 * @author VuongPhamhd
 *
 */
public class Employee extends Staff implements ICalculator {
	// thuộc tính ngày làm thêm
	private double overtime;
	
	// các getter và setter
	public double getOvertime() {
		return overtime;
	}

	public void setOvertime(double overtime) {
		this.overtime = overtime;
	}
	
	// viết lại các hàm hiển thị và lương
	@Override
	public double salary() {
		return super.getCoefficientsSalary()*3000000 + overtime*200000;
	}
	// hien thi thong tin + so gio lam them
	public void displayformatio() {
		System.out.println(super.toString() + String.format("%-30s%-2s", overtime,"|") + String.format( "%,.2f",salary()));
	}
}
