package jwel.prime.com.mjwel.model;

public class SaleOption {
    private int saleId = 0;
    private String saleName = "";

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public String getSaleName() {
        return saleName;
    }

    public void setSaleName(String saleName) {
        this.saleName = saleName;
    }

    public SaleOption(int saleId, String saleName) {
        this.saleId = saleId;
        this.saleName = saleName;
    }
}
