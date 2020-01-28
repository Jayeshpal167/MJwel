package jwel.prime.com.mjwel.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import jwel.prime.com.mjwel.Activity.HomeActivity;
import jwel.prime.com.mjwel.Adapters.CategoryAdapter;
import jwel.prime.com.mjwel.Adapters.HomeProductsAdapter;
import jwel.prime.com.mjwel.Adapters.SaleOptionAdapter;
import jwel.prime.com.mjwel.R;
import jwel.prime.com.mjwel.constant.ToolBarManagerHome;
import jwel.prime.com.mjwel.model.Category;
import jwel.prime.com.mjwel.model.Products;
import jwel.prime.com.mjwel.model.SaleOption;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseHomeFragment {

    private RecyclerView categoryRecycler, saleRecycler, productRecycler;
    public HomeFragment() {
        // Required empty public constructor
    }

    private View contentView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.fragment_home, container, false);
        ToolBarManagerHome.getInstance().hideToolBar((HomeActivity) getActivity(), false);
        categoryRecycler = contentView.findViewById(R.id.category_recycler);
        saleRecycler = contentView.findViewById(R.id.sale_recycler);
        productRecycler = contentView.findViewById(R.id.products_recycler);
        //adding temporary data to category here maintain the same list here
        Category category1 = new Category(1,"All", "link of image here");
        Category category2 = new Category(2,"Gold", "link of image here");
        Category category3 = new Category(3,"Silver", "link of image here");
        Category category4 = new Category(4,"Handcraft", "link of image here");
        Category category5 = new Category(5,"Bronze", "link of image here");
        List<Category> category_list = new ArrayList<>();
        category_list.add(category1);
        category_list.add(category2);
        category_list.add(category3);
        category_list.add(category4);
        category_list.add(category5);
        //calling adapter
        saleRecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        List<SaleOption> saleList = new ArrayList<>();
        SaleOption saleOption1 = new SaleOption(1, "Best Seller");
        SaleOption saleOption2 = new SaleOption(2, "For You");
        SaleOption saleOption3 = new SaleOption(3, "Offers");
        SaleOption saleOption4 = new SaleOption(4, "New");
        saleList.add(saleOption1);
        saleList.add(saleOption2);
        saleList.add(saleOption3);
        saleList.add(saleOption4);
        saleRecycler.setAdapter(new SaleOptionAdapter(mActivity,saleList));
        categoryRecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        categoryRecycler.setAdapter(new CategoryAdapter(mActivity, category_list));
        //adding the temopray product
        Products products = new Products(1, "Red Stone Necklace","link", "3.0", "₹ 12000");
        List<Products> productsList = new ArrayList<>();
        productsList.add(products);
        productsList.add(products);
        productRecycler = contentView.findViewById(R.id.products_recycler);
        productRecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        productRecycler.setAdapter(new HomeProductsAdapter(mActivity,productsList));
        return contentView;
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
