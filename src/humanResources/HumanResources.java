package humanResources;import java.util.ArrayList;import java.util.Collections;import java.util.Comparator;import java.util.Scanner;/** *  hàm main: *  	-Tạo 2 ArrayList: public * 			+staff: quản lý toàn bộ nhân viên và quản lý * 			+department: quản lý các bộ phận * 		- biến checkOut gắn giá trị ban đầu bằng true- điều khiển vòng lặp do-while (checkOut thay đổi thành false khi người lựa chọn thoát chương trình) * 		- biến selectNumber là giá trị người dùng nhập vào tương ứng với số chương trình muốm lựa chọn- và là trị điều kiện của cây swich * tương ứng với mỗi giá trij thì sẽ gọi đến hàm xử lý riêng. * * */public class HumanResources {	public static ArrayList<Staff> staff = new  ArrayList<Staff>();	public static ArrayList<Department> department = new ArrayList<Department>();	public static void main(String[] args) {				department.add(new Department("HC", "Hành chính nhân sự"));		department.add(new Department("IT", "Công nghệ thông tin"));		department.add(new Department("MKT", "Marketing"));				boolean checkOut=true;		Scanner sc= new Scanner(System.in);		do {			System.out.println("1. Hiển thị danh sách nhân viên có trong công ty.");			System.out.println("2. Hiển thị các bộ phân trong công ty.");			System.out.println("3. Hiển thị các nhân viên theo từng bộ phận");			System.out.println("4. Thêm nhân viên mới vào công ty.");			System.out.println("5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên.");			System.out.println("6. Hiển thị bảng lương của toàn nhân viên theo thứ tự giảm dần.");			System.out.println("7. Hiển thị bảng lương của toàn nhân viên theo thứ tự tăng dần.");			System.out.println("0. Thoát chương trình.");			System.out.print("Lựa chọn của bạn: ");			int selectNumber= sc.nextInt();								switch (selectNumber) {			case 1: {				// hiển thị toàn bộ nhân viên				showStaff();				break;			}			case 2:{				// hiển thị các bộ phận				showDepartmentNumber();				break;			}			case 3:{				//hiển thị danh sách nhân viên theo từng bộ phân				showDepartment();				break;			}			case 4:{				// thêm người vào sanh sách				int type=0;				do {					System.out.println("1. Thêm nhân viên thông thương.");					System.out.println("2. Thêm nhân viên là cấp quản lý (có thêm chức vụ).");					System.out.print("Lưa chọn của bạn: ");					type=sc.nextInt();					sc.nextLine();					if(type!=1 && type!=2) {						System.out.println("VUI LÒNG CHỌN LẠI!!!");					}				}while(type!=1 && type!=2);								addStaff(sc,type);				break;			}			case 5:{				//tìm kiếm nhân viên				int LuaChonTimKiem;				do {					System.out.println("1. Tìm nhân viên bằng tên.");					System.out.println("2. Tìm nhân viên bằng mã nhân viên.");					LuaChonTimKiem = sc.nextInt();					if(LuaChonTimKiem!=1 && LuaChonTimKiem!=2) {						System.out.println("VUI LÒNG CHỌN LẠI!!!");					}				}while(LuaChonTimKiem!=1 && LuaChonTimKiem!=2);								seach(sc, LuaChonTimKiem);				break;			}			case 6:{				// sắp xếp theo lương giảm dần				salaryDow();				break;			}			case 7:{				// sắp xếp theo lương tăng dần				salaryUp();				break;			}			case 0:{				// thoát chương trình				checkOut=false;				break;			}			default:				System.out.println();				System.out.println("BẠN CHỌN SAI. VUI LÒNG CHỌN LẠI!!!");			}		}while(checkOut);	}		/**	 * 			Hàm showStaff: không nhân tham số truyền vào và trả về giá trị	 * - Khi gọi đến sẽ hiển thị toàn bộ danh sách người trong công ty (staff). Nếu saff không có phần tử nào thì in ra "DANH SÁCH RỖNG!!!"	 * - Trong hàm có các biến:	 * 		+ title: tên các cột thông tin	 * 		+	 */	public static void showStaff() {		String title= String.format("%-15s%-2s", "Mã nhân viên","|") 				+String.format("%-20s%-2s", "Tên nhân viên","|")				+String.format("%-5s%-2s", "Tuổi","|")				+String.format("%-10s%-2s", "HS Lương","|")				+String.format("%-15s%-2s", "Ngày vào làm","|")				+String.format("%-15s%-2s", "Ngày nghỉ phép","|" )				+String.format("%-30s%-2s", "Bộ phận","|" )				+String.format("%-30s%-2s", "Số giờ làm thêm/Chức vụ","|") + " Lương";		// in ra tiêu đề		System.out.println(title);		for(int i=1; i <= 165; i++) {			System.out.print("-");		}		System.out.println();				// kiểm tra staff rỗng không		if(staff.size()>0) {			//in các nhân viên			for(Staff s0 : staff) {				s0.displayformatio();			}			System.out.println();		}else {			System.out.println("DANH SÁCH RỖNG!!!!");			System.out.println();		}	}		/**	 * 		Hàm showDepartmentNumber: không nhân giá trị truyên vào và không trả về giá trị	 * - Hàm sẽ in ra thông tin các bộ phận: mã bộ phận, tên bộ phận và số lượng người của bộ phận đó	 * 	 */	public static void showDepartmentNumber() {		//in tên các cột giá trị		System.out.println(String.format("%-15s%-2s%-30s%-2s", "Mã bộ phân","|", "Tên bộ phân","|") + "Số lượng nhân viên hiện tại");		System.out.println();		// in ra thông tin các bộ phận		for(Department d0: department) {			System.out.println(d0.toString());		}	}		/**	 * 		Hàm showDepartment: không nhận giá trị truyền vào và không trả về giá trị	 * - Biến titile: tên các cột thông tin	 * - department: ArrayList- thông tin bộ phận: mã hộ phận, tên bộ phân và số người của bộ phận	 * -staff: ArrayList- thông tin sanh sách các nhân viên	 */	public static void showDepartment() {		System.out.println();				String title= String.format("%-15s%-2s", "Mã nhân viên","|") 				+String.format("%-20s%-2s", "Tên nhân viên","|")				+String.format("%-5s%-2s", "Tuổi","|")				+String.format("%-10s%-2s", "HS Lương","|")				+String.format("%-15s%-2s", "Ngày vào làm","|")				+String.format("%-15s%-2s", "Ngày nghỉ phép","|" )				+String.format("%-30s%-2s", "Bộ phận","|" )				+String.format("%-30s%-2s", "Số giờ làm thêm/Chức vụ","|") + " Lương";				// in thông tin người trong từng bộ phận tương ứng.		for(Department d0:department) {			System.out.println(d0.getDepartmentName() + ":");			// kiểm tra xem nếu bộ phận không có người thì in ra  không có			if(d0.getAmount()==0) {				System.out.println();				System.out.println("DANH SÁCH RỖNG!");				System.out.println();				continue;			}			// nếu trong bộ phận cố người thì in ra danh sách			System.out.println(title);			for(Staff s0: staff) {				if(s0.getDepartment().equals(d0.getDepartmentName())) {					s0.displayformatio();				}			}			System.out.println();		}	}		/**	 * 			Hàm addStaff: nhận hai tham số chuyền vào là Scanner và select là lựa chọn của người dùng muốn thêm nhân viên (select =1) hay thêm quản lý(select =2)	 * 							hàm không trả về giá trị	 * 		-trong hàm có gọi đến hàm addInformation: nhập các giá trị chung của 1 nhân viên	 * 		- sử dụng câu lệnh điều kiện if : nếu là thêm nhân viên thì sẽ gọi hàm addInformation và nhâpph thêm số giờ làm thêm	 * 										Nếu là thêm quản lý thì gọi đến hàm addInformation và nhập thêm cấp quản lý	 * 		thêm nhân viên/ quản lý mới vào danh sách staff	 * @param input	 * @param select	 */	public static void addStaff(Scanner input, int select) {				if(select == 1) {			Employee employee= new Employee();			addInformation(input, employee);			// thêm thông tin làm thêm giờ			System.out.print("Nhập số giờ làm thêm: ");			employee.setOvertime(input.nextDouble());			// them vao danh sach			staff.add(employee);		}						if(select ==2) {			Manager manager =new Manager();			addInformation(input, manager);			// them chuc danh			//selectLeader là giá trị người dùng nhập vào tương ứng với cấp quản lý			int selectLeader;			do {				System.out.println("Chức danh: ");				System.out.println("1. Business Leader");				System.out.println("2. Project Leade");				System.out.println("3. Technical Leader");				System.out.print("Nhập chức danh: ");				selectLeader = input.nextInt();				// nếu giá trị người dùng nhập vào không đúng thì thông báo nhập lại				if(selectLeader > 3 || selectLeader <= 0) {					System.out.println();					System.out.println("VUI LÒNG CHỌN LẠI!!!!");				}			}while(selectLeader>3 ||selectLeader<=0);			System.out.println(selectLeader);			if(selectLeader==1) {				manager.setPosition("Business Leader");			}else if(selectLeader==2) {				manager.setPosition("Project Leader");			}else {				manager.setPosition("Technical Leader");			}			// them cao danh sach			staff.add(manager);		}			}		/**	 * - Hàm seach: 	 * 		+ tìm kiếm trong danh sách staff người có thông tin trùng với thông tin người dùng muốn tìm kiếm	 * 		+ truyền vào Scanner và số nguyên select: loại thôngn tinn người fùng muốn tìm kiếm select=1/2 tìm kiếm theo tên/tìm kiếm theo ID	 *- biến title: tên của các côt thông tin khi in ra console	 *- biến number: gắn giá trị ban đầu bằng 0 và tăng lên nếu có người trùng với thông tin tìm kiếm. sau khi kết thức danh sách tìm kiếm nếu number =0 thì thông báo không tìm thấy	 *- sử dụng câu lệnh if(kiẻm tra theo ten hay id) kết hợp với vòng lặp for so sánh thông tin từng người với thông tin người dùng muốn tìm kiếm.	 *- in ra người trùng với thông tin tìm kiếm/ nếu không có in không có người trùng với thông tin tìm kiếm	 * @param input	 * @param select	 */	public static void seach(Scanner input, int select) {		int number=0;		String title= String.format("%-15s%-2s", "Mã nhân viên","|") 				+String.format("%-20s%-2s", "Tên nhân viên","|")				+String.format("%-5s%-2s", "Tuổi","|")				+String.format("%-10s%-2s", "HS Lương","|")				+String.format("%-15s%-2s", "Ngày vào làm","|")				+String.format("%-15s%-2s", "Ngày nghỉ phép","|" )				+String.format("%-30s%-2s", "Bộ phận","|" )				+String.format("%-30s%-2s", "Số giờ làm thêm/Chức vụ","|") + " Lương";				if(select== 1) {						// lấy thông tin người dùng nhập- sau đó chuyển tên thành tên viết thường và dùng indexof để tìm kiếm			System.out.print("Nhập tên cần tìm: ");			input.nextLine();			String nameSeach = input.nextLine();			nameSeach = nameSeach.toLowerCase();			// in ra tên các cột thông tin			System.out.println(title);			System.out.println();			// tìm kiếm và in ra người trùng với thông tin tim kiếm			for(Staff object : staff) {				if(object.getName().toLowerCase().indexOf(nameSeach)>=0) {					object.displayformatio();					number++;				}			}		} else {			// lấy thông tin id			System.out.print("Nhập mã nhân viên cần tìm: ");			input.nextLine();			String idSeach = input.nextLine();			// in ra tên cột thông tin			System.out.println(title);			System.out.println();			// tìm kiếm và in ra người trùng với thông tìm kiếm			for(Staff object : staff) {				if(object.getId().equalsIgnoreCase(idSeach)) {					object.displayformatio();					number++;				}			}		}		// nếu không có ai trùng thì thông báo ko có.		if(number==0) {			System.out.println("KHÔNG CÓ NHÂN VIÊN/ QUẢN LÝ TRÙNG VỚI THÔNG TIN TÌM KIẾM!!!");			System.out.println();		}	}	/**	 * salaryUp: không có tham số truyền vào và ko trả về giá trị - hàm in ra danh sách nhân viên theo giá trị lương tăng dần	 * - coppy staff sang một ArrayList mới là salaryUp	 * - kiểm tra nếu ArrayList rỗng thì in ra danh sách rỗng. Nếu khác rỗng thì sử dung Collections.sort sắp xếp lại ArrayList theo lương tăng dần và in ra danh sách	 * 	 */	public static void salaryUp() {		ArrayList<Staff> salaryUp = new ArrayList<Staff>(staff.size());		//coppy sang array khac		salaryUp.addAll(staff);				// tạo tiêu đề		String title= String.format("%-15s%-2s", "Mã nhân viên","|") 				+String.format("%-20s%-2s", "Tên nhân viên","|")				+String.format("%-5s%-2s", "Tuổi","|")				+String.format("%-10s%-2s", "HS Lương","|")				+String.format("%-15s%-2s", "Ngày vào làm","|")				+String.format("%-15s%-2s", "Ngày nghỉ phép","|" )				+String.format("%-30s%-2s", "Bộ phận","|" )				+String.format("%-30s%-2s", "Số giờ làm thêm/Chức vụ","|") + " Lương";		// in ra tiêu đề		System.out.println(title);		for(int i=1; i <= 165; i++) {			System.out.print("-");		}		System.out.println();		// kiểm tra sanh sách rông thì in ra thông báo và thoát hàm		if(staff.size()==0) {			System.out.println("DAMH SÁCH RỖNG !!!!");			System.out.println();			return;		}				// sắp xếp lại danh sách theo thứ tự lương		Collections.sort(salaryUp, new Comparator<Staff>() {			@Override			public int compare(Staff o1, Staff o2) {				return (int )(((ICalculator)o1).salary()-((ICalculator)o2).salary());			}					});				// in mang ra		for(Staff s0: salaryUp) {			s0.displayformatio();		}	}		/**	 *salaryDow: không có tham số truyền vào và ko trả về giá trị - hàm in ra danh sách nhân viên theo giá trị lương giảm dần	 * - coppy staff sang một ArrayList mới là salaryDow	 * - kiểm tra nếu ArrayList rỗng thì in ra danh sách rỗng. Nếu khác rỗng thì sử dung Collections.sort sắp xếp lại ArrayList theo lương giảm dần dần và in ra danh sách 	 */	public static void salaryDow() {		ArrayList<Staff> salaryDow = new ArrayList<Staff>();		//coppy mang moi		salaryDow.addAll(staff);		// tên các cột thông tin khi in ra console		String title= String.format("%-15s%-2s", "Mã nhân viên","|") 				+String.format("%-20s%-2s", "Tên nhân viên","|")				+String.format("%-5s%-2s", "Tuổi","|")				+String.format("%-10s%-2s", "HS Lương","|")				+String.format("%-15s%-2s", "Ngày vào làm","|")				+String.format("%-15s%-2s", "Ngày nghỉ phép","|" )				+String.format("%-30s%-2s", "Bộ phận","|" )				+String.format("%-30s%-2s", "Số giờ làm thêm/Chức vụ","|") + " Lương";		// in ra tiêu đề		System.out.println(title);		for(int i=1; i <= 165; i++) {			System.out.print("-");		}		System.out.println();				// nếu danh sách rông in ra thông báo và kết thúc hàm		if(staff.size()==0) {			System.out.println("DANH SÁCH RỖNG !!!!");			System.out.println();			return;		}		// sắp xếp lại thứ tự		Collections.sort(salaryDow, new Comparator<Staff>() {			@Override			public int compare(Staff o1, Staff o2) {				return (int )(((ICalculator)o2).salary()-((ICalculator)o1).salary());			}					});				// in lại danh sách		for(Staff s0: salaryDow) {			s0.displayformatio();		}	}	/**	 * Hàm addInformation:	 * 	- có 2 tham số truyền vào là Scanner và 1 nhân viên Staff. không rả về giá trị	 * 	- hàm lấy thông tin cơ bản của một nhân viên	 * 	- hàm được gọi đến trong hàm addStaff	 * @param input	 * @param newStaff	 */	public static void addInformation (Scanner input,  Staff newStaff) {				boolean checkId= false;		String id;		// kiểm tra id người dùng nhập trước khi nhập thông tin các trường khác 		do { 			checkId= false; 			System.out.print("Nhập mã nhân viên: "); 			id= input.nextLine(); 			for (int i=0; i<staff.size();i++) { 				if(staff.get(i).getId().equalsIgnoreCase(id)) { 					checkId= true; 					System.out.println("MÃ NHÂN VIÊN ĐÃ TỒN TẠI. XIN HÃY NHẬP LẠI!!!!"); 				} 			} 		} while(checkId); 		newStaff.setId(id);		// nhạp tên		System.out.print("Nhập tên nhân viên: ");		newStaff.setName(input.nextLine());				//tuôi nhân viên		System.out.print("Nhập tuổi nhân viên: ");		newStaff.setAge(input.nextInt());		// hệ số lương		System.out.print("Nhập hệ số lương của nhân viên: ");		newStaff.setCoefficientsSalary(input.nextDouble());		// ngày vào cty		System.out.print("Nhập ngày vao làm của nhân viên: ");		input.nextLine();		newStaff.setStarDay(input.nextLine());		// số ngày nghỉ phép		System.out.print("Nhập ngày nghỉ phép của nhân viên: ");		newStaff.setInterval(input.nextInt());		// thông tin bộ phân		int selectNumber=-1;		do {			System.out.println("Bộ phận của nhân viên: ");			for(int i = 0; i < department.size(); i++) {				System.out.println(i + 1+ ". "+department.get(i).getDepartmentName());			}			selectNumber = input.nextInt()-1;			if(selectNumber>=department.size() || selectNumber<0) {				System.out.println("Vui lòng chọn lại!");			}		} while(selectNumber>=department.size() || selectNumber<0);						newStaff.setDepartment(department.get(selectNumber).getDepartmentName());		// tăng số gười trong bộ phận tương ứng thêm 1		department.get(selectNumber).setAmount(department.get(selectNumber).getAmount()+1);	}}