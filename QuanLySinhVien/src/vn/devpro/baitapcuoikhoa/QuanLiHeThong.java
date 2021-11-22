package vn.devpro.baitapcuoikhoa;



public class QuanLiHeThong {
	QuanLiChucNang quanLiChucNang=new  QuanLiChucNang();
	public void initialize()
	{ 
		do {
			System.out.println("\t=========== CHƯƠNG TRÌNH QUẢN LÍ SINH VIÊN============");
			System.out.println("\tChọn chức năng quản lý hệ thống");
			System.out.println("\t1. Cập nhật thông tin hệ thống");
			System.out.println("\t2. Hiển thị bảng điểm");
			System.out.println("\t3. Tìm kiếm thông tin");
			System.out.println("\t0. Để thoát");
		
			 String bChon="";
			 String ma="\\d+";
			do {
				System.out.println("\tMời bạn nhập lựa chọn:");
				bChon=Helper.scan.nextLine();
			}while(!bChon.matches(ma));
			int chon=Integer.parseInt(bChon);
			switch(chon)
			{
			case 1: quanLiChucNang.capNhapThongTinHeThong();break;
			case 2: quanLiChucNang.hienThiBangDiem();break;
			case 3: quanLiChucNang.timKiemThongTin();break;
			case 0: 
				System.out.println("Xin chào và hẹn gặp lại...");
				System.exit(0);;
			default: System.out.println("Lựa chọn không hợp lệ..");
			Helper.bamEnterDeTiepTuc();
			
			
			}
		    
			}while (true);
		
	}
	public static void main(String[] args) {
		QuanLiHeThong quanLiHeThong=new QuanLiHeThong();
		quanLiHeThong.initialize();
	}
}
