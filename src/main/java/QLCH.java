import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class QLCH {

	private Collection<CauHoi> danhSachCauHoi;
	private Collection<DanhMuc> danhSachDanhMuc;
	private Collection<DoKho> danhSachDoKho;

	public QLCH(){
		Collection<CauHoi> a = new ArrayList<CauHoi>();
		Collection<DanhMuc> b= new ArrayList<DanhMuc>();
		Collection<DoKho> c= new ArrayList<DoKho>();
		this.danhSachCauHoi=a;
		this.danhSachDanhMuc=b;
		this.danhSachDoKho=c;
	}
	public QLCH(Collection<CauHoi> danhSachCauHoi, Collection<DanhMuc> danhSachDanhMuc, Collection<DoKho> danhSachDoKho) {
		this.danhSachCauHoi = danhSachCauHoi;
		this.danhSachDanhMuc = danhSachDanhMuc;
		this.danhSachDoKho = danhSachDoKho;
	}

	public Collection<CauHoi> getDanhSachCauHoi() {
		return danhSachCauHoi;
	}

	public void setDanhSachCauHoi(Collection<CauHoi> danhSachCauHoi) {
		this.danhSachCauHoi = danhSachCauHoi;
	}

	public Collection<DanhMuc> getDanhSachDanhMuc() {
		return danhSachDanhMuc;
	}

	public void setDanhSachDanhMuc(Collection<DanhMuc> danhSachDanhMuc) {
		this.danhSachDanhMuc = danhSachDanhMuc;
	}

	public Collection<DoKho> getDanhSachDoKho() {
		return danhSachDoKho;
	}

	public void setDanhSachDoKho(Collection<DoKho> danhSachDoKho) {
		this.danhSachDoKho = danhSachDoKho;
	}

	public DanhMuc addDanhMuc(String danhMuc){
		if(!this.danhSachDanhMuc.isEmpty()){
			for(DanhMuc x: this.danhSachDanhMuc){
				if(x.getTen().compareTo(danhMuc)==0){
					return x;
				}
			}
		}
		DanhMuc a = new DanhMuc(danhMuc);
		this.danhSachDanhMuc.add(a);
		return a;
	}
	public DoKho addDoKho(String doKho){
		if(!this.danhSachDoKho.isEmpty()){
			for(DoKho x: this.danhSachDoKho){
				if(x.getTen().compareTo(doKho)==0){
					return x;
				}
			}
		}
		DoKho a = new DoKho(doKho);
		this.danhSachDoKho.add(a);
		return a;
	}
	public void addCauHoiMul(String noiDung, String danhMuc, String doKho){
		DanhMuc dm = addDanhMuc(danhMuc);
		DoKho dk = addDoKho(doKho);
		MultipleChoice a = new MultipleChoice(noiDung, dm, dk);
		this.danhSachCauHoi.add(a);
		dm.addCauHoi(a);
		dk.addCauHoi(a);
	}
	public void addCauHoiInc(String noiDung, String danhMuc, String doKho){
		DanhMuc dm = addDanhMuc(danhMuc);
		DoKho dk = addDoKho(doKho);
		Incomplete a = new Incomplete(noiDung, dm, dk);
		this.danhSachCauHoi.add(a);
		dm.addCauHoi(a);
		dk.addCauHoi(a);
	}
	public void addCauHoiConv(String noiDung, String danhMuc, String doKho){
		DanhMuc dm = addDanhMuc(danhMuc);
		DoKho dk = addDoKho(doKho);
		Conversation a = new Conversation(noiDung, dm, dk);
		this.danhSachCauHoi.add(a);
		dm.addCauHoi(a);
		dk.addCauHoi(a);
	}
	public void addCauHoiConv(String noiDung, String danhMuc, String doKho,Collection<CauHoiNho> dsCauHoi){
		DanhMuc dm = addDanhMuc(danhMuc);
		DoKho dk = addDoKho(doKho);
		Conversation a = new Conversation(noiDung, dm, dk);
		a.setCauHoiNho(dsCauHoi);
		this.danhSachCauHoi.add(a);
		dm.addCauHoi(a);
		dk.addCauHoi(a);
	}
	public void addCauHoiInc(String noiDung, String danhMuc, String doKho, Collection<CauHoiNho> dsCauHoi ){
		DanhMuc dm = addDanhMuc(danhMuc);
		DoKho dk = addDoKho(doKho);
		Incomplete a = new Incomplete(noiDung, dm, dk);
		a.setCauHoiNho(dsCauHoi);
		this.danhSachCauHoi.add(a);
		dm.addCauHoi(a);
		dk.addCauHoi(a);
	}
	public void addCauHoiMul(String noiDung, String danhMuc, String doKho, Collection<String> phuongAn){
		DanhMuc dm = addDanhMuc(danhMuc);
		DoKho dk = addDoKho(doKho);
		MultipleChoice a = new MultipleChoice(noiDung, dm, dk);
		List<PhuongAn> pa= new ArrayList<PhuongAn>();
		for(String x: phuongAn){
			pa.add(new PhuongAn(x));
		}
		a.setDapAn(pa.get(0));
		a.setPhuongAn(pa);
		this.danhSachCauHoi.add(a);
		dm.addCauHoi(a);
		dk.addCauHoi(a);
	}
	public void xuatDSDanhMuc(){
		System.out.printf("%30s\n","DANH SACH DANH MUC:");
		for(DanhMuc x:this.getDanhSachDanhMuc()){
			System.out.printf("%12s - So cau hoi: %d\n",x.getTen(),x.getCauHoi().size());
		}
	}
	public void xuatDSDoKho(){
		System.out.printf("%30s\n","DANH SACH DO KHO:");
		for(DoKho x:this.getDanhSachDoKho()){
			System.out.printf("%12s - So cau hoi: %d\n",x.getTen(),x.getCauHoi().size());
		}
	}
	public void xuatDSCauHoi(){
		int i=1;
		for(CauHoi x:this.getDanhSachCauHoi()){
			System.out.println("Question "+i+++":");
			x.xuat();
		}
	}
	public void getDataMul() throws FileNotFoundException {
		File f=new File("src/main/resources/MultipleChoice.txt");
		Scanner s = new Scanner(f);
		while(s.hasNextLine()){
			String danhMuc= s.nextLine();
			String doKho = s.nextLine();
			String noiDung=s.nextLine();
			String phuongAn=s.nextLine();
			addCauHoiMul(noiDung,danhMuc,doKho, Arrays.asList(phuongAn.split("#")));
		}
	}
	public void getDataInc() throws FileNotFoundException {
		File f=new File("src/main/resources/Incomplete.txt");
		Scanner s = new Scanner(f);
		while(s.hasNextLine()){
			String danhMuc= s.nextLine();
			String doKho = s.nextLine();
			String noiDung=s.nextLine();
			Collection dsCauHoi= new ArrayList<>();
			while(s.hasNextLine()){
				String a = s.nextLine();
				if(a.compareTo("---")==0){break;}
				String noiDungNho= a;
				String pa = s.nextLine();
				dsCauHoi.add(new CauHoiNho(noiDungNho,Arrays.asList(pa.split("#"))));
			}
			addCauHoiInc(noiDung,danhMuc,doKho,dsCauHoi);
		}
	}
	public void getDataConv() throws FileNotFoundException {
		File f=new File("src/main/resources/Conversation.txt");
		Scanner s = new Scanner(f);
		while(s.hasNextLine()){
			String danhMuc= s.nextLine();
			String doKho = s.nextLine();
			String noiDung=s.nextLine();
			Collection dsCauHoi= new ArrayList<>();
			while(s.hasNextLine()){
				String a = s.nextLine();
				if(a.compareTo("---")==0){break;}
				String noiDungNho= a;
				String pa = s.nextLine();
				dsCauHoi.add(new CauHoiNho(noiDungNho,Arrays.asList(pa.split("#"))));
			}
			addCauHoiConv(noiDung,danhMuc,doKho,dsCauHoi);
		}
	}
	public void timTheoDanhMuc(String tenDanhMuc){
		DanhMuc a = null;
		for(DanhMuc x:this.danhSachDanhMuc){
			if(tenDanhMuc.toLowerCase().trim().compareTo(x.getTen().toLowerCase())==0){
				a = x;
				break;
			}
		}
		if(a==null){
			System.out.println("Khong co danh muc hien hanh!");
			return;
		}
		int i=1;
		System.out.println("DANH MUC: "+ a.getTen());
		for(CauHoi x:a.getCauHoi()){
			System.out.println("Question "+i+++": ");
			x.xuat();
		}
	}
	public void timTheoDoKho(String tenDoKho){
		DoKho a = null;
		for(DoKho x:this.danhSachDoKho){
			if(tenDoKho.toLowerCase().trim().compareTo(x.getTen().toLowerCase())==0){
				a = x;
				break;
			}
		}
		if(a==null){
			System.out.println("Khong co do kho hien hanh!");
			return;
		}
		int i=1;
		System.out.println("DO KHO: "+ a.getTen());
		for(CauHoi x:a.getCauHoi()){
			System.out.println("Question "+i+++": ");
			x.xuat();
		}
	}
	public void timTheoNoiDung(String noiDung){
		List<CauHoi> KQ = new ArrayList<>();
		for(CauHoi x:this.danhSachCauHoi){
			if (x.getNoiDung().toLowerCase().contains(noiDung.toLowerCase().trim())) {
				KQ.add(x);
			}
		}
		if(KQ.isEmpty()){
			System.out.println("Khong noi dung can tim!");
			return;
		}
		int i=1;
		System.out.println("Dang tim kiem theo noi dung : "+ noiDung);
		for(CauHoi x:KQ){
			System.out.println("Question "+i+++": ");
			x.xuat();
		}
	}
	public List<CauHoi> getMultipleChoice(){
		List<CauHoi> kq = new ArrayList<>();
		for(CauHoi x:this.danhSachCauHoi){
			if(x instanceof MultipleChoice){
				kq.add(x);
			}
		}
		return kq;
	}
	public int getSizeMul(){
		return this.getMultipleChoice().size();
	}
	public int getSizeIncom(){
		return this.getIncomplete().size();
	}
	public int getSizeCom(){
		return this.getConversation().size();
	}
	public List<CauHoi> getConversation(){
		List<CauHoi> kq = new ArrayList<>();
		for(CauHoi x:this.danhSachCauHoi){
			if(x instanceof Conversation){
				kq.add(x);
			}
		}
		return kq;

	}
	public List<CauHoi> getIncomplete(){
		List<CauHoi> kq = new ArrayList<>();
		for(CauHoi x:this.danhSachCauHoi){
			if(x instanceof Incomplete){
				kq.add(x);
			}
		}
		return kq;
	}
	public CauHoi getRandomOneMul(int size){
		int rand= ((int) (Math.random()*1000))%size;
		int i = 0;
		for(CauHoi x:this.getMultipleChoice()){
			if(i==rand){
				return x;
			}
			i++;
		}
		return null;
	}
	public CauHoi getRandomOneInc(String doKho){
		DoKho dk=null;
		for(DoKho t: this.danhSachDoKho){
			if(t.getTen().toLowerCase().compareTo(doKho.toLowerCase())==0){
				dk=t;
			}
		}
		if(dk==null){
			System.out.println("Khong co do kho hien hanh!");
			return null;
		}
		List<CauHoi> inc = new ArrayList<>();
		for(CauHoi v:dk.getCauHoi()){
			if(v instanceof Incomplete){
				inc.add(v);
			}
		}
		int rand= ((int) (Math.random()*1000))%inc.size();
		int i = 0;
		for(CauHoi x:inc){
			if(i==rand){
				return x;
			}
			i++;
		}
		return null;
	}
	public CauHoi getRandomOneCom(String doKho){
		DoKho dk=null;
		for(DoKho t: this.danhSachDoKho){
			if(t.getTen().toLowerCase().compareTo(doKho.toLowerCase())==0){
				dk=t;
			}
		}
		if(dk==null){
			System.out.println("Khong co do kho hien hanh!");
			return null;
		}
		List<CauHoi> com = new ArrayList<>();
		for(CauHoi v:dk.getCauHoi()){
			if(v instanceof Conversation){
				com.add(v);
			}
		}
		int rand= ((int) (Math.random()*1000))%com.size();
		int i = 0;
		for(CauHoi x:com){
			if(i==rand){
				return x;
			}
			i++;
		}
		return null;
	}
}
