package hengzhi.entity;


public class DaoHang {

    private int id;

    private String daoHangTitle;

    private String daoHangUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDaoHangTitle() {
        return daoHangTitle;
    }

    public void setDaoHangTitle(String daoHangTitle) {
        this.daoHangTitle = daoHangTitle;
    }

    public String getDaoHangUrl() {
        return daoHangUrl;
    }

    public void setDaoHangUrl(String daoHangUrl) {
        this.daoHangUrl = daoHangUrl;
    }

    public DaoHang(int id, String daoHangTitle, String daoHangUrl) {
        this.id = id;
        this.daoHangTitle = daoHangTitle;
        this.daoHangUrl = daoHangUrl;
    }

    public DaoHang(String daoHangTitle, String daoHangUrl) {
        this.daoHangTitle = daoHangTitle;
        this.daoHangUrl = daoHangUrl;
    }
}
