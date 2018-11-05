package e.dekod.masteringblockchain.Beans;

import java.io.Serializable;

public class CryptoCurrency implements Serializable {
    private String name;
    private String icon;
    private String description;

    public CryptoCurrency() {
    }

    public CryptoCurrency(String name, String icon, String description) {
        this.name = name;
        this.icon = icon;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CryptoCurrency{" +
                "name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
