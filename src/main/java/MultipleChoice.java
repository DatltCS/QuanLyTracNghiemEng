import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.Scanner;

public class MultipleChoice extends CauHoi {

	private Collection<PhuongAn> phuongAn;

	private PhuongAn dapAn;

	private Collection<NguoiDung> nguoiDungDaLam;


	public MultipleChoice(String noiDung, DanhMuc danhMuc, DoKho doKho, Collection<PhuongAn> phuongAn, PhuongAn dapAn) {
		super(noiDung, danhMuc, doKho);
		this.phuongAn = phuongAn;
		this.dapAn = dapAn;
		Collection <NguoiDung> a = new ArrayList<NguoiDung>();
		this.nguoiDungDaLam = a;
	}

	public MultipleChoice(String noiDung, DanhMuc danhMuc, DoKho doKho) {
		super(noiDung, danhMuc, doKho);
		Collection<PhuongAn> a= new ArrayList<PhuongAn>();
		this.phuongAn=a;
		Collection<NguoiDung> b = new ArrayList<NguoiDung>();
		this.nguoiDungDaLam=b;
	}

	public Collection<PhuongAn> getPhuongAn() {
		return phuongAn;
	}

	public void setPhuongAn(Collection<PhuongAn> phuongAn) {
		this.phuongAn = phuongAn;
	}

	public PhuongAn getDapAn() {
		return dapAn;
	}

	public void setDapAn(PhuongAn dapAn) {
		this.dapAn = dapAn;
	}

	public Collection<NguoiDung> getNguoiDungChuaLam() {
		return nguoiDungDaLam;
	}

	public void setNguoiDungChuaLam(Collection<NguoiDung> nguoiDungChuaLam) {
		this.nguoiDungDaLam = nguoiDungChuaLam;
	}
	@Override
	public void xuat(){
		super.xuat();
		for(PhuongAn x: this.phuongAn){
			x.xuat();
		}
	}
	@Override
	public PhuongAn lamBai(){
		Scanner s = new Scanner(System.in);
		PhuongAn[] pa = new PhuongAn[this.phuongAn.size()];
		int i=0;
		for(PhuongAn x: this.phuongAn){
			pa[i]= x;
			i++;
		}
		for(int t=0;t<4;t++){
			int rand1 = ((int) (Math.random()*100))%this.phuongAn.size();
			int rand2 = ((int) (Math.random()*100))%this.phuongAn.size();
			PhuongAn tam = pa[rand1];
			pa[rand1] = pa[rand2];
			pa[rand2]=tam;
		}
		int kt=65;
		super.xuat();
		for(int j=0;j<this.phuongAn.size();j++){
			System.out.print(((char) (kt++))+". ");
			pa[j].xuat();
		}
		System.out.print("Chon dap an: ");
		int chose = (int)(s.nextLine().toUpperCase().charAt(0))-65;
		return pa[chose];
	}
}
