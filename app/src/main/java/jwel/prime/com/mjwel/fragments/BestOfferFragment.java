package jwel.prime.com.mjwel.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import jwel.prime.com.mjwel.adapters.BestOfferAdapter;
import jwel.prime.com.mjwel.R;
import jwel.prime.com.mjwel.constant.ToolBarManagerHome;
import jwel.prime.com.mjwel.model.BestOffer;

/**
 * A simple {@link Fragment} subclass.
 */
public class BestOfferFragment extends BaseHomeFragment {


    public BestOfferFragment() {
        // Required empty public constructor
    }
    private View contentView;
    private LinearLayout bestOfferExchange;
    private TextView bestOfferTitle;
    private RecyclerView bestOfferRecycler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.fragment_best_offer, container, false);
        bestOfferExchange = contentView.findViewById(R.id.best_offer_exchange);
        bestOfferRecycler = contentView.findViewById(R.id.best_offer_recycler);
        bestOfferTitle = contentView.findViewById(R.id.best_offer_title);
        BestOffer bestOffer = new BestOffer(1, "link", "6% OFF", "On white gold necklace", "Valid Till 20 Jan", "Give a special gift to your loved ones on special price");
        List<BestOffer> list = new ArrayList<>();
        list.add(bestOffer);
        bestOfferRecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        bestOfferRecycler.setAdapter(new BestOfferAdapter(mActivity, list));
        bestOfferExchange.setOnClickListener(this);
        return contentView;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch(v.getId()){
            case R.id.best_offer_exchange :
                Snackbar.make(contentView,"Offer Coming Soon!!", Snackbar.LENGTH_LONG).show();
                break;
            default:
                    break;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        mActivity.enableDrawer(true);
        mActivity.hideBackButton();
        ToolBarManagerHome.getInstance().setHeaderTitle("");
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
}
