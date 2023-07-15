import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class QuanLy extends ThongTinTaiKhoan {

    public QuanLy(String ho, String ten, String queQuan, String gioiTinh, Date ngaySinh, String taiKhoan, String matKhau) throws ParseException {
        super(ho, ten, queQuan, gioiTinh, ngaySinh, taiKhoan, matKhau);
    }

    public static void giaoDienAdmin(QLTK qltk, QLCH qlch) throws ParseException {
        Scanner s = new Scanner(System.in);
        int chose = -1;
        do{
            Menu.viewAdmin();
            System.out.print("Nhap lua chon: ");
            chose = Integer.parseInt(s.nextLine());;
            switch(chose){
                case 0:{
                    break;
                }
                case 1:{
                    QuanLy.giaoDien1(qltk);
                    break;
                }
                case 2:{
                    QuanLy.giaoDien2(qlch);
                    break;
                }
                case 3:{
                    System.out.print("Nhap thang thong ke: ");
                    int thang = Integer.parseInt(s.nextLine());;
                    System.out.printf("%30s%20s%20s\n","Ho va Ten","So bai da lam","Diem TB");
                    for(ThongTinTaiKhoan x:qltk.getThongTinTaiKhoan()){
                        if(x instanceof NguoiDung){
                            ((NguoiDung) x).thongKe(thang);
                        }
                    }
                    break;
                }
            }
        }while(chose!=0);
    }
    public static void giaoDien1(QLTK qltk) throws ParseException {
        Scanner s = new Scanner(System.in);
        int chose = -1;
        do{
            Menu.view1();
            System.out.print("Nhap lua chon: ");
            chose = Integer.parseInt(s.nextLine());;
            switch(chose){
                case 0:{
                    break;
                }
                case 1:{
                    qltk.xuatDanhSachUser(qltk.getThongTinTaiKhoan());
                    break;
                }
                case 2:{
                    System.out.print("Nhap ho ten can tim: ");
                    String ten= s.nextLine();
                    qltk.timTheoHoTen(ten);
                    break;
                }
                case 3:{
                    System.out.print("Nhap gioi tinh can tim: ");
                    String gt= s.nextLine();
                    qltk.timTheoGioiTinh(gt);
                    break;
                }
                case 4:{
                    System.out.print("Nhap ngay sinh can tim: ");
                    String ngaySinh= s.nextLine();
                    qltk.timTheoNgaySinh(ngaySinh);
                    break;
                }
                case 5:{
                    System.out.print("Nhap que quan can tim: ");
                    String queQuan= s.nextLine();
                    qltk.timTheoQueQuan(queQuan);
                    break;
                }
                case 6:{
                    System.out.print("Nhap ten tai khoan can xoa: ");
                    String tenTK= s.nextLine();
                    qltk.xoaTaiKhoan(tenTK);
                    break;
                }
                case 7:{
                    System.out.print("Nhap ten tai khoan can cap nhat thong tin: ");
                    String tenTK= s.nextLine();
                    qltk.capNhatTaiKhoan(tenTK);
                }
            }
        }while(chose!=0);
    }
    public static void giaoDien2(QLCH qlch){
        Scanner s = new Scanner(System.in);
        int chose = -1;
        do{
            Menu.view2();
            System.out.print("Nhap lua chon: ");
            chose = Integer.parseInt(s.nextLine());;
            switch(chose){
                case 0:{
                    break;
                }
                case 1:{
                    qlch.xuatDSCauHoi();
                    break;
                }
                case 2:{
                    System.out.print("Nhap noi dung cau hoi can tim: ");
                    String noiDung= s.nextLine();
                    qlch.timTheoNoiDung(noiDung);
                    break;
                }
                case 3:{
                    System.out.print("Nhap danh muc cau hoi can tim: ");
                    String danhMuc= s.nextLine();
                    qlch.timTheoDanhMuc(danhMuc);
                    break;
                }
                case 4:{
                    System.out.print("Nhap muc do cau hoi can tim: ");
                    String mucDo= s.nextLine();
                    qlch.timTheoDoKho(mucDo);
                    break;
                }
            }
        }while(chose!=0);
    }
}
