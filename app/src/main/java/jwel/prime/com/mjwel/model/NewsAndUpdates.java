package jwel.prime.com.mjwel.model;

public class NewsAndUpdates {
    private int newsAndUpdatesId = 0;
    private String newsAndUpdatesImage = "";
    private String newsAndUpdatesSubHeading = "";
    private String newsAndUpdatesContent = "";

    public int getNewsAndUpdatesId() {
        return newsAndUpdatesId;
    }

    public void setNewsAndUpdatesId(int newsAndUpdatesId) {
        this.newsAndUpdatesId = newsAndUpdatesId;
    }

    public String getNewsAndUpdatesImage() {
        return newsAndUpdatesImage;
    }

    public void setNewsAndUpdatesImage(String newsAndUpdatesImage) {
        this.newsAndUpdatesImage = newsAndUpdatesImage;
    }

    public String getNewsAndUpdatesSubHeading() {
        return newsAndUpdatesSubHeading;
    }

    public void setNewsAndUpdatesSubHeading(String newsAndUpdatesSubHeading) {
        this.newsAndUpdatesSubHeading = newsAndUpdatesSubHeading;
    }

    public String getNewsAndUpdatesContent() {
        return newsAndUpdatesContent;
    }

    public void setNewsAndUpdatesContent(String newsAndUpdatesContent) {
        this.newsAndUpdatesContent = newsAndUpdatesContent;
    }

    public NewsAndUpdates(int newsAndUpdatesId, String newsAndUpdatesImage, String newsAndUpdatesSubHeading, String newsAndUpdatesContent) {
        this.newsAndUpdatesId = newsAndUpdatesId;
        this.newsAndUpdatesImage = newsAndUpdatesImage;
        this.newsAndUpdatesSubHeading = newsAndUpdatesSubHeading;
        this.newsAndUpdatesContent = newsAndUpdatesContent;
    }
}
