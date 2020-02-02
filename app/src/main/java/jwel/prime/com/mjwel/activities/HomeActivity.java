package jwel.prime.com.mjwel.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import jwel.prime.com.mjwel.R;
import jwel.prime.com.mjwel.constant.ToolBarManagerHome;
import jwel.prime.com.mjwel.fragments.AboutUsFragment;
import jwel.prime.com.mjwel.fragments.BaseHomeFragment;
import jwel.prime.com.mjwel.fragments.BestOfferFragment;
import jwel.prime.com.mjwel.fragments.CartFragment;
import jwel.prime.com.mjwel.fragments.FragmentLauncher;
import jwel.prime.com.mjwel.fragments.HomeFragment;
import jwel.prime.com.mjwel.fragments.NewsAndUpdatesFragment;
import jwel.prime.com.mjwel.fragments.ProfileFragment;
import jwel.prime.com.mjwel.fragments.TermsAndConditionsFragment;
import jwel.prime.com.mjwel.fragments.WishlistFragment;

import java.util.List;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, BottomNavigationView.OnNavigationItemSelectedListener {

    private ActionBarDrawerToggle toggle;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbarLayout);
        findViewById(R.id.backButtonToolbar).setVisibility(View.GONE);
        setSupportActionBar(toolbar);
        ToolBarManagerHome.getInstance().setupToolbar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.navigation_icon);
        }
        toggle.syncState();
        bottomNavigationView = findViewById(R.id.app_bottomLayout);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        navigationView.setNavigationItemSelectedListener(this);
        FragmentLauncher.launchFragment(this, R.id.homeFrame, new HomeFragment(), false, true);
    }

    public void enableDrawer(boolean isEnable) {
        toggle.setDrawerIndicatorEnabled(isEnable);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (isEnable) {
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
            findViewById(R.id.appIconImageView).setVisibility(View.VISIBLE);
        } else {
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            findViewById(R.id.appIconImageView).setVisibility(View.VISIBLE);
        }
    }

    public void showBackButton() {
        findViewById(R.id.backButtonToolbar).setVisibility(View.VISIBLE);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (getCurrentFragment() != null) {
                getCurrentFragment().onBackPressed();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override
    public void onClick(View v) {
        BaseHomeFragment fragment = getCurrentFragment();
        if (null != fragment) {
            fragment.onClick(v);
        }
    }

    public BaseHomeFragment getCurrentFragment() {
        FragmentManager mgr = getSupportFragmentManager();
        List<Fragment> list = mgr.getFragments();
        int count = mgr.getBackStackEntryCount();
        if (0 == count) {
            if (!list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) != null && list.get(i) instanceof BaseHomeFragment) {
                        return (BaseHomeFragment) list.get(i);
                    }
                }
            }
            return null;
        }
        FragmentManager.BackStackEntry entry = mgr.getBackStackEntryAt(count - 1);
        return (BaseHomeFragment) mgr.findFragmentByTag(entry.getName());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                FragmentLauncher.launchFragment(this, R.id.homeFrame, new HomeFragment(), false, true);
                break;
            case R.id.nav_best_offer:
                FragmentLauncher.launchFragment(this, R.id.homeFrame, new BestOfferFragment(), false, true);
                break;
            case R.id.nav_wishlist:
                FragmentLauncher.launchFragment(this, R.id.homeFrame, new WishlistFragment(), false, true);
                break;
            case R.id.nav_cart:
                FragmentLauncher.launchFragment(this, R.id.homeFrame, new CartFragment(), false, true);
                break;
            case R.id.nav_account_setting:
                FragmentLauncher.launchFragment(this, R.id.homeFrame, new ProfileFragment(), false, true);
                break;
            case R.id.nav_new_and_updates:
                FragmentLauncher.launchFragment(this, R.id.homeFrame, new NewsAndUpdatesFragment(), true, false);
                break;
            case R.id.nav_contact_us:
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+919458749970"));
                startActivity(intent);
                break;
            case R.id.nav_logout:
                Intent gotoAuthentication = new Intent(HomeActivity.this, Authentication.class);
                startActivity(gotoAuthentication);
                finish();
                break;
            case R.id.nav_about_us:
                FragmentLauncher.launchFragment(this, R.id.homeFrame, new AboutUsFragment(), true, false);
                break;
            case R.id.nav_tnc:
                FragmentLauncher.launchFragment(this, R.id.homeFrame, new TermsAndConditionsFragment(), true, false);
                break;
            default:
                break;
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void hideBackButton() {
        findViewById(R.id.backButtonToolbar).setVisibility(View.GONE);
    }
}
