package vn.devpro.baitapcuoikhoa;

public class SinhVien {
private String hoDem,ten,gioiTinh;
private int maSV,namSinh;
public SinhVien(String hoDem, String ten, String gioiTinh, int maSV, int namSinh) {
	super();
	this.hoDem = hoDem;
	this.ten = ten;
	this.gioiTinh = gioiTinh;
	this.maSV = maSV;
	this.namSinh = namSinh;
}
public SinhVien() {
	super();
}
public String getHoDem() {
	return hoDem;
}
public void setHoDem(String hoDem) {
	this.hoDem = hoDem;
}
public String getTen() {
	return ten;
}
public void setTen(String ten) {
	this.ten = ten;
}
public String getGioiTinh() {
	return gioiTinh;
}
public void setGioiTinh(String gioiTinh) {
	this.gioiTinh = gioiTinh;
}
public int getMaSV() {
	return maSV;
}
public void setMaSV(int maSV) {
	this.maSV = maSV;
}
public int getNamSinh() {
	return namSinh;
}
public void setNamSinh(int namSinh) {
	this.namSinh = namSinh;
}
public void display()
{
System.out.printf("%-10d ",maSV);
System.out.printf("%-10s %-6s ",hoDem,ten);
System.out.printf("%-7d ",namSinh);
System.out.printf("%-9s %n",gioiTinh);


}

}
