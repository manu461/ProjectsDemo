package e.dekod.masteringblockchain.Beans;

import android.media.Image;

import java.sql.Blob;
import java.util.List;

public class Chapter {
    private int chapterSerial;
    private String chapterTitle;
    private String chapterDescription;
    private int chapterProgress;
    private Image chapterIcon;
    private boolean chapterIsComplete = false;
    private List<Unit> unitsOfChapter;




    public Chapter(int chapterSerial, String chapterTitle, String chapterDescription, int chapterProgress, Image chapterIcon, boolean chapterIsComplete, List<Unit> unitsOfChapter) {
        this.chapterSerial = chapterSerial;
        this.chapterTitle = chapterTitle;
        this.chapterDescription = chapterDescription;
        this.chapterProgress = chapterProgress;
        this.chapterIcon = chapterIcon;
        this.chapterIsComplete = chapterIsComplete;
        this.unitsOfChapter = unitsOfChapter;
    }

    public int getChapterSerial() {
        return chapterSerial;
    }

    public void setChapterSerial(int chapterSerial) {
        this.chapterSerial = chapterSerial;
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

    public int getChapterProgress() {
        return chapterProgress;
    }

    public void setChapterProgress(int chapterProgress) {
        this.chapterProgress = chapterProgress;
    }

    public Image getChapterIcon() {
        return chapterIcon;
    }

    public void setChapterIcon(Image chapterIcon) {
        this.chapterIcon = chapterIcon;
    }

    public boolean isChapterIsComplete() {
        return chapterIsComplete;
    }

    public void setChapterIsComplete(boolean chapterIsComplete) {
        this.chapterIsComplete = chapterIsComplete;
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
                "chapterSerial=" + chapterSerial +
                ", chapterTitle='" + chapterTitle + '\'' +
                ", chapterDescription='" + chapterDescription + '\'' +
                ", chapterProgress=" + chapterProgress +
                ", chapterIcon=" + chapterIcon +
                ", chapterIsComplete=" + chapterIsComplete +
                ", unitsOfChapter=" + unitsOfChapter +
                '}';
    }


}
