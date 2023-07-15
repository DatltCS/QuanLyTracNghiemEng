import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ThongTinTaiKhoan {

    private String ho;

	private String ten;

	private String queQuan;

	private String gioiTinh;

	private Date ngaySinh;

	private Date ngayGiaNhap;

	private String taiKhoan;

	private String matKhau;

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setNgayGiaNhap(Date ngayGiaNhap) {
        this.ngayGiaNhap = ngayGiaNhap;
    }

    public ThongTinTaiKhoan(String ho, String ten, String queQuan, String gioiTinh, Date ngaySinh, String taiKhoan, String matKhau) throws ParseException {
        this.ho = ho;
        this.ten = ten;
        this.queQuan = queQuan;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.ngayGiaNhap=null;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }


    public Date getNgayGiaNhap() {
        return ngayGiaNhap;
    }


    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    public void xuatThongTin(){
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        String day = f.format(this.ngaySinh);
        System.out.printf("%15s %10s %20s %20s %15s %20s\n",this.ho,this.ten,this.queQuan,this.gioiTinh,day,this.taiKhoan);
    }
}
