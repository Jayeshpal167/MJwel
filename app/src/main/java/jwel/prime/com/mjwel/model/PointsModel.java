package jwel.prime.com.mjwel.model;

public class PointsModel {
    private int pointId = 0;
    private  String pointString = "";

    public int getPointId() {
        return pointId;
    }

    public void setPointId(int pointId) {
        this.pointId = pointId;
    }

    public String getPointString() {
        return pointString;
    }

    public void setPointString(String pointString) {
        this.pointString = pointString;
    }

    public PointsModel(int pointId, String pointString) {
        this.pointId = pointId;
        this.pointString = pointString;
    }
}
