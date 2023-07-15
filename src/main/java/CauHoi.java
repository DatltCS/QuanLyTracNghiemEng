import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CauHoi {

	private String noiDung;

	private DanhMuc danhMuc;

	private DoKho doKho;

	private Collection<BaiLuyenTap> baiLuyenTap;

	public CauHoi(String noiDung, DanhMuc danhMuc, DoKho doKho) {
		this.noiDung = noiDung;
		this.danhMuc = danhMuc;
		this.doKho = doKho;
		Collection <BaiLuyenTap> a = new ArrayList<>();
		this.baiLuyenTap = a;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public DanhMuc getDanhMuc() {
		return danhMuc;
	}

	public void setDanhMuc(DanhMuc danhMuc) {
		this.danhMuc = danhMuc;
	}

	public DoKho getDoKho() {
		return doKho;
	}

	public void setDoKho(DoKho doKho) {
		this.doKho = doKho;
	}

	public Collection<BaiLuyenTap> getBaiLuyenTap() {
		return baiLuyenTap;
	}

	public void setBaiLuyenTap(Collection<BaiLuyenTap> baiLuyenTap) {
		this.baiLuyenTap = baiLuyenTap;
	}
	public void xuat(){
		System.out.println(this.noiDung);
	}
	public PhuongAn lamBai(){
		return null;
	}
	public List<PhuongAn> lamBaiKhacMul(){
		return null;
	}
}
