package humanResources;
/**
 * class Manager extends Staff và implements ICalculator: thông tin nhân viên quản lý
 * - có thêm thuộc tính position: cấp quản lý
 * - viết lại hàm salary: tính lương của quản lý- hệ số lương *5 000 000 + phụ cấp
 * - viết lại hàm displayformatio: in ra thông tin của 1 quản lý
 * @author VuongPhamhd
 *
 */
public class Manager extends Staff implements ICalculator {
	private String position;
	
	// cac ham getter va setter
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	// viet lai cac ham hien thi va luong
	@Override
	// luong
	public double salary() {
		if (position.equals("Business Leader")) {
			return super.getCoefficientsSalary() * 5000000 + 8000000;
		}else
		if (position.equals("Project Leader")) {
			return super.getCoefficientsSalary() * 5000000 + 5000000;
		}else {
			return  super.getCoefficientsSalary() * 5000000 +6000000;
		}	
	}
	// hien thi thong  tin + chuc vu
	public void displayformatio() {
		System.out.println(super.toString() + String.format("%-30s%-2s", position,"|") + String.format( "%,.2f",salary()));
	}
}
