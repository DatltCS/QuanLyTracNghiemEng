import java.util.Collection;

public class Conversation extends Incomplete {
    public Conversation(String noiDung, DanhMuc danhMuc, DoKho doKho) {
        super(noiDung, danhMuc, doKho);
    }

    public Conversation(String noiDung, DanhMuc danhMuc, DoKho doKho, Collection<CauHoiNho> ds) {
        super(noiDung, danhMuc, doKho, ds);
    }

}
