import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Incomplete extends CauHoi {

	private Collection<CauHoiNho> cauHoiNho;

	public Incomplete(String noiDung, DanhMuc danhMuc, DoKho doKho) {
		super(noiDung, danhMuc, doKho);
	}

	public Incomplete(String noiDung, DanhMuc danhMuc, DoKho doKho, Collection<CauHoiNho> cauHoiNho) {
		super(noiDung, danhMuc, doKho);
		this.cauHoiNho = cauHoiNho;
	}

	public Collection<CauHoiNho> getCauHoiNho() {
		return cauHoiNho;
	}

	public void setCauHoiNho(Collection<CauHoiNho> cauHoiNho) {
		this.cauHoiNho = cauHoiNho;
	}
	public void xuat(){
		super.xuat();
		for(CauHoiNho x : this.cauHoiNho){
			x.xuat();
		}
	}
	@Override
	public List<PhuongAn> lamBaiKhacMul(){
		List<PhuongAn> chose = new ArrayList<>();
		super.xuat();
		for(CauHoiNho x:this.cauHoiNho){
			chose.add(x.lamBai());
		}
		return chose;
	}
}
