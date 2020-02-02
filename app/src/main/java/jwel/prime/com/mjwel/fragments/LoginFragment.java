package jwel.prime.com.mjwel.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import jwel.prime.com.mjwel.activities.HomeActivity;
import jwel.prime.com.mjwel.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends BaseAuthenticationFragment {


    public LoginFragment() {
        // Required empty public constructor
    }

    private View contentView;
    private EditText mobileNumber, password;
    private Button authLogin, authRegister;
    private TextView sendOtp;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.fragment_login, container, false);
        authLogin = contentView.findViewById(R.id.auth_login);
        mobileNumber = contentView.findViewById(R.id.auth_login_mobile_number);
        sendOtp = contentView.findViewById(R.id.auth_login_send_otp);
        sendOtp.setVisibility(View.GONE);
        authLogin.setVisibility(View.GONE);
        sendOtp.setOnClickListener(this);
        mobileNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() == 10){
                    sendOtp.setVisibility(View.VISIBLE);
                    authLogin.setVisibility(View.VISIBLE);
                    mobileNumber.setCompoundDrawablesWithIntrinsicBounds(null,null, ContextCompat.getDrawable(mActivity,R.drawable.tick),null);
                }
                else{
                    mobileNumber.setCompoundDrawablesWithIntrinsicBounds(null,null, null,null);
                    sendOtp.setVisibility(View.GONE);
                    authLogin.setVisibility(View.GONE);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        password = contentView.findViewById(R.id.auth_login_password);
        authRegister =  contentView.findViewById(R.id.auth_login_new_register);
        authLogin.setOnClickListener(this);
        authRegister.setOnClickListener(this);
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
            case R.id.auth_login :
                Intent gotoMain = new Intent(mActivity, HomeActivity.class);
                startActivity(gotoMain);
                mActivity.finish();
                break;
            case R.id.auth_login_new_register:
                FragmentLauncher.launchFragment(mActivity, R.id.authFrame, new RegistrationFragment(), false, true);
                break;
            case R.id.auth_login_send_otp:
                FragmentLauncher.launchFragment(mActivity, R.id.authFrame, new OtpFragment(), true, false);
                break;
            default:
                break;
        }
    }
}
