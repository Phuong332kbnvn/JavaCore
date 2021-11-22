package vn.devpro.baitapcuoikhoa;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuanLiDiem {
public static List<Diem> list=new ArrayList<Diem>();
Diem d;
public void capNhatThongTinDiem()
{   do {
	System.out.println("\t--------Cập nhật thông tin điểm----------");
	System.out.println("\tMời bạn chọn chức năng.");
	System.out.println("\t1. Nhập điểm cho sinh viên.");
	System.out.println("\t2. Sửa điểm cho sinh viên");
	System.out.println("\t3. Xóa điểm một môn học của một sinh viên");
    System.out.println("\t4. Hiển thị bảng điểm");
	System.out.println("\t0. Để quay lại.");
	 String bChon="";
	 String ma="\\d+";
	do {
		System.out.println("\tMời bạn nhập lựa chọn:");
		bChon=Helper.scan.nextLine();
	}while(!bChon.matches(ma));
	int chon=Integer.parseInt(bChon);
	switch(chon)
	{
	case 1: nhapDiem();break;
	case 2: suaDiem();break;
	case 3:xoaDiem();break;
	case 4: this.hienThiBangDiem();break;
	case 0: return;
	default: System.out.println("lựa chọn không hợp lệ");
	Helper.bamEnterDeTiepTuc();
	}
}while(true);
}
private void nhapDiem() {
	d=new Diem();
	System.out.println("Nhập mã sinh viên của sinh viên muốn nhập điểm:");
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
	System.out.println("Nhập mã môn học :");
	int mamh=0;
	try {
		mamh=Integer.parseInt(Helper.scan.nextLine());
	} catch (NumberFormatException e) {
		System.out.println("Mã môn học nhập vào không hợp lệ.");
		Helper.bamEnterDeTiepTuc();
		return;
	}
	int index1=-1;
	index1=Helper.timMonHocTrungMa(mamh);
	if(index1==-1)
	{
		System.out.println("Môn học có mã "+mamh+" không tồn tại.");
		Helper.bamEnterDeTiepTuc();
		return;
	}
	int index2=-1;
	index2=Helper.timSinhVienMonHoc(masv, mamh);
	if(index2!=-1)
	{
		System.out.println("Sinh viên học môn học đã được nhập điểm");
		Helper.bamEnterDeTiepTuc();
		return;
	}
	System.out.println("Nhập điểm cho sinh viên: "+QuanLiSinhVien.list.get(Helper.timSinhVienTrungMa(masv)).getHoDem()+" "+
			QuanLiSinhVien.list.get(Helper.timSinhVienTrungMa(masv)).getTen()
			+" Môn học: "+QuanLiMonHoc.list.get(Helper.timMonHocTrungMa(mamh)).getTenMon()
			);
	double diem=0;
	try {
		
		diem=Double.parseDouble(Helper.scan.nextLine());
	} catch (NumberFormatException e) {
		System.out.println("Điểm nhập vào không hợp lệ.");
		Helper.bamEnterDeTiepTuc();
		return;
	}
	
	if(diem<0 || diem >10)
	{
		System.out.println("Điểm phải nằm trong khoảng từ 0 đến 10");
		Helper.bamEnterDeTiepTuc();
		return;
	}
	
	d.setMaSV(masv);
	d.setMaMon(mamh);
	d.setDiem(diem);
	list.add(d);
	System.out.println("Thêm điểm thành công");
	Helper.bamEnterDeTiepTuc();
	return;
	
}
private void suaDiem() {
	System.out.println("Nhập mã sinh viên của sinh viên muốn sửa điểm:");
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
	System.out.println("Nhập mã môn học muốn sửa:");
	int mamh=0;
	try {
		mamh=Integer.parseInt(Helper.scan.nextLine());
	} catch (NumberFormatException e) {
		System.out.println("Mã môn học nhập vào không hợp lệ.");
		Helper.bamEnterDeTiepTuc();
		return;
	}
	int index1=-1;
	index1=Helper.timMonHocTrungMa(mamh);
	if(index1==-1)
	{
		System.out.println("Môn học có mã "+mamh+" không tồn tại.");
		Helper.bamEnterDeTiepTuc();
		return;
	}
	System.out.println("Nhập điểm sửa cho sinh viên: "+QuanLiSinhVien.list.get(Helper.timSinhVienTrungMa(masv)).getHoDem()+" "+
			QuanLiSinhVien.list.get(Helper.timSinhVienTrungMa(masv)).getTen()
			+" Môn học: "+QuanLiMonHoc.list.get(Helper.timMonHocTrungMa(mamh)).getTenMon()
			);
	double diem=0;
	try {
		
		diem=Double.parseDouble(Helper.scan.nextLine());
	} catch (NumberFormatException e) {
		System.out.println("Điểm nhập vào không hợp lệ.");
		Helper.bamEnterDeTiepTuc();
		return;
	}
	int index2=-1;
	index2=Helper.timSinhVienMonHoc(masv, mamh);
	if(index2==-1)
	{
		System.out.println("Sinh viên học môn học chưa được nhập điểm");
		Helper.bamEnterDeTiepTuc();
		return;
	}
	if(diem<0 || diem >10)
	{
		System.out.println("Điểm phải nằm trong khoảng từ 0 đến 10");
		Helper.bamEnterDeTiepTuc();
		return;
	}
    
	list.get(index2).setDiem(diem);;
	System.out.println("Sửa điểm thành công");
	Helper.bamEnterDeTiepTuc();
	return;
	
}
private void xoaDiem() {
	System.out.println("Nhập mã sinh viên của sinh viên muốn xóa điểm:");
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
	System.out.println("Nhập mã môn học muốn xóa:");
	int mamh=0;
	try {
		mamh=Integer.parseInt(Helper.scan.nextLine());
	} catch (NumberFormatException e) {
		System.out.println("Mã môn học nhập vào không hợp lệ.");
		Helper.bamEnterDeTiepTuc();
		return;
	}
	int index1=-1;
	index1=Helper.timMonHocTrungMa(mamh);
	if(index1==-1)
	{
		System.out.println("Môn học có mã "+mamh+" không tồn tại.");
		Helper.bamEnterDeTiepTuc();
		return;
	}
	int index2=-1;
	index2=Helper.timSinhVienMonHoc(masv, mamh);
	if(index2==-1)
	{
		System.out.println("Sinh viên học môn học chưa được nhập điểm");
		Helper.bamEnterDeTiepTuc();
		return;
	}
	list.remove(index2);
	System.out.println("Đã xóa sinh viên: "+QuanLiSinhVien.list.get(Helper.timSinhVienTrungMa(masv)).getHoDem()+" "+
			QuanLiSinhVien.list.get(Helper.timSinhVienTrungMa(masv)).getTen()
			+" Và môn học: "+QuanLiMonHoc.list.get(Helper.timMonHocTrungMa(mamh)).getTenMon()
			);
	System.out.println("Xóa thành công...");
	Helper.bamEnterDeTiepTuc();
	return;
}
public void hienThiBangDiem()
{
	 do {
			System.out.println("\t--------Hiển thị bảng điểm----------");
			System.out.println("\tMời bạn chọn chức năng.");
			System.out.println("\t1. Hiển thị bảng điểm của tất cả sinh viên.");
			System.out.println("\t2. Hiển thị bảng điểm của tất cả môn học");
			System.out.println("\t0. Để quay lại.");
			 String bChon="";
			 String ma="\\d+";
			do {
				System.out.println("\tMời bạn nhập lựa chọn:");
				bChon=Helper.scan.nextLine();
			}while(!bChon.matches(ma));
			int chon=Integer.parseInt(bChon);
			switch(chon)
			{
			case 1: hienThiBangDiemSV();break;
			case 2: hienThiBangDiemMH();break;
			case 0: return;
			default: System.out.println("\tlựa chọn không hợp lệ");
			Helper.bamEnterDeTiepTuc();
			}
		}while(true);

}
private void hienThiBangDiemSV() {
    System.out.println("--------Bảng điểm của tất cả các sinh viên------");
    Collections.sort(QuanLiSinhVien.list, new Comparator<SinhVien>() {
		@Override
		public int compare(SinhVien o1, SinhVien o2) {
			if(o1.getMaSV()>o2.getMaSV()) return 1;
			else if(o1.getMaSV()>o2.getMaSV()) return -1;
			else return 0;
			
		}
    	
	});
	DecimalFormat de=new DecimalFormat("##.0#");
    for(int i=0;i<QuanLiSinhVien.list.size();i++)
    {   int index=-1;
        index=Helper.timSinhVienTrongBangDiem(QuanLiSinhVien.list.get(i).getMaSV());
        if(index!=-1)
        {   System.out.println("Mã sinh viên:"+QuanLiSinhVien.list.get(i).getMaSV());
            System.out.println("Họ tên sinh viên:"+QuanLiSinhVien.list.get(i).getHoDem()+" "+QuanLiSinhVien.list.get(i).getTen());
        	double tong=0;
        	double tonghs=0;
        	System.out.printf("%-6s ","Mã môn");
        	System.out.printf("%-20s ","Tên môn");
        	System.out.printf("%-5s ","Hệ số");
        	System.out.printf("%-5s %n","Điểm");
            for(int j=0;j<list.size();++j)
        	{   
        		
        		if(list.get(j).getMaSV()==QuanLiSinhVien.list.get(i).getMaSV())
        		{   //hiển thi mã môn tên môn hệ số của môn học
        			MonHoc monHoc=new MonHoc();
        			monHoc=Helper.timMonHoc(list.get(j).getMaMon());
        			System.out.printf("%-6d ",monHoc.getMaMon());
        			System.out.printf("%-20s ",monHoc.getTenMon());
        			System.out.printf("%-5d ",monHoc.getHeSoMon());
        			tong=tong+list.get(j).getDiem()*Helper.timHeSoMonHoc(list.get(j).getMaMon());
        			tonghs=tonghs+Helper.timHeSoMonHoc(list.get(j).getMaMon());
        			System.out.printf("%-5s %n",de.format(list.get(j).getDiem()));
        		}
        		
        	}
            double diemTK=tong/tonghs;
            System.out.println("Điểm tổng kết: "+de.format(diemTK));
        	System.out.println();
        	System.out.println("-------------------------------------------------");
            System.out.println();
        }
       
    }
    Helper.bamEnterDeTiepTuc();
	
}
private void hienThiBangDiemMH() {
	System.out.println("------------Hiển thị bảng điểm của tất cả các môn học-----------");
	for(int i=0;i<QuanLiMonHoc.list.size();++i)
	{  
		int index=-1;
		index=Helper.timMonHocTrongBangDiem(QuanLiMonHoc.list.get(i).getMaMon());
		if(index!=-1)
		{ double diemtk=0,tong=0,dem=0;
		System.out.println("Mã môn học: "+QuanLiMonHoc.list.get(i).getMaMon());
		System.out.println("Tên môn học: "+QuanLiMonHoc.list.get(i).getTenMon());
			 for(int j=0;j<list.size();++j)
	        	{   
	        		
	        		if(list.get(j).getMaMon()==QuanLiMonHoc.list.get(i).getMaMon())
	        		{  
	        			tong=tong+list.get(j).getDiem()*QuanLiMonHoc.list.get(i).getHeSoMon();
	        			dem++;
	        		}
	        		
	        	} 
			 diemtk=tong/(dem*QuanLiMonHoc.list.get(i).getHeSoMon());
			 DecimalFormat de=new DecimalFormat("##.0#");
		   System.out.println("Điểm trung bình của môn: "+de.format(diemtk));
		   System.out.printf("%-10s ","Mã SV");
		   System.out.printf("%-16s ","Họ tên sv");
		   System.out.printf("%-5s %n","Điểm");
		   for(int j=0;j<list.size();++j)
       	{   
			 
       		if(list.get(j).getMaMon()==QuanLiMonHoc.list.get(i).getMaMon())
       		{   SinhVien sv=new SinhVien();
       		  sv=Helper.timSinhVieN(list.get(j).getMaSV());
       			System.out.printf("%-10d ",sv.getMaSV());
       			System.out.printf("%-10s %-6s ",sv.getHoDem(),sv.getTen());
       			System.out.printf("%2.2f %n",list.get(j).getDiem());
       			
       		}
       		
       	}
		   System.out.println();
		   System.out.println("-------------------------------------------------");
			 System.out.println();
		}
		 
		 
	}
	Helper.bamEnterDeTiepTuc();
	
}
public void timKiemThongTinSinhVien()
{
	System.out.println("Nhập mã sinh viên của sinh viên muốn tìm kiếm:");
	int masv=0;
	try {
		masv=Integer.parseInt(Helper.scan.nextLine());
	} catch (NumberFormatException e) {
		System.out.println("Mã sinh viên nhập vào không hợp lệ.");
		Helper.bamEnterDeTiepTuc();
		return;
	}
	int index1=-1;
	int index=-1;
	index=Helper.timSinhVienTrungMa(masv);
	if(index==-1)
	{
		System.out.println("Sinh viên có mã "+masv+" không tồn tại.");
		Helper.bamEnterDeTiepTuc();
		return;
	}
	index1=Helper.timSinhVienTrongBangDiem(masv);
	if(index1==-1)
	{
		System.out.println("Sinh viên có mã "+masv+" chưa được nhập điểm");
		Helper.bamEnterDeTiepTuc();
		return;
	}
	
	System.out.println("--------Bảng điểm của sinh viên "+QuanLiSinhVien.list.get(index).getHoDem()+" "+QuanLiSinhVien.list.get(index).getTen()+"---------");
            System.out.println("Mã sinh viên:"+QuanLiSinhVien.list.get(index).getMaSV());
            System.out.println("Họ tên sinh viên:"+QuanLiSinhVien.list.get(index).getHoDem()+" "+QuanLiSinhVien.list.get(index).getTen());
        	double tong=0;
        	double tonghs=0;
        	DecimalFormat de=new DecimalFormat("##.0#");
        	System.out.printf("%-6s ","Mã môn");
        	System.out.printf("%-20s ","Tên môn");
        	System.out.printf("%-5s ","Hệ số");
        	System.out.printf("%-5s %n","Điểm");
            for(int j=0;j<list.size();++j)
        	{   
        		
        		if(list.get(j).getMaSV()==QuanLiSinhVien.list.get(index).getMaSV())
        		{   //hiển thi mã môn tên môn hệ số của môn học
        			MonHoc monHoc=new MonHoc();
        			monHoc=Helper.timMonHoc(list.get(j).getMaMon());
        			System.out.printf("%-6d ",monHoc.getMaMon());
        			System.out.printf("%-20s ",monHoc.getTenMon());
        			System.out.printf("%-5d ",monHoc.getHeSoMon());
        			tong=tong+list.get(j).getDiem()*Helper.timHeSoMonHoc(list.get(j).getMaMon());
        			tonghs=tonghs+Helper.timHeSoMonHoc(list.get(j).getMaMon());
        			System.out.printf("%-5s %n",de.format(list.get(j).getDiem()));
        		}
        		
        	}
            double diemTK=tong/tonghs;
            System.out.println("Điểm tổng kết: "+de.format(diemTK));
        	System.out.println();
        
       System.out.println("-------------------------------------------------");
       System.out.println();
    
    Helper.bamEnterDeTiepTuc();
	
}
public void timKiemThongTinMonHoc()
{
	System.out.println("Nhập mã môn học muốn tìm kiếm:");
	int mamh=0;
	try {
		mamh=Integer.parseInt(Helper.scan.nextLine());
	} catch (NumberFormatException e) {
		System.out.println("Mã môn học nhập vào không hợp lệ.");
		Helper.bamEnterDeTiepTuc();
		return;
	}
	int index1=-1;
	index1=Helper.timMonHocTrungMa(mamh);
	if(index1==-1)
	{
		System.out.println("Môn học có mã "+mamh+" không tồn tại.");
		Helper.bamEnterDeTiepTuc();
		return;
	}
	int index2=-1;
	index2=Helper.timMonHocTrongBangDiem(mamh);
	if(index2==-1)
	{
		System.out.println("Môn học chưa được nhập điểm");
		Helper.bamEnterDeTiepTuc();
		return;
	}
	
	
	
	
	System.out.println("------------Hiển thị bảng điểm môn học "+QuanLiMonHoc.list.get(index1).getTenMon() +"-----------");
	 double diemtk=0,tong=0,dem=0;
		System.out.println("Mã môn học: "+QuanLiMonHoc.list.get(index1).getMaMon());
		System.out.println("Tên môn học: "+QuanLiMonHoc.list.get(index1).getTenMon());
			 for(int j=0;j<list.size();++j)
	        	{   
	        		
	        		if(list.get(j).getMaMon()==QuanLiMonHoc.list.get(index1).getMaMon())
	        		{  
	        			tong=tong+list.get(j).getDiem()*QuanLiMonHoc.list.get(index1).getHeSoMon();
	        			dem++;
	        		}
	        		
	        	} 
			 diemtk=tong/(dem*QuanLiMonHoc.list.get(index1).getHeSoMon());
			 DecimalFormat de=new DecimalFormat("##.0#");
		   System.out.println("Điểm trung bình của môn: "+de.format(diemtk));
		   System.out.printf("%-10s ","Mã SV");
		   System.out.printf("%-16s ","Họ tên sv");
		   System.out.printf("%-5s %n","Điểm");
		   for(int j=0;j<list.size();++j)
       	{   
			 
       		if(list.get(j).getMaMon()==QuanLiMonHoc.list.get(index1).getMaMon())
       		{   SinhVien sv=new SinhVien();
       		  sv=Helper.timSinhVieN(list.get(j).getMaSV());
       			System.out.printf("%-10d ",sv.getMaSV());
       			System.out.printf("%-10s %-6s ",sv.getHoDem(),sv.getTen());
       			System.out.printf("%2.2f %n",list.get(j).getDiem());
       			
       		}
	    }
		   System.out.println();
			 System.out.println("-------------------------------------------------");
			 System.out.println();
			 Helper.bamEnterDeTiepTuc();
	
}
}
