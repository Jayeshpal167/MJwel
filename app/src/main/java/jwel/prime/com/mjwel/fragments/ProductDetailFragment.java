package jwel.prime.com.mjwel.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import jwel.prime.com.mjwel.activities.HomeActivity;
import jwel.prime.com.mjwel.adapters.ProductImageBannerAdapter;
import jwel.prime.com.mjwel.adapters.ProductTagAdapter;
import jwel.prime.com.mjwel.adapters.SaleOptionAdapter;
import jwel.prime.com.mjwel.R;
import jwel.prime.com.mjwel.constant.ToolBarManagerHome;
import jwel.prime.com.mjwel.model.ProductImagesBanner;
import jwel.prime.com.mjwel.model.ProductTag;
import jwel.prime.com.mjwel.model.SaleOption;
import me.relex.circleindicator.CircleIndicator;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductDetailFragment extends BaseHomeFragment {
    public ProductDetailFragment() {
        // Required empty public constructor
    }
    private int quantity = 1;
    private View contentView;
    private RecyclerView productMainDetailRecycler, productTagsRecycler;
    private ViewPager productPager;
    private CircleIndicator cauroselCircle;
    private TextView productName, productPrice, productRating, productQty, addToCart;
    ImageView add_to_wishlist, productPlus, productMinus;
    private int currentPage = 0;
    List<ProductImagesBanner> bannerList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.fragment_product_detail, container, false);
        ToolBarManagerHome.getInstance().hideToolBar((HomeActivity) getActivity(), false);
        ToolBarManagerHome.getInstance().onBackPressed(this);
        productName = contentView.findViewById(R.id.product_name);
        productPrice = contentView.findViewById(R.id.product_price);
        productRating = contentView.findViewById(R.id.product_rating);
        add_to_wishlist = contentView.findViewById(R.id.product_wishlist);
        add_to_wishlist.setOnClickListener(this);
        productPlus = contentView.findViewById(R.id.product_qty_plus);
        productMinus = contentView.findViewById(R.id.product_qty_minus);
        productQty = contentView.findViewById(R.id.product_qty);
        productPlus.setOnClickListener(this);
        productMinus.setOnClickListener(this);
        addToCart = contentView.findViewById(R.id.product_add_to_cart);
        addToCart.setOnClickListener(this);
        productMainDetailRecycler = contentView.findViewById(R.id.product_main_details);
        productMainDetailRecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        productMainDetailRecycler.setAdapter(new SaleOptionAdapter(mActivity, getProductDetailsHeading()));
        productTagsRecycler = contentView.findViewById(R.id.product_tags);
        //adding temporary tags
        productTagsRecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        productTagsRecycler.setAdapter(new ProductTagAdapter(mActivity, getProductTags()));
        //caurosel Images
        ProductImagesBanner p1 = new ProductImagesBanner(1, "as");
        ProductImagesBanner p2 = new ProductImagesBanner(1, "as");
        bannerList.add(p1);
        bannerList.add(p2);
        productPager = contentView.findViewById(R.id.product_pager);
        cauroselCircle = contentView.findViewById(R.id.caurosel_circle);
        cauroselCircle.setViewPager(productPager);
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            public void run() {
                try {
                    if (currentPage == bannerList.size()) {
                        currentPage = 0;
                    }
                } catch (Exception e) {
                    Log.e(ProductDetailFragment.class.getSimpleName(), e.toString());
                }
                productPager.setCurrentItem(currentPage++, true);
            }
        };
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        }, 4000, 4000);
        productPager.setAdapter(new ProductImageBannerAdapter(mActivity, bannerList));
        return contentView;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch(v.getId()){
            case R.id.product_wishlist :
                add_to_wishlist.setImageDrawable(getResources().getDrawable(R.drawable.heart_liked));
                break;
            case R.id.product_qty_plus :
                quantity ++;
                productQty.setText(String.valueOf(quantity));
                break;
            case R.id.product_qty_minus :
                if(quantity > 1)
                    quantity -- ;
                else {
                    Snackbar.make(contentView, "You have Reached minimum buy quantity!!!",Snackbar.LENGTH_LONG).show();
                }
                productQty.setText(String.valueOf(quantity));
                break;
            case R.id.product_add_to_cart :
                Snackbar.make(contentView,quantity+" Quantity are added to cart Successfully!!!", Snackbar.LENGTH_LONG).show();
                break;
                default:
                    break;
        }
    }
    @Override
    public void onStart() {
        super.onStart();
        mActivity.enableDrawer(false);
        ToolBarManagerHome.getInstance().setHeaderTitle("Product Name");
        mActivity.showBackButton();
    }
    private List<ProductTag> getProductTags() {
        ProductTag necklace = new ProductTag(1, "Necklace");
        ProductTag Jewellery = new ProductTag(1, "Jewellery");
        List<ProductTag> list = new ArrayList<>();
        list.add(necklace);
        list.add(Jewellery);
        return list;
    }

    private List<SaleOption> getProductDetailsHeading() {
        List<SaleOption> list = new ArrayList<>();
        SaleOption description = new SaleOption(1, "Description");
        SaleOption specification = new SaleOption(1, "Specification");
        SaleOption reviews = new SaleOption(1, "Reviews");
        list.add(description);
        list.add(specification);
        list.add(reviews);
        return list;
    }

}
