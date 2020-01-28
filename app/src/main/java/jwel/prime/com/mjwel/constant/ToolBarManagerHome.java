package jwel.prime.com.mjwel.constant;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import jwel.prime.com.mjwel.Activity.HomeActivity;
import jwel.prime.com.mjwel.R;

public class ToolBarManagerHome {
    private static final ToolBarManagerHome ourInstance = new ToolBarManagerHome();
    private Toolbar mToolbar;

    public static ToolBarManagerHome getInstance() {
        return ourInstance;
    }

    private ToolBarManagerHome() {
    }

    public void setupToolbar(Toolbar mToolbar) {
        this.mToolbar = mToolbar;
    }

    public void changeToolBarColor(int color) {
        this.mToolbar.setBackgroundColor(color);
    }

    public void setHeaderTitle(String title) {
        TextView v = mToolbar.findViewById(R.id.AppTitle);
        v.setText(title);
    }

    public void onBackPressed(final Fragment fragment) {
        ImageView backImage = mToolbar.findViewById(R.id.backButtonToolbar);
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fragment.getActivity() != null) {
                    fragment.getActivity().onBackPressed();
                }
            }
        });
    }

    public void setHeaderTitleColor(int color) {
        TextView appTitle = mToolbar.findViewById(R.id.AppTitle);
        appTitle.setTextColor(color);
    }

    public Toolbar getToolBar() {
        return mToolbar;
    }

    public void hideToolBar(HomeActivity mActivity, boolean toHide) {
        if (toHide) {
            mActivity.findViewById(R.id.toolbarLayout).setVisibility(View.GONE);
        } else {
            mActivity.findViewById(R.id.toolbarLayout).setVisibility(View.VISIBLE);
        }
    }
}
