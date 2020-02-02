package jwel.prime.com.mjwel.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
import jwel.prime.com.mjwel.R;
import jwel.prime.com.mjwel.activities.HomeActivity;
import jwel.prime.com.mjwel.adapters.CategoryAdapter;
import jwel.prime.com.mjwel.adapters.HomeProductsAdapter;
import jwel.prime.com.mjwel.adapters.SaleOptionAdapter;
import jwel.prime.com.mjwel.constant.ToolBarManagerHome;
import jwel.prime.com.mjwel.model.Category;
import jwel.prime.com.mjwel.model.Products;
import jwel.prime.com.mjwel.model.SaleOption;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseHomeFragment {

    private RecyclerView categoryRecycler;
    private RecyclerView saleRecycler;
    private RecyclerView productRecycler;

    public HomeFragment() {
        // Required empty public constructor
    }

    private View contentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.fragment_home, container, false);
        ToolBarManagerHome.getInstance().hideToolBar((HomeActivity) getActivity(), false);
        categoryRecycler = contentView.findViewById(R.id.category_recycler);
        saleRecycler = contentView.findViewById(R.id.sale_recycler);
        productRecycler = contentView.findViewById(R.id.products_recycler);
        //adding temporary data to category here maintain the same list here
        Category category1 = new Category(1, "All", "link of image here 1");
        Category category2 = new Category(2, "Gold", "link of image here 2");
        Category category3 = new Category(3, "Silver", "link of image here 3");
        Category category4 = new Category(4, "Handcraft", "link of image here 4");
        Category category5 = new Category(5, "Bronze", "link of image here 5");
        List<Category> categoryArrayList = new ArrayList<>();
        categoryArrayList.add(category1);
        categoryArrayList.add(category2);
        categoryArrayList.add(category3);
        categoryArrayList.add(category4);
        categoryArrayList.add(category5);
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
        saleRecycler.setAdapter(new SaleOptionAdapter(mActivity, saleList));
        categoryRecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        categoryRecycler.setAdapter(new CategoryAdapter(mActivity, categoryArrayList));
        //adding the temopray product
        Products products = new Products(1, "Red Stone Necklace", "link", "3.0", "₹ 12000");
        List<Products> productsList = new ArrayList<>();
        productsList.add(products);
        productsList.add(products);
        productRecycler = contentView.findViewById(R.id.products_recycler);
        productRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        productRecycler.setAdapter(new HomeProductsAdapter(mActivity, productsList));
        categoryRecycler.requestFocus();
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
        if (doubleBackPress) {
            super.onBackPressedToExit(this);
            return;
        }
        Snackbar.make(contentView, "Press the back button again to Exit!!!", Snackbar.LENGTH_LONG).show();
        doubleBackPress = true;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackPress = false;
            }
        }, 1500);
    }
}
