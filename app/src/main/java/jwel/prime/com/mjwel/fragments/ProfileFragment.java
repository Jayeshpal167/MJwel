package jwel.prime.com.mjwel.fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import jwel.prime.com.mjwel.R;
import jwel.prime.com.mjwel.constant.ToolBarManagerHome;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends BaseHomeFragment {


    public ProfileFragment() {
        // Required empty public constructor
    }
    private TextView profileName, profilePhoneNumber;
    private View contentView;
    private ImageView profileImage;
    private EditText profileEditName, profileEditBrandName, profileGstNo, profileCompanyTil,
            profileWebsiteUrl, profileAlternativContactNumber, profileSearchAddress,
            profileLandmark, profileSellerName, profileEditEmail, profileEditMobileNumber,
            profileEditDOB, profileState, profilePincode;
    private Spinner profileEditBusinessType;
    private CheckBox porfileExporter, profileAcceptTnc;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.fragment_profile, container, false);
        profileName = contentView.findViewById(R.id.profile_name);
        profilePhoneNumber = contentView.findViewById(R.id.profile_phone_number);
        profileImage = contentView.findViewById(R.id.profile_image);
        profileEditName = contentView.findViewById(R.id.profile_edit_name);
        profileEditBrandName = contentView.findViewById(R.id.profile_edit_brand_name);
        profileEditBusinessType = contentView.findViewById(R.id.profile_edit_business_type);
        profileGstNo = contentView.findViewById(R.id.profile_gst_no);
        profileCompanyTil = contentView.findViewById(R.id.profile_company_til);
        profileWebsiteUrl = contentView.findViewById(R.id.profile_website_url);
        profileAlternativContactNumber = contentView.findViewById(R.id.profile_alternative_contact_no);
        profileSearchAddress = contentView.findViewById(R.id.profile_search_address);
        profileLandmark = contentView.findViewById(R.id.profile_landmark);
        profileSellerName = contentView.findViewById(R.id.profile_seller_name);
        profileEditEmail = contentView.findViewById(R.id.profile_edit_email);
        profileEditMobileNumber = contentView.findViewById(R.id.profile_edit_mobile_number);
        profileEditDOB = contentView.findViewById(R.id.profile_edit_dob);
        profileState = contentView.findViewById(R.id.profile_state);
        profilePincode = contentView.findViewById(R.id.profile_pincode);
        porfileExporter = contentView.findViewById(R.id.profile_exporter);
        profileAcceptTnc = contentView.findViewById(R.id.profile_i_accept);
        //to set the current profile value at above header
        setProfileOfUser("Shubham Kumar", "9458XXXXXX");
        return  contentView;
    }

    @SuppressLint("SetTextI18n")
    private void setProfileOfUser(String userName, String userPhoneNumber) {
        profileName.setText(userName);
        profilePhoneNumber.setText("+91 "+userPhoneNumber);
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
    public void onStart() {
        super.onStart();
        mActivity.enableDrawer(true);
        mActivity.hideBackButton();
        ToolBarManagerHome.getInstance().setHeaderTitle("");
    }
}
