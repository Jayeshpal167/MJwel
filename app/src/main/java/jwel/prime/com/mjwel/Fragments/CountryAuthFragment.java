package jwel.prime.com.mjwel.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import jwel.prime.com.mjwel.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CountryAuthFragment extends BaseAuthenticationFragment {

    public CountryAuthFragment() {
        // Required empty public constructor
    }
    private TextView selectCountryTitle, selectCountryTagline;
    private ImageView appLogo, selectedCountryImage, selectStateTick;
    private Spinner selectCountry, selectState;
    private Button authSelectRegion;
    private View contentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.fragment_country_auth, container, false);
        selectCountryTitle = contentView.findViewById(R.id.auth_country_select_country_text);
        selectCountryTagline = contentView.findViewById(R.id.auth_country_select_country_tagline);
        appLogo = contentView.findViewById(R.id.auth_country_app_logo);
        authSelectRegion = contentView.findViewById(R.id.auth_select);
        authSelectRegion.setOnClickListener(this);
        return contentView;
    }
    private boolean doubleBackPress = false;
    @Override
    public void onBackPressed() {
        if(doubleBackPress){
            super.onBackPressedToExit(this);
            return;
        }
        Snackbar.make(contentView,"Press the back button again to Exit!!!", Snackbar.LENGTH_LONG).show();
        doubleBackPress = true;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackPress = false;
            }
        }, 1500);
    }
    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.auth_select:
                FragmentLauncher.launchFragment(mActivity, R.id.authFrame,new RegistrationFragment(), false, true);
                break;
                default:
                    break;
        }
    }
}
