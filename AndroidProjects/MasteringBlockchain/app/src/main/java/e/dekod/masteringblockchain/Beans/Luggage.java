package e.dekod.masteringblockchain.Beans;

import java.io.Serializable;
import java.util.ArrayList;

public class Luggage implements Serializable {

    private ArrayList<Chapter> allChapterList;
    private ArrayList<CryptoCurrency> allCryptoList;
    private int topicCount;
    private User user;
    private ArrayList<String> homePageImages;


    public Luggage() {
    }

    public Luggage(ArrayList<Chapter> allChapterList, ArrayList<CryptoCurrency> allCryptoList, int topicCount, User user, ArrayList<String> homePageImages) {
        this.allChapterList = allChapterList;
        this.allCryptoList = allCryptoList;
        this.topicCount = topicCount;
        this.user = user;
        this.homePageImages = homePageImages;
    }

    public ArrayList<Chapter> getAllChapterList() {
        return allChapterList;
    }

    public void setAllChapterList(ArrayList<Chapter> allChapterList) {
        this.allChapterList = allChapterList;
    }

    public ArrayList<CryptoCurrency> getAllCryptoList() {
        return allCryptoList;
    }

    public void setAllCryptoList(ArrayList<CryptoCurrency> allCryptoList) {
        this.allCryptoList = allCryptoList;
    }

    public int getTopicCount() {
        return topicCount;
    }

    public void setTopicCount(int topicCount) {
        this.topicCount = topicCount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<String> getHomePageImages() {
        return homePageImages;
    }

    public void setHomePageImages(ArrayList<String> homePageImages) {
        this.homePageImages = homePageImages;
    }

    @Override
    public String toString() {
        return "Luggage{" +
                "allChapterList=" + allChapterList +
                ", allCryptoList=" + allCryptoList +
                ", topicCount=" + topicCount +
                ", user=" + user +
                ", homePageImages=" + homePageImages +
                '}';
    }
}
