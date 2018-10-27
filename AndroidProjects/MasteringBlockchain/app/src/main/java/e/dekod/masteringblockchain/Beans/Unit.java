package e.dekod.masteringblockchain.Beans;

import java.io.Serializable;
import java.util.List;

public class Unit implements Serializable {
    private int unitSerialId;
    private String unitTitle;
    private List<Topic> topicsOfUnit;

    public Unit() {
    }

    public Unit(int unitSerialId, String unitTitle, List<Topic> topicsOfUnit) {
        this.unitSerialId = unitSerialId;
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
                ", unitTitle='" + unitTitle + '\'' +
                ", topicsOfUnit=" + topicsOfUnit +
                '}';
    }
}
