package vn.devpro.baitapcuoikhoa;

import java.util.Scanner;

public class Helper {
	public static Scanner scan=new Scanner(System.in);
	public  static void bamEnterDeTiepTuc()
	{
	 System.out.println("Bấm enter để tiếp tục.....");	scan.nextLine();
	}
	//tìm mã sinh viên 
	public static int timSinhVienTrungMa(int masv)
	{
		for(int i=0;i<QuanLiSinhVien.list.size();++i)
		{
			if(QuanLiSinhVien.list.get(i).getMaSV()==masv)
			{
				return i;
			}
		}
		return -1;
	}
	//tìm theo mã môn học 
	public static int timMonHocTrungMa(int mamh)
	{
		for(int i=0;i<QuanLiMonHoc.list.size();++i)
		{
			if(QuanLiMonHoc.list.get(i).getMaMon()==mamh)
			{
				return i;
			}
		}
		return -1;
	}
	//lay he so cua mon hoc
	public static int timHeSoMonHoc(int mamh)
	{
		for(int i=0;i<QuanLiMonHoc.list.size();++i)
		{
			if(QuanLiMonHoc.list.get(i).getMaMon()==mamh)
			{
				return QuanLiMonHoc.list.get(i).getHeSoMon();
			}
		}
		return -1;
	}
	//tìm sinh viên có trong bảng điểm không
	public static int timSinhVienTrongBangDiem(int masv)
	{
		for(int i=0;i<QuanLiDiem.list.size();++i)
		{
			if(QuanLiDiem.list.get(i).getMaSV()==masv)
			{
				return i;
			}
		}
		return -1;
	}
	//tìm môn học trong bảng điểm
	public static int timMonHocTrongBangDiem(int mamh)
	{
		for(int i=0;i<QuanLiDiem.list.size();++i)
		{
			if(QuanLiDiem.list.get(i).getMaMon()==mamh)
			{
				return i;
			}
		}
		return -1;
	}
	
	//tìm sinh viên đã được nhập điểm vào môn học chưa
	public static int timSinhVienMonHoc(int masv,int mamh)
	{
		for(int i=0;i<QuanLiDiem.list.size();++i)
		{
			if(QuanLiDiem.list.get(i).getMaMon()==mamh && QuanLiDiem.list.get(i).getMaSV()==masv)
			{
				return i;
			}
		}
		return -1;
	}
	//tìm môn học
	public static MonHoc timMonHoc(int mamh)
	{
		MonHoc mh=new MonHoc();
		for(int i=0;i<QuanLiMonHoc.list.size();++i)
		{
			if(QuanLiMonHoc.list.get(i).getMaMon()==mamh)
			{
				mh=QuanLiMonHoc.list.get(i);
				return mh;
			}
		}
		return mh;
	}

	//tìm sinh viên 
	public static SinhVien timSinhVieN(int masv)
	{   SinhVien sv=new SinhVien();
		for(int i=0;i<QuanLiSinhVien.list.size();++i)
		{
			if(QuanLiSinhVien.list.get(i).getMaSV()==masv)
			{   sv=QuanLiSinhVien.list.get(i);
				return sv;
			}
		}
		return sv;
	}
}
