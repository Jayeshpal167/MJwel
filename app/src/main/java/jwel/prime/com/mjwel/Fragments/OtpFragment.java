package jwel.prime.com.mjwel.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import jwel.prime.com.mjwel.Activity.HomeActivity;
import jwel.prime.com.mjwel.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OtpFragment extends BaseAuthenticationFragment {
    EditText otpField1, otpField2, otpField3, otpField4;
    Button authVerifyOTP;
    ImageView appLogo;
    TextView screenTitle, screenTagline;
    public OtpFragment() {
        // Required empty public constructor
    }
    private View contentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.fragment_otp, container, false);
        otpField1 = contentView.findViewById(R.id.otp_field1);
        otpField1.addTextChangedListener(new GenericOTPAdapter(otpField1));
        otpField2 = contentView.findViewById(R.id.otp_field2);
        otpField2.addTextChangedListener(new GenericOTPAdapter(otpField2));
        otpField3 = contentView.findViewById(R.id.otp_field3);
        otpField3.addTextChangedListener(new GenericOTPAdapter(otpField3));
        otpField4 = contentView.findViewById(R.id.otp_field4);
        otpField4.addTextChangedListener(new GenericOTPAdapter(otpField4));
        appLogo = contentView.findViewById(R.id.auth_otp_app_logo);
        screenTitle = contentView.findViewById(R.id.textView2);
        screenTagline = contentView.findViewById(R.id.auth_otp_tagline);
        authVerifyOTP = contentView.findViewById(R.id.auth_verify_otp);
        authVerifyOTP.setOnClickListener(this);
        return contentView;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.auth_verify_otp :
                Intent gotoMain = new Intent(mActivity, HomeActivity.class);
                startActivity(gotoMain);
                mActivity.finish();
                break;
                default: break;
        }
    }

    public class GenericOTPAdapter implements TextWatcher {
        private View view;
        public GenericOTPAdapter(View view) {
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            String otpText = s.toString();
            switch (view.getId()){
                case R.id.otp_field1:
                    if(otpText.length() == 1){
                        otpField2.requestFocus();
                    }
                    break;
                case R.id.otp_field2:
                    if(otpText.length() == 1){
                        otpField3.requestFocus();
                    }
                    else if(otpText.length() == 0)
                        otpField1.requestFocus();
                    break;
                case R.id.otp_field3:
                    if(otpText.length() == 1){
                        otpField4.requestFocus();
                    }
                    else if(otpText.length() == 0)
                        otpField2.requestFocus();
                    break;
                case R.id.otp_field4:
                    if(otpText.length() == 0){
                        otpField3.requestFocus();
                    }
                    break;
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
