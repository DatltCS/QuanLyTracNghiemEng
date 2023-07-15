import java.util.ArrayList;
import java.util.Collection;

public class DoKho {

	private String ten;

	private Collection<CauHoi> cauHoi;

	public DoKho(String ten) {
		this.ten = ten;
		Collection <CauHoi> a = new ArrayList<CauHoi>();
		this.cauHoi = a;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public Collection<CauHoi> getCauHoi() {
		return cauHoi;
	}

	public void setCauHoi(Collection<CauHoi> cauHoi) {
		this.cauHoi = cauHoi;
	}

	public void addCauHoi(CauHoi a){
		this.cauHoi.add(a);
	}
}
