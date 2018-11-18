package e.dekod.masteringblockchain.Beans;

import java.io.Serializable;
import java.util.ArrayList;

public class Luggage implements Serializable {

    private ArrayList<Chapter> allChapterList;
    private ArrayList<CryptoCurrency> allCryptoList;
    private int topicCount;
    private User user;
    private ArrayList<String> homePageImages;
    private ArrayList<Quiz> allQuizList;
    private ArrayList<String> allAnswersList;


    public Luggage() {
    }

    public Luggage(ArrayList<Chapter> allChapterList, ArrayList<CryptoCurrency> allCryptoList, int topicCount, User user, ArrayList<String> homePageImages, ArrayList<Quiz> allQuizList, ArrayList<String> allAnswersList) {
        this.allChapterList = allChapterList;
        this.allCryptoList = allCryptoList;
        this.topicCount = topicCount;
        this.user = user;
        this.homePageImages = homePageImages;
        this.allQuizList = allQuizList;
        this.allAnswersList = allAnswersList;
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

    public ArrayList<Quiz> getAllQuizList() {
        return allQuizList;
    }

    public void setAllQuizList(ArrayList<Quiz> allQuizList) {
        this.allQuizList = allQuizList;
    }

    public ArrayList<String> getAllAnswersList() {
        return allAnswersList;
    }

    public void setAllAnswersList(ArrayList<String> allAnswersList) {
        this.allAnswersList = allAnswersList;
    }

    @Override
    public String toString() {
        return "Luggage{" +
                "allChapterList=" + allChapterList +
                ", allCryptoList=" + allCryptoList +
                ", topicCount=" + topicCount +
                ", user=" + user +
                ", homePageImages=" + homePageImages +
                ", allQuizList=" + allQuizList +
                ", allAnswersList=" + allAnswersList +
                '}';
    }
}
