package jwel.prime.com.mjwel.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import jwel.prime.com.mjwel.activities.Authentication;

public class BaseAuthenticationFragment extends Fragment implements View.OnClickListener{
    protected Authentication mActivity;
    protected ProgressDialog mProgressDialog;
    protected void showProgress() {
        mProgressDialog = new ProgressDialog(getContext());
        mProgressDialog.setTitle("Wait while we are processing!!!");
        mProgressDialog.setMessage("Please Wait!!!");
        mProgressDialog.setCancelable(false);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.show();
    }
    protected void stopProgress() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }
    @Override
    public void onAttach(@NonNull Context activity) {
        super.onAttach(activity);
        mActivity = (Authentication) activity;
    }

    protected void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {

    }
    public void onBackPressed(BaseAuthenticationFragment fragment) {
        if (fragment != null && fragment.getActivity() != null) {
            fragment.getActivity().onBackPressed();
        }
    }
    protected void onBackPressedToExit(BaseAuthenticationFragment fragment) {
        if (fragment != null) {
            mActivity.finish();
        }
    }

    public void onBackPressed() {
        /*
         * Empty
         * */
    }
}
