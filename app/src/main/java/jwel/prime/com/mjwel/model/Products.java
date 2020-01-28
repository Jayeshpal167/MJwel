package jwel.prime.com.mjwel.model;

public class Products {
    private int productId = 0;
    private String productName = "";
    //link of the product image
    private String productImage = "";
    private String productRating = "";

    public Products(int productId, String productName, String productImage, String productRating, String productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productImage = productImage;
        this.productRating = productRating;
        this.productPrice = productPrice;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    private String productPrice = "";

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductRating() {
        return productRating;
    }

    public void setProductRating(String productRating) {
        this.productRating = productRating;
    }

}
