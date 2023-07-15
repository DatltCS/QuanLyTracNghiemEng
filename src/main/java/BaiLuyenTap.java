import java.util.ArrayList;
import java.util.Date;
import java.util.Collection;
import java.util.List;

public class BaiLuyenTap {

	private double diem;

	private Date ngayLam;

	private Collection<CauHoi> cauHoi;

	private List<PhuongAn> phuongAnNguoiDungChon;

	public BaiLuyenTap() {
		this.diem=-1;
		this.ngayLam=new Date();
		this.cauHoi= new ArrayList<>();
		this.phuongAnNguoiDungChon = new ArrayList<>();
	}

	public Collection<PhuongAn> getPhuongAnNguoiDungChon() {
		return phuongAnNguoiDungChon;
	}

	public void setPhuongAnNguoiDungChon(List<PhuongAn> phuongAnNguoiDungChon) {
		this.phuongAnNguoiDungChon = phuongAnNguoiDungChon;
	}

	public double getDiem() {
		return diem;
	}

	public void setDiem(double diem) {
		this.diem = diem;
	}

	public Date getNgayLam() {
		return ngayLam;
	}

	public void setNgayLam(Date ngayLam) {
		this.ngayLam = ngayLam;
	}

	public Collection<CauHoi> getCauHoi() {
		return cauHoi;
	}

	public void setCauHoi(Collection<CauHoi> cauHoi) {
		this.cauHoi = cauHoi;
	}

	public void addCauHoi(CauHoi cauHoi) {
		this.cauHoi.add(cauHoi);
	}

	public CauHoi getCauHoiIndex(int index) {
		int i=0;
		for(CauHoi x:this.cauHoi){
			if(i==index){
				return x;
			}
			i++;
		}
		return null;
	}
	public void lamBaiMul(){
		if(this.cauHoi.size()==0){
			return;
		}
		int stt=1;
		for(CauHoi x:this.cauHoi){
			System.out.print("Question "+stt+++":  ");
			PhuongAn u = ((MultipleChoice)x).lamBai();
			this.phuongAnNguoiDungChon.add(u);
		}
		//Cham diem
		int scd=0;
		int i =0;
		for(CauHoi x:this.cauHoi){
			if(((MultipleChoice)x).getDapAn().getNoiDung().compareTo(this.phuongAnNguoiDungChon.get(i++).getNoiDung())==0){
				scd++;
			}
		}
		this.diem = (10.0/(this.cauHoi.size()))*scd;
		System.out.print("So diem ban dat duoc: ");
		System.out.println(this.diem);
		System.out.println("XEM LAI DAP AN: ");
		int j=0;
		int t=1;
		for(CauHoi x:this.cauHoi){
			System.out.println("Question "+t++);
			System.out.println("Phuong an ban chon: ");
			System.out.println(this.phuongAnNguoiDungChon.get(j++).getNoiDung());
			System.out.println("Dap an: ");
			System.out.println(((MultipleChoice)x).getDapAn().getNoiDung());
		}
	}
	public void lamBaiInc(){
		int stt=1;
		for(CauHoi x:this.cauHoi){
			System.out.print("Question "+stt+++":  ");
			this.phuongAnNguoiDungChon= (List<PhuongAn>) ((Incomplete)x).lamBaiKhacMul();
		}
		//Cham diem
		int scd=0,r=0;
		for(CauHoi i:this.cauHoi){
			for(CauHoiNho t:((Incomplete)i).getCauHoiNho()){
				if(t.getDapAn().getNoiDung().compareTo(this.phuongAnNguoiDungChon.get(r++).getNoiDung())==0){
					scd++;
				}
			}
			break;
		}
		this.diem = ((10.0/r)*scd);
		System.out.print("So diem ban dat duoc: ");
		System.out.println(this.diem);
		System.out.println("XEM LAI DAP AN: ");
		int tt=1;
		r=0;
		for(CauHoi i:this.cauHoi){
			for(CauHoiNho t:((Incomplete)i).getCauHoiNho()){
				System.out.println("Question "+tt++);
				System.out.println("Phuong an ban chon: ");
				System.out.println(this.phuongAnNguoiDungChon.get(r++).getNoiDung());
				System.out.println("Dap an: ");
				System.out.println(t.getDapAn().getNoiDung());
			}
			break;
		}
	}
	public void lamBaiCom(){
		int stt = 0;
		for(CauHoi x:this.cauHoi){
			System.out.print("Question "+stt+++":  ");
			this.phuongAnNguoiDungChon= (List<PhuongAn>) ((Conversation)x).lamBaiKhacMul();
		}
		//Cham diem
		int scd=0,r=0;
		for(CauHoi i:this.cauHoi){
			for(CauHoiNho t:((Conversation)i).getCauHoiNho()){
				if(t.getDapAn().getNoiDung().compareTo(this.phuongAnNguoiDungChon.get(r++).getNoiDung())==0){
					scd++;
				}
			}
			break;
		}
		this.diem = (10.0/r)*scd;
		System.out.print("So diem ban dat duoc: ");
		System.out.println(this.diem);
		System.out.println("XEM LAI DAP AN: ");
		int tt=1;
		r=0;
		for(CauHoi i:this.cauHoi){
			for(CauHoiNho t:((Conversation)i).getCauHoiNho()){
				System.out.println("Question "+tt++);
				System.out.println("Phuong an ban chon: ");
				System.out.println(this.phuongAnNguoiDungChon.get(r++).getNoiDung());
				System.out.println("Dap an: ");
				System.out.println(t.getDapAn().getNoiDung());
			}
			break;
		}
	}
}
