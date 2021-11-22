package vn.devpro.baitapcuoikhoa;



public class QuanLiChucNang {
QuanLiSinhVien quanLiSinhVien=new QuanLiSinhVien();
QuanLiMonHoc quanLiMonHoc=new QuanLiMonHoc();
QuanLiDiem quanLiDiem=new QuanLiDiem();
public void capNhapThongTinHeThong()
{
	do {
    	System.out.println("------CẬP NHẬT THÔNG TIN HỆ THỐNG-------");
        System.out.println("Chọn chức năng cập nhật");
        System.out.println("\t 1.Cập nhật thông tin sinh viên");
        System.out.println("\t 2.Cập nhật thông tin môn học");
        System.out.println("\t 3.Cập nhật thông tin điểm ");
        System.out.println("\t 0.Quay lại");
        String bChon="";
        String ma="\\d+";
		do {
			System.out.println("\tMời bạn nhập lựa chọn:");
			bChon=Helper.scan.nextLine();
		}while(!bChon.matches(ma));
		int chon=Integer.parseInt(bChon);
        switch(chon)
        {
        case 1: quanLiSinhVien.capNhatThongTinSinhVien();break;
        case 2: quanLiMonHoc.capNhatThongTinMonHoc();break;
        case 3: quanLiDiem.capNhatThongTinDiem();break;
        case 0:return;
        default: System.out.println("Lựa chọn chưa hợp lệ");
        Helper.bamEnterDeTiepTuc();
        }
    }while(true);	
}
public void hienThiBangDiem()
{
   quanLiDiem.hienThiBangDiem();	

}
public void timKiemThongTin()
{
	
	  do {
	    	System.out.println("------TÌM KIẾM THÔNG TIN THÔNG TIN HỆ THỐNG-------");
	        System.out.println("Chọn chức năng tìm kiếm");
	        System.out.println("\t 1.Tìm kiếm thông tin sinh viên");
	        System.out.println("\t 2.Tìm kiếm thông tin môn học");
	        System.out.println("\t 0.Quay lại");
	        String bChon="";
	        String ma="\\d+";
			do {
				System.out.println("\tMời bạn nhập lựa chọn:");
				bChon=Helper.scan.nextLine();
			}while(!bChon.matches(ma));
			int chon=Integer.parseInt(bChon);
	        switch(chon)
	        {
	        case 1: quanLiDiem.timKiemThongTinSinhVien();break;
	        case 2: quanLiDiem.timKiemThongTinMonHoc();break;
	        case 0:return;
	        default: System.out.println("Lựa chọn chưa hợp lệ");
	        Helper.bamEnterDeTiepTuc();
	        }
	    }while(true);
}
}
