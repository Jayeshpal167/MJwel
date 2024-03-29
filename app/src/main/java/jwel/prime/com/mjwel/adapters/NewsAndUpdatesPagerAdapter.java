package jwel.prime.com.mjwel.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import jwel.prime.com.mjwel.fragments.JewelleryUpdatesFragment;
import jwel.prime.com.mjwel.fragments.NewsFragment;

public class NewsAndUpdatesPagerAdapter extends FragmentStatePagerAdapter {
    public NewsAndUpdatesPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }
    String[] authArray = new String[]{"News", "Jewellery Updates"};
    Integer count = 2;
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return authArray[position];
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new NewsFragment();
            case 1:
                return new JewelleryUpdatesFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return count;
    }
}
