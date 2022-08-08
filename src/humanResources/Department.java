package humanResources;
/**
 * class Department: thông tin bộ phân
 * -có các thuộc tính 
 * 		+ String id: mã bộ phân
 * 		+ String departmentName: tên của bộ phân
 * 		+ int amount: số người trong bộ phân. Giá trị mặc định khi khởi tạo là 0
 * - có các hàm:
 * 		 + hàm khởi tại với 2 tham số mã bộ phận và tên bộ phân
 * 		+ Các hàm getter và setter tương ứng với các thuộc tính
 * 		+ hàm toString trả về String thông tin của bộ phận
 * @author VuongPhamhd
 *
 */
public class Department {
	private String id;
	private String departmentName;
	private int amount=0;
	public Department(String id, String departmentName) {
		super();
		this.id = id;
		this.departmentName = departmentName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String  toString() {
		return String.format("%-15s%-2s%-30s%-2s", id,"|", departmentName,"|") + amount;
	}
	
}
