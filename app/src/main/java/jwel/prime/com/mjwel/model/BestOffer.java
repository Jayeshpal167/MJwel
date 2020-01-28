package jwel.prime.com.mjwel.model;

public class BestOffer {
    private int bestOfferId = 0;
    private String bestOfferImage = "";
    private String bestOfferDiscount = "";
    private String bestOfferTitle = "";
    private String bestOfferValidity = "";
    private String bestOfferTagline = "";

    public BestOffer(int bestOfferId, String bestOfferImage, String bestOfferDiscount, String bestOfferTitle, String bestOfferValidity, String bestOfferTagline) {
        this.bestOfferId = bestOfferId;
        this.bestOfferImage = bestOfferImage;
        this.bestOfferDiscount = bestOfferDiscount;
        this.bestOfferTitle = bestOfferTitle;
        this.bestOfferValidity = bestOfferValidity;
        this.bestOfferTagline = bestOfferTagline;
    }

    public int getBestOfferId() {
        return bestOfferId;
    }

    public void setBestOfferId(int bestOfferId) {
        this.bestOfferId = bestOfferId;
    }

    public String getBestOfferImage() {
        return bestOfferImage;
    }

    public void setBestOfferImage(String bestOfferImage) {
        this.bestOfferImage = bestOfferImage;
    }

    public String getBestOfferDiscount() {
        return bestOfferDiscount;
    }

    public void setBestOfferDiscount(String bestOfferDiscount) {
        this.bestOfferDiscount = bestOfferDiscount;
    }

    public String getBestOfferTitle() {
        return bestOfferTitle;
    }

    public void setBestOfferTitle(String bestOfferTitle) {
        this.bestOfferTitle = bestOfferTitle;
    }

    public String getBestOfferValidity() {
        return bestOfferValidity;
    }

    public void setBestOfferValidity(String bestOfferValidity) {
        this.bestOfferValidity = bestOfferValidity;
    }

    public String getBestOfferTagline() {
        return bestOfferTagline;
    }

    public void setBestOfferTagline(String bestOfferTagline) {
        this.bestOfferTagline = bestOfferTagline;
    }
}
