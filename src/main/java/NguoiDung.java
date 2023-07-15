import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class NguoiDung extends ThongTinTaiKhoan {

	private Collection<BaiLuyenTap> baiLuyenTap;

	private Collection<MultipleChoice> multipleChoiceDaLam;

	public NguoiDung(String ho, String ten, String queQuan, String gioiTinh, Date ngaySinh, String taiKhoan, String matKhau) throws ParseException {
		super(ho, ten, queQuan, gioiTinh, ngaySinh, taiKhoan, matKhau);
		Collection <BaiLuyenTap> a = new ArrayList<>();
		this.baiLuyenTap=a;
		Collection<MultipleChoice> b = new ArrayList<>();
		this.multipleChoiceDaLam = b;
	}

	public Collection<BaiLuyenTap> getBaiLuyenTap() {
		return baiLuyenTap;
	}

	public void setBaiLuyenTap(Collection<BaiLuyenTap> baiLuyenTap) {
		this.baiLuyenTap = baiLuyenTap;
	}

	public Collection<MultipleChoice> getMultipleChoiceDaLam() {
		return multipleChoiceDaLam;
	}

	public void setMultipleChoiceDaLam(Collection<MultipleChoice> multipleChoiceDaLam) {
		this.multipleChoiceDaLam = multipleChoiceDaLam;
	}

	public int soLanLuyenTap() {
		return this.baiLuyenTap.size();
	}

	public void thongKeDiemCaNhan(int thang) {
		SimpleDateFormat f= new SimpleDateFormat("dd/MM/yyyy");
		int soBai=0;
		double diemTB=0;
		System.out.printf("%5s%20s%20s%30s\n","STT","Ngay lam","So cau hoi","Diem dat duoc");
		for(BaiLuyenTap x:this.baiLuyenTap){
			if(x.getNgayLam().getMonth()+1==thang){
				System.out.printf("%5s%20s%20d%30f\n",soBai+1,f.format(x.getNgayLam()),x.getCauHoi().size(),x.getDiem());
				soBai++;
				diemTB+=x.getDiem();
			}
		}
		diemTB=(diemTB/soBai);
		System.out.println("Tong ket: So bai da lam trong thang: "+soBai+" - Diem TB theo thang: "+ diemTB);
	}
	public void thongKe(int thang){
		SimpleDateFormat f= new SimpleDateFormat("dd/MM/yyyy");
		int soBai=0;
		double diemTB=0;
		for(BaiLuyenTap x:this.baiLuyenTap){
			if(x.getNgayLam().getMonth()+1==thang){
				soBai++;
				diemTB+=x.getDiem();
			}
		}
		diemTB=(diemTB/soBai);
		System.out.printf("%30s%20d%20.2f\n",this.getHo()+" "+this.getTen(),soBai,diemTB);
	}
	public boolean kiemTraDaLam(CauHoi a){
		for(CauHoi x:this.multipleChoiceDaLam){
			if(x.getNoiDung().compareTo(a.getNoiDung())==0){
				return true;
			}
		}
		return false;
	}
	@Override
	public void xuatThongTin(){
		super.xuatThongTin();
	}

	@Override
	public void setNgayGiaNhap(Date ngayGiaNhap) {
		super.setNgayGiaNhap(ngayGiaNhap);
	}

	public void addBaiTapMultipleChoice(int soCauHoi,QLCH qlch){
		if(soCauHoi>(qlch.getSizeMul()-this.multipleChoiceDaLam.size())||soCauHoi<=0){
			System.out.println("So cau hoi ban nhap vuot so cau hoi con lai.");
			return;
		}
		int rand= ((int) (Math.random()*1000))%qlch.getSizeMul();
		BaiLuyenTap bt = new BaiLuyenTap();
		int i=1;
		while(i<=soCauHoi){
			CauHoi ch= qlch.getRandomOneMul(qlch.getSizeMul());
			if(!kiemTraDaLam(ch)){
				bt.addCauHoi(ch);
				this.multipleChoiceDaLam.add((MultipleChoice) ch);
				((MultipleChoice) ch).getNguoiDungChuaLam().add(this);
				i++;
			}
		}
		this.baiLuyenTap.add(bt);
	}
	public void addBaiTapInc(QLCH qlch,String doKho){
		BaiLuyenTap bt = new BaiLuyenTap();
		bt.addCauHoi(qlch.getRandomOneInc(doKho));
		this.baiLuyenTap.add(bt);
	}
	public void addBaiTapCom(QLCH qlch,String doKho){
		BaiLuyenTap bt = new BaiLuyenTap();
		bt.addCauHoi(qlch.getRandomOneCom(doKho));
		this.baiLuyenTap.add(bt);
	}
	public static void giaoDienNguoiDung(QLCH qlch,QLTK qltk,NguoiDung a) throws ParseException {
		Scanner s = new Scanner(System.in);
		int chose = -1;
		do{
			Menu.viewUser();
			System.out.print("Nhap lua chon: ");
			chose = Integer.parseInt(s.nextLine());;
			switch(chose){
				case 0:{
					break;
				}
				case 1:{
					NguoiDung.giaoDienNguoiDung1(qltk,a);
					break;
				}
				case 2:{
					NguoiDung.giaoDienLamBai(a,qlch);
					break;
				}
				case 3:{
					System.out.print("Nhap thang can thong ke: ");
					int thang = Integer.parseInt(s.nextLine());
					a.thongKeDiemCaNhan(thang);
					break;
				}
			}
		}while(chose!=0);
	}
	public static void giaoDienNguoiDung1(QLTK qltk,NguoiDung a) throws ParseException {
		SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy");
		Scanner s = new Scanner(System.in);
		int chose = -1;
		do{
			Menu.viewNguoiDung1();
			System.out.print("Nhap lua chon: ");
			chose = Integer.parseInt(s.nextLine());;
			switch(chose){
				case 0:{
					break;
				}
				case 1:{
					System.out.printf("%30s%30s\n","Ho:",a.getHo());
					System.out.printf("%30s%30s\n","Ten:",a.getTen());
					System.out.printf("%30s%30s\n","Gioi tinh:",a.getGioiTinh());
					System.out.printf("%30s%30s\n","Ngay sinh: ",f.format(a.getNgaySinh()));
					System.out.printf("%30s%30s\n","Que quan: ",a.getQueQuan());
					System.out.printf("%30s%30s\n","Tai khoan: ",a.getTaiKhoan());
					System.out.printf("%30s%30s\n","Ngay dang ky: ",f.format(a.getNgayGiaNhap()));
					break;
				}
				case 2:{
					qltk.capNhatTaiKhoan(a.getTaiKhoan());
					break;
				}
			}
		}while(chose!=0);
	}
	public static void giaoDienLamBai(NguoiDung a, QLCH qlch){
		Scanner s = new Scanner(System.in);
		int chose = -1;
		do{
			Menu.viewLuyenTap();
			System.out.print("Nhap lua chon: ");
			chose = Integer.parseInt(s.nextLine());
			switch(chose){
				case 0:{
					break;
				}
				case 1:{
					System.out.print("Nhap so cau muon lam: ");
					int soCau =Integer.parseInt(s.nextLine());
					a.addBaiTapMultipleChoice(soCau,qlch);
					for(BaiLuyenTap x:a.getBaiLuyenTap()){
						if(x.getDiem()<0){
							x.lamBaiMul();
						}
					}
					break;
				}
				case 2:{
					System.out.print("Nhap do kho muon lam: ");
					String doKho = s.nextLine();
					a.addBaiTapInc(qlch,doKho);
					for(BaiLuyenTap x:a.getBaiLuyenTap()){
						if(x.getDiem()<0){
							x.lamBaiInc();
						}
					}
					break;
				}
				case 3:{
					System.out.print("Nhap do kho muon lam: ");
					String doKho = s.nextLine();
					a.addBaiTapCom(qlch,doKho);
					for(BaiLuyenTap x:a.getBaiLuyenTap()){
						if(x.getDiem()<0){
							x.lamBaiCom();
						}
					}
					break;
				}
			}
		}while(chose!=0);
	}
}
