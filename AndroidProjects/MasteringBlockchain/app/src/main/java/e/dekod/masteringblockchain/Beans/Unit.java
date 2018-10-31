package e.dekod.masteringblockchain.Beans;

import java.io.Serializable;
import java.util.List;

public class Unit implements Serializable {
    private int unitSerialId;
    private String unitIconURL;
    private String unitTitle;
    private List<Topic> topicsOfUnit;



    public Unit() {
    }


    public Unit(int unitSerialId, String unitIconURL, String unitTitle, List<Topic> topicsOfUnit) {
        this.unitSerialId = unitSerialId;
        this.unitIconURL = unitIconURL;
        this.unitTitle = unitTitle;
        this.topicsOfUnit = topicsOfUnit;
    }

    public int getUnitSerialId() {
        return unitSerialId;
    }

    public void setUnitSerialId(int unitSerialId) {
        this.unitSerialId = unitSerialId;
    }

    public String getUnitTitle() {
        return unitTitle;
    }

    public void setUnitTitle(String unitTitle) {
        this.unitTitle = unitTitle;
    }

    public String getUnitIconURL() {
        return unitIconURL;
    }

    public void setUnitIconURL(String unitIconURL) {
        this.unitIconURL = unitIconURL;
    }

    public List<Topic> getTopicsOfUnit() {
        return topicsOfUnit;
    }

    public void setTopicsOfUnit(List<Topic> topicsOfUnit) {
        this.topicsOfUnit = topicsOfUnit;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "unitSerialId=" + unitSerialId +
                ", unitIconURL='" + unitIconURL + '\'' +
                ", unitTitle='" + unitTitle + '\'' +
                ", topicsOfUnit=" + topicsOfUnit +
                '}';
    }
}
