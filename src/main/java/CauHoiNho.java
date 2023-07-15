import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class CauHoiNho {

	private String noiDung;

	private Collection<PhuongAn> phuongAn;

	private PhuongAn dapAn;

	public CauHoiNho(String noiDung, Collection<PhuongAn> phuongAn, PhuongAn dapAn) {
		this.noiDung = noiDung;
		this.phuongAn = phuongAn;
		this.dapAn = dapAn;
	}
	public CauHoiNho(String noiDung, Collection<String> phuongAn) {
		this.noiDung = noiDung;
		List <PhuongAn>pa = new ArrayList<>();
		for(String x: phuongAn){
			pa.add(new PhuongAn(x));
		}
		this.phuongAn=pa;
		this.dapAn = pa.get(0);
	}
	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
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

	public void addPhuongAn(PhuongAn phuongAn){
		this.phuongAn.add(phuongAn);
	}
	public void xuat(){
		System.out.println(this.noiDung);
		for(PhuongAn x: this.phuongAn){
			x.xuat();
		}
	}
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
		System.out.println(this.noiDung);
		for(int j=0;j<this.phuongAn.size();j++){
			System.out.print(((char) (kt++))+". ");
			pa[j].xuat();
		}
		System.out.print("Chon dap an: ");
		int chose = (char)(s.nextLine().toUpperCase().charAt(0))-65;
		return pa[chose];
	}
}
