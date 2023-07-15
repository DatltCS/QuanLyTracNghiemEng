import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class QLTK {

	private Collection<ThongTinTaiKhoan> thongTinTaiKhoan;

	public QLTK() {
		this.thongTinTaiKhoan = new ArrayList<>();
	}

	public Collection<ThongTinTaiKhoan> getThongTinTaiKhoan() {
		return thongTinTaiKhoan;
	}

	public void setThongTinTaiKhoan(Collection<ThongTinTaiKhoan> thongTinTaiKhoan) {
		this.thongTinTaiKhoan = thongTinTaiKhoan;
	}
	public void addThongTinTaiKhoan(ThongTinTaiKhoan thongTin){
		this.thongTinTaiKhoan.add(thongTin);
	}
	public void getDataNguoiDung() throws FileNotFoundException, ParseException {
		File f=new File("src/main/resources/HocVien.txt");
		Scanner s = new Scanner(f);
		while(s.hasNextLine()){
			String ho = s.nextLine();
			String ten=s.nextLine();
			String queQuan=s.nextLine();
			String gioiTinh=s.nextLine();
			String ngaySinh=s.nextLine();
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Date d1= format.parse(ngaySinh);
			String giaNhap=s.nextLine();
			Date d2= format.parse(giaNhap);
			String tk=s.nextLine();
			String pass=s.nextLine();
			NguoiDung a = new NguoiDung(ho,ten,queQuan,gioiTinh,d1,tk,pass);
			a.setNgayGiaNhap(d2);
			this.addThongTinTaiKhoan(a);
		}
	}
	public boolean kiemTraTrungTK(String tenTK){
		for(ThongTinTaiKhoan x:this.thongTinTaiKhoan){
			if(x.getTaiKhoan().compareTo(tenTK)==0){
				return true;
			}
		}
		return false;
	}
	public void inputDataFromConsole() throws ParseException {
		Scanner s = new Scanner(System.in);
		String tk;
		do{
			System.out.print("Nhap ten tai khoan: ");
			tk = s.nextLine().trim();
			if(this.kiemTraTrungTK(tk)){
				System.out.println("Ten tai khoan da co nguoi su dung! Moi nhap lai!");
			}
		}while(this.kiemTraTrungTK(tk));
		System.out.print("Nhap ten mat khau: ");
		String mk = s.nextLine().trim();
		System.out.print("Nhap ho: ");
		String ho = s.nextLine().trim();
		System.out.print("Nhap ten: ");
		String ten = s.nextLine().trim();
		System.out.print("Nhap gioi tinh: ");
		String gioiTinh = s.nextLine().trim();
		System.out.print("Nhap que quan: ");
		String queQuan = s.nextLine().trim();
		System.out.println("Nhap ngay sinh(dd/MM/yyyy): ");
		String ngaySinh=s.nextLine().trim();
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		NguoiDung a = new NguoiDung(ho,ten,queQuan,gioiTinh,f.parse(ngaySinh),tk,mk);
		a.setNgayGiaNhap(new Date());
		this.addThongTinTaiKhoan(a);
	}
	public void xoaTaiKhoan(String tenTK){
		for(ThongTinTaiKhoan x: this.thongTinTaiKhoan){
			if(x.getTaiKhoan().compareTo(tenTK.trim())==0){
				this.thongTinTaiKhoan.remove(x);
				System.out.println("Xoa thanh cong!!!");
				return;
			}
		}
		System.out.println("Khong tim thay du lieu de tien hanh xoa!!!");
	}
	public void capNhatTaiKhoan(String tenTK) throws ParseException {
		ThongTinTaiKhoan capNhat=null;
		for(ThongTinTaiKhoan x: this.thongTinTaiKhoan){
			if(x.getTaiKhoan().compareTo(tenTK.trim())==0){
				capNhat=x;
				break;
			}
		}
		if(capNhat==null){
			System.out.println("Khong tim thay du lieu de tien cap nhat!!!");
		}
		else{
			Scanner s= new Scanner(System.in);
			Integer chose=-1;
			while(true){
				System.out.println("1. Cap nhat mat khau");
				System.out.println("2. Cap nhat ho");
				System.out.println("3. Cap nhat ten");
				System.out.println("4. Cap nhat que quan");
				System.out.println("5. Cap nhat ngay sinh");
				System.out.println("0. Thoat");
				System.out.print("Nhap lua chon: ");
				chose = Integer.parseInt(s.nextLine());
				switch (chose) {
					case 0: {
						return;
					}
					case 1:{
						System.out.print("Nhap mat khau can thay doi: ");
						capNhat.setMatKhau(s.nextLine());
						break;
					}
					case 2:{
						System.out.print("Nhap ho can thay doi: ");
						capNhat.setHo(s.nextLine());
						break;
					}
					case 3:{
						System.out.print("Nhap ten can thay doi: ");
						capNhat.setTen(s.nextLine());
						break;
					}
					case 4:{
						System.out.print("Nhap que quan can thay doi: ");
						capNhat.setQueQuan(s.nextLine());
						break;
					}
					case 5:{
						SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
						System.out.print("Nhap ngay sinh can thay doi: ");
						capNhat.setNgaySinh(f.parse(s.nextLine()));
						break;
					}

				}

			}
		}
	}
	public static void xuatDanhSachUser(Collection<ThongTinTaiKhoan> danhSachTaiKhoan){
		System.out.printf("%15s %10s %20s %20s %15s %20s\n","Ho","Ten","Que quan","Gioi tinh","Ngay sinh","Ten tai khoan");
		for(ThongTinTaiKhoan x:danhSachTaiKhoan){
			x.xuatThongTin();
		}
	}
	public void timTheoHoTen(String hoTen){
		Collection<ThongTinTaiKhoan> kq = new ArrayList<ThongTinTaiKhoan>();
		for(ThongTinTaiKhoan x:this.thongTinTaiKhoan){
			if((x.getHo()+" "+x.getTen()).toLowerCase().compareTo(hoTen.toLowerCase().trim())==0) {
				kq.add(x);
			}
		}
		if(kq.isEmpty()){
			System.out.println("Khong tim thay!!!");
		}
		this.xuatDanhSachUser(kq);
	}
	public void timTheoGioiTinh(String gioiTinh){
		Collection<ThongTinTaiKhoan> kq = new ArrayList<ThongTinTaiKhoan>();
		for(ThongTinTaiKhoan x:this.thongTinTaiKhoan){
			if((x.getGioiTinh()).toLowerCase().compareTo(gioiTinh.toLowerCase())==0) {
				kq.add(x);
			}
		}
		if(kq.isEmpty()){
			System.out.println("Khong tim thay!!!");
		}
		this.xuatDanhSachUser(kq);
	}
	public void timTheoQueQuan(String queQuan){
		Collection<ThongTinTaiKhoan> kq = new ArrayList<ThongTinTaiKhoan>();
		for(ThongTinTaiKhoan x:this.thongTinTaiKhoan){
			if((x.getQueQuan()).toLowerCase().compareTo(queQuan.toLowerCase())==0) {
				kq.add(x);
			}
		}
		if(kq.isEmpty()){
			System.out.println("Khong tim thay!!!");
		}
		this.xuatDanhSachUser(kq);
	}
	public void timTheoNgaySinh(String ngaySinh){
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		Collection<ThongTinTaiKhoan> kq = new ArrayList<ThongTinTaiKhoan>();
		for(ThongTinTaiKhoan x:this.thongTinTaiKhoan){
			if(ngaySinh.compareTo(f.format(x.getNgaySinh()))==0){
				kq.add(x);
			}
		}
		if(kq.isEmpty()){
			System.out.println("Khong tim thay!!!");
		}
		this.xuatDanhSachUser(kq);
	}
	public boolean kiemTraDangNhap(String tk,String mk){
		for(ThongTinTaiKhoan x: this.thongTinTaiKhoan){
			if(x.getTaiKhoan().compareTo(tk)==0&&x.getMatKhau().compareTo(mk)==0){
				return true;
			}
		}
		return false;
	}
	public ThongTinTaiKhoan login(){
		Scanner s= new Scanner(System.in);
		String tk=null;
		String mk=null;
		do {
			System.out.print("Nhap tai khoan: ");
			tk= s.nextLine();
			System.out.print("Nhap mat khau: ");
			mk= s.nextLine();
			if(!this.kiemTraDangNhap(tk, mk)){
				System.out.println("Tai khoan ban nhap khong dung! Moi nhap lai!");
			}
		}while(!this.kiemTraDangNhap(tk, mk));
		for(ThongTinTaiKhoan x: this.thongTinTaiKhoan){
			if(x.getTaiKhoan().compareTo(tk)==0&&x.getMatKhau().compareTo(mk)==0){
				return x;
			}
		}
		return null;
	}
}
