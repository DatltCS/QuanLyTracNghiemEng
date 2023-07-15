public class PhuongAn {

	private String noiDung;

	private String ghiChu;

	public PhuongAn(String noiDung) {
		this.noiDung = noiDung;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public void xuat(){
		System.out.println(this.noiDung);
	}
}
