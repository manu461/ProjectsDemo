package e.dekod.masteringblockchain;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.HashMap;

import e.dekod.masteringblockchain.Beans.Topic;
import e.dekod.masteringblockchain.Beans.Unit;

public class TopicViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Topic> allTopicsList;
    private ArrayList<Boolean> allTopicStatusList;
    private HashMap<Integer, String> tagHashMap;
    private FragmentManager fragmentManager;

    public TopicViewPagerAdapter(FragmentManager fragmentManager, ArrayList<Topic> allTopicsList, ArrayList<Boolean> allTopicStatusList) {
        super(fragmentManager);
        this.fragmentManager = fragmentManager;
        this.allTopicsList = allTopicsList;
        this.allTopicStatusList = allTopicStatusList;
        tagHashMap = new HashMap<Integer, String>();
    }

    public TopicViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == allTopicsList.size()){
            return UnitCompleteFragment.getInstance();
        }else {
            return TopicFragment.getInstance(allTopicsList.get(position), allTopicStatusList.get(allTopicsList.get(position).getTopicSerialId()));
        }
    }

    @Override
    public int getCount() {
        return allTopicsList.size()+1;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Object object = super.instantiateItem(container, position);
        if(object instanceof Fragment){
            Fragment fragment = (Fragment) object;
            String tag = fragment.getTag();
            tagHashMap.put(position,tag);
        }
        return object;
    }

    public void updateData(int position){

        String tag = tagHashMap.get(position);
        if(tag!=null){
            TopicFragment fragment = (TopicFragment)fragmentManager.findFragmentByTag(tag);
            fragment.update();
        }
    }
}
