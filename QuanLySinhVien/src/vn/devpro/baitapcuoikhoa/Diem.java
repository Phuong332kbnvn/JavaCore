package vn.devpro.baitapcuoikhoa;

public class Diem {
   private int maSV,maMon;
    private double diem;
	public Diem(int maSV, int maMon, double diem) {
		super();
		this.maSV = maSV;
		this.maMon = maMon;
		this.diem = diem;
	}
	public Diem() {
		super();
	}
	public int getMaSV() {
		return maSV;
	}
	public void setMaSV(int maSV) {
		this.maSV = maSV;
	}
	public int getMaMon() {
		return maMon;
	}
	public void setMaMon(int maMon) {
		this.maMon = maMon;
	}
	public double getDiem() {
		return diem;
	}
	public void setDiem(double diem) {
		this.diem = diem;
	}

    
}
