package e.dekod.masteringblockchain.Beans;

import android.media.Image;
import android.provider.MediaStore;

import java.util.List;

public class Topic {
    private int topicSerial;
    private String topicTitle;
    private String topicBody;
    private List<Image> imagesOfTopic;
    private MediaStore.Video videoOfTopic;
}
