package vn.devpro.baitapcuoikhoa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuanLiSinhVien {
public static List<SinhVien> list=new ArrayList<SinhVien>();
SinhVien sv;
public void capNhatThongTinSinhVien()
{  
	do {
	System.out.println("\t--------Cập nhật thông tin sinh viên------------");
	System.out.println("\tChọn chức năng cập nhật...");
	System.out.println("\t1. Thêm sinh viên.");
	System.out.println("\t2. Sửa thông tin sinh viên.");
	System.out.println("\t3. Xóa thông tin sinh viên");//làm sau khi đã làm danh sách điểm
	System.out.println("\t4. Hiển thị danh sách sinh viên sau khi sắp xếp");
	System.out.println("\t0. Để quay lại...");
	 String bChon="";
	 String ma="\\d+";
	do {
		System.out.println("\tMời bạn nhập lựa chọn:");
		bChon=Helper.scan.nextLine();
	}while(!bChon.matches(ma));
	int chon=Integer.parseInt(bChon);
	switch(chon)
	{
	case 1: themSinhVien();break;
	case 2: suaThongTinSinhVien();break;
	case 3: xoaSinhVien();break;
	case 4: hienThiThongTinSV();break;
	case 0: return;
	default: System.out.println("lựa chọn không hợp lệ");
	Helper.bamEnterDeTiepTuc();
	}}while(true);
	
}
private void themSinhVien() {
	sv=new SinhVien();
	System.out.println("---------Thêm mới sinh viên---------");
	System.out.println("Nhập mã sinh viên:");
	int masv=0;
	try {
		masv=Integer.parseInt(Helper.scan.nextLine());
	} catch (NumberFormatException e) {
		System.out.println("Mã sinh viên nhập vào không hợp lệ.");
		Helper.bamEnterDeTiepTuc();
		return;
	}
	int index=-1;
	index=Helper.timSinhVienTrungMa(masv);
	if(index!=-1)
	{
		System.out.println("Sinh viên có mã "+masv+" đã tồn tại.");
		Helper.bamEnterDeTiepTuc();
		return;
	}
	 sv.setMaSV(masv);
	System.out.println("Nhập họ đệm:");
	sv.setHoDem(Helper.scan.nextLine());
   System.out.println("Nhập tên:");
   sv.setTen(Helper.scan.nextLine());
   System.out.println("Nhập năm sinh:");
   int namS=0;
	try {
		namS=Integer.parseInt(Helper.scan.nextLine());
	} catch (NumberFormatException e) {
		System.out.println("Năm sinh của sinh viên nhập vào không hợp lệ.");
		Helper.bamEnterDeTiepTuc();
		return;
	}
	sv.setNamSinh(namS);
    System.out.println("Nhập giới tính:");
    sv.setGioiTinh(Helper.scan.nextLine());
    list.add(sv);
    System.out.println("Thêm sinh viên thành công.");
	Helper.bamEnterDeTiepTuc();
	return;
}
private void suaThongTinSinhVien() {
	System.out.println("Nhập mã sinh viên của sinh viên muốn sửa:");
	int masv=0;
	try {
		masv=Integer.parseInt(Helper.scan.nextLine());
	} catch (NumberFormatException e) {
		System.out.println("Mã sinh viên nhập vào không hợp lệ.");
		Helper.bamEnterDeTiepTuc();
		return;
	}
	int index=-1;
	index=Helper.timSinhVienTrungMa(masv);
	if(index==-1)
	{
		System.out.println("Sinh viên có mã "+masv+" không tồn tại.");
		Helper.bamEnterDeTiepTuc();
		return;
	}
	do {
		System.out.println("\t--------Sửa thông tin sinh viên------------");
		System.out.println("\tChọn chức năng cập nhật...");
		System.out.println("\t1. Sửa họ đệm.");
		System.out.println("\t2. Sửa tên.");
		System.out.println("\t3. Sửa năm sinh");
		System.out.println("\t4. Sửa giới tính");
		System.out.println("\t0. Để quay lại...");
		 String bChon="";
		 String ma="\\d+";
		do {
			System.out.println("\tMời bạn nhập lựa chọn:");
			bChon=Helper.scan.nextLine();
		}while(!bChon.matches(ma));
		int chon=Integer.parseInt(bChon);
		switch(chon)
		{
		case 1: suaHoDem(index);break;
		case 2: suaTen(index);break;
		case 3: suaNamSinh(index);break;
		case 4: suaGioiTinh(index);break;
		case 0: return;
		default: System.out.println("lựa chọn không hợp lệ");
		Helper.bamEnterDeTiepTuc();
		}}while(true);
}
private void suaHoDem(int index) {
	System.out.println("Nhập họ đêm mới cho sinh viên:");
	list.get(index).setHoDem(Helper.scan.nextLine());
	System.out.println("Sửa thành công...");
	Helper.bamEnterDeTiepTuc();
}
private void suaTen(int index) {
	System.out.println("Nhập tên mới cho sinh viên:");
	list.get(index).setTen(Helper.scan.nextLine());
	
}
private void suaNamSinh(int index) {
	System.out.println("Nhập năm sinh mới cho sinh viên:");
	 int namS=0;
		try {
			namS=Integer.parseInt(Helper.scan.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Năm sinh của sinh viên nhập vào không hợp lệ.");
			Helper.bamEnterDeTiepTuc();
			return;
		}
	list.get(index).setNamSinh(namS);
	System.out.println("Sửa thành công...");
	Helper.bamEnterDeTiepTuc();
}
private void suaGioiTinh(int index) {
	System.out.println("Nhập giới tính cho sinh viên:");
	list.get(index).setGioiTinh(Helper.scan.nextLine());
	System.out.println("Sửa thành công...");
	Helper.bamEnterDeTiepTuc();
	
}
private void xoaSinhVien() {
	System.out.println("---------Xóa sinh viên -----------");
	System.out.println("Nhập mã sinh viên của sinh viên muốn xóa:");
	int masv=0;
	try {
		masv=Integer.parseInt(Helper.scan.nextLine());
	} catch (NumberFormatException e) {
		System.out.println("Mã sinh viên nhập vào không hợp lệ.");
		Helper.bamEnterDeTiepTuc();
		return;
	}
	int index=-1;
	index=Helper.timSinhVienTrungMa(masv);
	if(index==-1)
	{
		System.out.println("Sinh viên có mã "+masv+" không tồn tại.");
		Helper.bamEnterDeTiepTuc();
		return;
	}
	int index1=-1;
	index1=Helper.timSinhVienTrongBangDiem(masv);
	if(index1!=-1)
	{
		System.out.println("Sinh viên đã tồn tại trong bảng điểm không thể xóa");
		Helper.bamEnterDeTiepTuc();
		return;
		
	}
	list.remove(index);
	System.out.println("Xóa thành công");
	Helper.bamEnterDeTiepTuc();
	return;
}
private void hienThiThongTinSV() {
	System.out.println("-----------Hiển thị danh sách sinh viên sau khi sắp xếp--------------");
	Collections.sort(list, new Comparator<SinhVien>() {

		@Override
		public int compare(SinhVien a1, SinhVien a2) {
			return a1.getTen().compareToIgnoreCase(a2.getTen());
		}
		
	});
	System.out.printf("%-10s ","Ma SV");
	System.out.printf("%-16s ","Ho ten");
	System.out.printf("%-8s ","Nam sinh");
	System.out.printf("%-9s %n","Gioi tinh");

	for(SinhVien sv: list)
	{
		sv.display();
	}
}

}
