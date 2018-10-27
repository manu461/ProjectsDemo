package e.dekod.masteringblockchain.Beans;

import android.media.Image;

import java.io.Serializable;
import java.sql.Blob;
import java.util.List;

public class Chapter implements Serializable {
    private int chapterSerialId;
    private String chapterTitle;
    private String chapterDescription;
    private String chapterIconURI;
    private List<Unit> unitsOfChapter;

    public Chapter() {
    }

    public Chapter(int chapterSerialId, String chapterTitle, String chapterDescription, String chapterIconURI, List<Unit> unitsOfChapter) {
        this.chapterSerialId = chapterSerialId;
        this.chapterTitle = chapterTitle;
        this.chapterDescription = chapterDescription;
        this.chapterIconURI = chapterIconURI;
        this.unitsOfChapter = unitsOfChapter;
    }

    public int getChapterSerialId() {
        return chapterSerialId;
    }

    public void setChapterSerialId(int chapterSerialId) {
        this.chapterSerialId = chapterSerialId;
    }

    public String getChapterTitle() {
        return chapterTitle;
    }

    public void setChapterTitle(String chapterTitle) {
        this.chapterTitle = chapterTitle;
    }

    public String getChapterDescription() {
        return chapterDescription;
    }

    public void setChapterDescription(String chapterDescription) {
        this.chapterDescription = chapterDescription;
    }

    public String getChapterIconURI() {
        return chapterIconURI;
    }

    public void setChapterIconURI(String chapterIconURI) {
        this.chapterIconURI = chapterIconURI;
    }

    public List<Unit> getUnitsOfChapter() {
        return unitsOfChapter;
    }

    public void setUnitsOfChapter(List<Unit> unitsOfChapter) {
        this.unitsOfChapter = unitsOfChapter;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "chapterSerialId=" + chapterSerialId +
                ", chapterTitle='" + chapterTitle + '\'' +
                ", chapterDescription='" + chapterDescription + '\'' +
                ", chapterIconURI='" + chapterIconURI + '\'' +
                ", unitsOfChapter=" + unitsOfChapter +
                '}';
    }
}