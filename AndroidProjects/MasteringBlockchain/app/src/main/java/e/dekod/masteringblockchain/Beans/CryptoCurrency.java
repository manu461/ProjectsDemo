package e.dekod.masteringblockchain.Beans;

import java.io.Serializable;

public class CryptoCurrency implements Serializable {
    private String name;
    private String qualifiedName;
    private String icon;
    private String description;
    private String image;

    public CryptoCurrency() {
    }

    public CryptoCurrency(String name, String qualifiedName, String icon, String description, String image) {
        this.name = name;
        this.qualifiedName = qualifiedName;
        this.icon = icon;
        this.description = description;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQualifiedName() {
        return qualifiedName;
    }

    public void setQualifiedName(String qualifiedName) {
        this.qualifiedName = qualifiedName;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
