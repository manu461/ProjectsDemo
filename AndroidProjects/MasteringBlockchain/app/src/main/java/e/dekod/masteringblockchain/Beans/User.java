package e.dekod.masteringblockchain.Beans;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private String userId;
    private String userEmail;
    private String userName;
    private String userImage;
    private List<Boolean> topicsStatus;

    public User() {
    }

    public User(String userId, String userEmail, String userName, String userImage, List<Boolean> topicsStatus) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userName = userName;
        this.userImage = userImage;
        this.topicsStatus = topicsStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public List<Boolean> getTopicsStatus() {
        return topicsStatus;
    }

    public void setTopicsStatus(List<Boolean> topicsStatus) {
        this.topicsStatus = topicsStatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userName='" + userName + '\'' +
                ", userImage='" + userImage + '\'' +
                ", topicsStatus=" + topicsStatus +
                '}';
    }
}
