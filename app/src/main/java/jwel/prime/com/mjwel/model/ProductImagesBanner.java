package jwel.prime.com.mjwel.model;

public class ProductImagesBanner {
    private int productId;
    private String productImageLink;

    public ProductImagesBanner(int productId, String productImageLink) {
        this.productId = productId;
        this.productImageLink = productImageLink;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductImageLink() {
        return productImageLink;
    }

    public void setProductImageLink(String productImageLink) {
        this.productImageLink = productImageLink;
    }
}
