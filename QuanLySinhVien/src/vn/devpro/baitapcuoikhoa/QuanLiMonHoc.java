package vn.devpro.baitapcuoikhoa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuanLiMonHoc {
	public static List<MonHoc> list=new ArrayList<MonHoc>();
	MonHoc monHoc;
  public void capNhatThongTinMonHoc()
  {  
	  do {
		System.out.println("\t--------Cập nhật thông tin môn học------------");
		System.out.println("\tChọn chức năng cập nhật...");
		System.out.println("\t1. Thêm môn học.");
		System.out.println("\t2. Sửa thông tin môn học.");
		System.out.println("\t3. Xóa thông tin môn học.");//làm sau khi đã làm danh sách điểm
		System.out.println("\t4. Hiển thị danh sách môn sau khi sắp xếp");
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
		case 1: themMonHoc();break;
		case 2: suaThongTinMonHoc();break;
		case 3: xoaMonHoc();break;
		case 4: hienThiThongTinMH();break;
		case 0: return;
		default: System.out.println("lựa chọn không hợp lệ");
		Helper.bamEnterDeTiepTuc();
		}}while(true);
	  
	  
  }
  private void themMonHoc() {
	  monHoc=new MonHoc();
		System.out.println("---------Thêm môn học mới---------");
		System.out.println("Nhập mã môn học:");
		int mamh=0;
		try {
			mamh=Integer.parseInt(Helper.scan.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Mã môn học nhập vào không hợp lệ.");
			Helper.bamEnterDeTiepTuc();
			return;
		}
		int index=-1;
		index=Helper.timMonHocTrungMa(mamh);
		if(index!=-1)
		{
			System.out.println("Môn học có mã "+mamh+" đã tồn tại.");
			Helper.bamEnterDeTiepTuc();
			return;
		}
		 monHoc.setMaMon(mamh);
		System.out.println("Nhập tên môn học:");
		monHoc.setTenMon(Helper.scan.nextLine());
	   System.out.println("Nhập hệ số của môn:");
	   int heS=0;
		try {
			heS=Integer.parseInt(Helper.scan.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Hệ số của môn học nhập vào không hợp lệ.");
			Helper.bamEnterDeTiepTuc();
			return;
		}
	    monHoc.setHeSoMon(heS);
	    list.add(monHoc);
	    System.out.println("Thêm môn học thành công.");
		Helper.bamEnterDeTiepTuc();
		return;
	
}
private void suaThongTinMonHoc() {
	System.out.println("Nhập mã môn học muốn sửa:");
	int mamh=0;
	try {
		mamh=Integer.parseInt(Helper.scan.nextLine());
	} catch (NumberFormatException e) {
		System.out.println("Mã môn học nhập vào không hợp lệ.");
		Helper.bamEnterDeTiepTuc();
		return;
	}
	int index=-1;
	index=Helper.timMonHocTrungMa(mamh);
	if(index==-1)
	{
		System.out.println("Môn học có mã "+mamh+" không tồn tại.");
		Helper.bamEnterDeTiepTuc();
		return;
	}
	do {
		System.out.println("\t--------Sửa thông tin môn học------------");
		System.out.println("\tChọn chức năng cập nhật...");
		System.out.println("\t1. Sửa tên môn học.");
		System.out.println("\t2. Sửa hệ số môn.");
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
		case 1: suaTenMonHoc(index);break;
		case 2: suaHeSoMon(index);break;
		case 0: return;
		default: System.out.println("lựa chọn không hợp lệ");
		Helper.bamEnterDeTiepTuc();
		}}while(true);
	
}
private void suaTenMonHoc(int index) {
	System.out.println("Nhập tên môn học:");
    list.get(index).setTenMon(Helper.scan.nextLine());	
    System.out.println("Sửa thành công.");
	Helper.bamEnterDeTiepTuc();
	return;
}
private void suaHeSoMon(int index) {
	   System.out.println("Nhập hệ số của môn sửa:");
	   int heS=0;
		try {
			heS=Integer.parseInt(Helper.scan.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Hệ số của môn học nhập vào không hợp lệ.");
			Helper.bamEnterDeTiepTuc();
			return;
		}
		list.get(index).setHeSoMon(heS);
		System.out.println("Sửa thành công.");
		Helper.bamEnterDeTiepTuc();
		return;
}
private void xoaMonHoc() {
	System.out.println("Nhập mã môn học muốn xóa:");
	int mamh=0;
	try {
		mamh=Integer.parseInt(Helper.scan.nextLine());
	} catch (NumberFormatException e) {
		System.out.println("Mã môn học nhập vào không hợp lệ.");
		Helper.bamEnterDeTiepTuc();
		return;
	}
	int index=-1;
	index=Helper.timMonHocTrungMa(mamh);
	if(index==-1)
	{
		System.out.println("Môn học có mã "+mamh+" không tồn tại.");
		Helper.bamEnterDeTiepTuc();
		return;
	}
	int index1=-1;
	index1=Helper.timMonHocTrongBangDiem(mamh);
	if(index1!=-1)
	{
		System.out.println("Môn học đã tồn tại trong bảng điểm không thể xóa");
		Helper.bamEnterDeTiepTuc();
		return;
		
	}
	
	list.remove(index);
	System.out.println("Xóa thành công");
	Helper.bamEnterDeTiepTuc();
	return;
	
}
private void hienThiThongTinMH() {
	System.out.println("--------Danh sách môn học sau khi sắp xếp-------");
	System.out.printf("%-6s ","Mã môn");
	System.out.printf("%-20s ","Tên môn");
	System.out.printf("%-5s %n","Hệ số");
	Collections.sort(list, new Comparator<MonHoc>() {

		@Override
		public int compare(MonHoc o1, MonHoc o2) {
			// TODO Auto-generated method stub
			return o1.getTenMon().compareToIgnoreCase(o2.getTenMon());
		}
		
	});
	for(MonHoc mh: list)
	{
		mh.display();
	}
	Helper.bamEnterDeTiepTuc();
}

}
