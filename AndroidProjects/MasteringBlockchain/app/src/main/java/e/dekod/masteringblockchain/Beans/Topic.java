package e.dekod.masteringblockchain.Beans;

import android.media.Image;
import android.provider.MediaStore;

import java.io.Serializable;
import java.util.List;

public class Topic implements Serializable {
    private int topicSerialId;
    private String topicTitle;
    private String topicBody;
    private String image1OfTopicUri;
    private String image2OfTopicUri;
    private String image3OfTopicUri;
    private String videoOfTopicUri;

    public Topic() {
    }

    public Topic(int topicSerialId, String topicTitle, String topicBody, String image1OfTopicUri, String image2OfTopicUri, String image3OfTopicUri, String videoOfTopicUri) {
        this.topicSerialId = topicSerialId;
        this.topicTitle = topicTitle;
        this.topicBody = topicBody;
        this.image1OfTopicUri = image1OfTopicUri;
        this.image2OfTopicUri = image2OfTopicUri;
        this.image3OfTopicUri = image3OfTopicUri;
        this.videoOfTopicUri = videoOfTopicUri;
    }

    public int getTopicSerialId() {
        return topicSerialId;
    }

    public void setTopicSerialId(int topicSerialId) {
        this.topicSerialId = topicSerialId;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public String getTopicBody() {
        return topicBody;
    }

    public void setTopicBody(String topicBody) {
        this.topicBody = topicBody;
    }

    public String getImage1OfTopicUri() {
        return image1OfTopicUri;
    }

    public void setImage1OfTopicUri(String image1OfTopicUri) {
        this.image1OfTopicUri = image1OfTopicUri;
    }

    public String getImage2OfTopicUri() {
        return image2OfTopicUri;
    }

    public void setImage2OfTopicUri(String image2OfTopicUri) {
        this.image2OfTopicUri = image2OfTopicUri;
    }

    public String getImage3OfTopicUri() {
        return image3OfTopicUri;
    }

    public void setImage3OfTopicUri(String image3OfTopicUri) {
        this.image3OfTopicUri = image3OfTopicUri;
    }

    public String getVideoOfTopicUri() {
        return videoOfTopicUri;
    }

    public void setVideoOfTopicUri(String videoOfTopicUri) {
        this.videoOfTopicUri = videoOfTopicUri;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topicSerialId=" + topicSerialId +
                ", topicTitle='" + topicTitle + '\'' +
                ", topicBody='" + topicBody + '\'' +
                ", image1OfTopicUri='" + image1OfTopicUri + '\'' +
                ", image2OfTopicUri='" + image2OfTopicUri + '\'' +
                ", image3OfTopicUri='" + image3OfTopicUri + '\'' +
                ", videoOfTopicUri='" + videoOfTopicUri + '\'' +
                '}';
    }
}
