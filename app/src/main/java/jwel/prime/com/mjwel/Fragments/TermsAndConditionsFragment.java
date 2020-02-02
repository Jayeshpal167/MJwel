package jwel.prime.com.mjwel.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import jwel.prime.com.mjwel.Activity.HomeActivity;
import jwel.prime.com.mjwel.Adapters.PointsAdapter;
import jwel.prime.com.mjwel.R;
import jwel.prime.com.mjwel.constant.ToolBarManagerHome;
import jwel.prime.com.mjwel.model.PointsModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class TermsAndConditionsFragment extends BaseHomeFragment {


    public TermsAndConditionsFragment() {
        // Required empty public constructor
    }

    private View contentView;
    private RecyclerView tncRecycler;
    private TextView tncTitle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        contentView = inflater.inflate(R.layout.fragment_terms_and_conditions, container, false);
        tncRecycler = contentView.findViewById(R.id.tnc_recycler);
        tncTitle = contentView.findViewById(R.id.tnc_title);
        tncRecycler.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL, false));
        List<PointsModel> list = new ArrayList<>();
        list.add(new PointsModel(1, "MJWEL is India's Leading ZERO FEE online B2B, B2C, O2O jewellery market place, bringing together Manufacture, Whole seller, Retailers and supporting them to sell their product globally."));
        tncRecycler.setAdapter(new PointsAdapter(mActivity,list));
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
