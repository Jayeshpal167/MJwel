package jwel.prime.com.mjwel.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import jwel.prime.com.mjwel.Adapters.WishlistAdapter;
import jwel.prime.com.mjwel.R;
import jwel.prime.com.mjwel.model.Products;

/**
 * A simple {@link Fragment} subclass.
 */
public class WishlistFragment extends BaseHomeFragment {


    public WishlistFragment() {
        // Required empty public constructor
    }
    private TextView wishlistTitle;
    private RecyclerView wishlistRecycler;
    private View contentView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.fragment_wishlist, container, false);
        wishlistRecycler = contentView.findViewById(R.id.wishlist_recycler);
        wishlistTitle = contentView.findViewById(R.id.wishlist_title);
        wishlistRecycler.setLayoutManager(new GridLayoutManager(getActivity(),2));
        List<Products> list = new ArrayList<>();
        list.add(new Products(1,"Test","link","3.0","₹ 12000"));
        list.add(new Products(1,"Test","link","3.0","₹ 12000"));
        wishlistRecycler.setAdapter(new WishlistAdapter(mActivity, list));
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
}
