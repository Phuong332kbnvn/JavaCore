package vn.devpro.baitapcuoikhoa;

public class MonHoc {
private int heSoMon,maMon;
private String tenMon;

public MonHoc() {
	super();
}
public MonHoc(int heSoMon, int maMon, String tenMon) {
	super();
	this.heSoMon = heSoMon;
	this.maMon = maMon;
	this.tenMon = tenMon;
}
public int getHeSoMon() {
	return heSoMon;
}
public void setHeSoMon(int heSoMon) {
	this.heSoMon = heSoMon;
}
public int getMaMon() {
	return maMon;
}
public void setMaMon(int maMon) {
	this.maMon = maMon;
}
public String getTenMon() {
	return tenMon;
}
public void setTenMon(String tenMon) {
	this.tenMon = tenMon;
}
public void display()
{
	System.out.printf("%-6d",maMon);
	System.out.printf("%-20s",tenMon);
	System.out.printf("%-5d %n",heSoMon);
	
}
}
