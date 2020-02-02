package jwel.prime.com.mjwel.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import jwel.prime.com.mjwel.Adapters.NewsAndUpdatesPagerAdapter;
import jwel.prime.com.mjwel.R;
import jwel.prime.com.mjwel.constant.ToolBarManagerHome;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsAndUpdatesFragment extends BaseHomeFragment {


    public NewsAndUpdatesFragment() {
        // Required empty public constructor
    }
    private View contentView;
    private TabLayout newsUpdatesTabs;
    private ViewPager newUpdatesPager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.fragment_news_and_updates, container, false);
        newsUpdatesTabs = contentView.findViewById(R.id.new_and_update_tab);
        newUpdatesPager = contentView.findViewById(R.id.news_viewPager);
        newUpdatesPager.setAdapter(new NewsAndUpdatesPagerAdapter(mActivity.getSupportFragmentManager()));
        newsUpdatesTabs.setupWithViewPager(newUpdatesPager);
        return contentView;
    }
     @Override
    public void onStart() {
        super.onStart();
        mActivity.enableDrawer(true);
        mActivity.hideBackButton();
        ToolBarManagerHome.getInstance().setHeaderTitle("");
    }

}
