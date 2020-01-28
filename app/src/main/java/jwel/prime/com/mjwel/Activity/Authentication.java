package jwel.prime.com.mjwel.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;

import java.util.List;

import jwel.prime.com.mjwel.Fragments.BaseAuthenticationFragment;
import jwel.prime.com.mjwel.Fragments.FragmentLauncher;
import jwel.prime.com.mjwel.Fragments.LoginFragment;
import jwel.prime.com.mjwel.R;

public class Authentication extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        FragmentLauncher.launchFragment(this,R.id.authFrame, new LoginFragment(), false, true);
    }
    @Override
    public void onClick(View v) {
        BaseAuthenticationFragment fragment = getCurrentFragment();
        if(null != fragment){
            fragment.onClick(v);
        }
    }
    public BaseAuthenticationFragment getCurrentFragment() {
        FragmentManager mgr = getSupportFragmentManager();
        List<Fragment> list = mgr.getFragments();
        int count = mgr.getBackStackEntryCount();
        if (0 == count) {
            if (!list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) != null && list.get(i) instanceof BaseAuthenticationFragment) {
                        return (BaseAuthenticationFragment) list.get(i);
                    }
                }
            }
            return null;
        }
        FragmentManager.BackStackEntry entry = mgr.getBackStackEntryAt(count - 1);
        return (BaseAuthenticationFragment) mgr.findFragmentByTag(entry.getName());
    }
    public void onBackPressed() {
        if (getCurrentFragment() != null) {
            getCurrentFragment().onBackPressed();
        } else {
            super.onBackPressed();
        }
    }
}
