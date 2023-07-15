import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.util.Scanner;

public class KTGK {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        SimpleDateFormat f =new SimpleDateFormat("dd/MM/yyyy");
        Scanner s = new Scanner(System.in);
        // Khai bao quan ly, doc du lieu
        QLCH qlch = new QLCH();
        QLTK qltk=new QLTK();
        qlch.getDataMul();
        qlch.getDataInc();
        qlch.getDataConv();
        qlch.getDataConv();
        qltk.getDataNguoiDung();
        ThongTinTaiKhoan ql = new QuanLy("admin","admin","#","nam",f.parse("17/11/1999"),"admin","admin");
        qltk.addThongTinTaiKhoan(ql);
        //Khai bao user dang nhap hien hanh
        ThongTinTaiKhoan userLoging;
        //Menu
        int chose = -1;
        do{
            Menu.view();
            System.out.print("Nhap lua chon:");
            chose = Integer.parseInt(s.nextLine());
            if(chose==1){
                userLoging = qltk.login();
                if(userLoging instanceof NguoiDung){
                    //Giaodienuser
                    NguoiDung.giaoDienNguoiDung(qlch,qltk,(NguoiDung) userLoging);
                }else if(userLoging instanceof QuanLy){
                    //Giaodienadmin
                    QuanLy.giaoDienAdmin(qltk,qlch);
                }
            }else if(chose == 2){
                System.out.print("Nhap tai khoan dang ky: ");
                String taiKhoan=s.nextLine();
                System.out.print("Nhap mat khau dang ky: ");
                String matKhau=s.nextLine();
                System.out.print("Nhap ho: ");
                String ho= s.nextLine();
                System.out.print("Nhap ten: ");
                String ten= s.nextLine();
                System.out.print("Nhap gioi tinh: ");
                String gt= s.nextLine();
                System.out.print("Nhap ngay sinh: ");
                String ngaySinh= s.nextLine();
                System.out.print("Nhap que quan: ");
                String queQuan= s.nextLine();
                NguoiDung newUser = new NguoiDung(ho,ten,queQuan,gt,f.parse(ngaySinh),taiKhoan,matKhau);
                newUser.setNgayGiaNhap(new Date());
                qltk.addThongTinTaiKhoan(newUser);
            }
        }while(chose!=0);
    }
}