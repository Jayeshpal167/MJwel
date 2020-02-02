package jwel.prime.com.mjwel.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import jwel.prime.com.mjwel.Adapters.CartProductAdapter;
import jwel.prime.com.mjwel.R;
import jwel.prime.com.mjwel.constant.ToolBarManagerHome;
import jwel.prime.com.mjwel.model.Products;

/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends BaseHomeFragment {


    public CartFragment() {
        // Required empty public constructor
    }
    private TextView cartTitle, cartDiscountText, cartTotalMrp, cartShippingCharge, cartPayableAmount, cartFinalAmount;
    private Button cartBuy;
    private RecyclerView cartRecycler;
    private View contentView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.fragment_cart, container, false);
        cartTitle = contentView.findViewById(R.id.cart_title);
        cartDiscountText = contentView.findViewById(R.id.cart_discount_text);
        cartRecycler = contentView.findViewById(R.id.cart_recycler);
        cartRecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        cartTotalMrp = contentView.findViewById(R.id.cart_total_mrp);
        cartShippingCharge = contentView.findViewById(R.id.cart_shipping_charge);
        cartPayableAmount = contentView.findViewById(R.id.cart_payable_amount);
        cartFinalAmount = contentView.findViewById(R.id.cart_final_price);
        List<Products> list = new ArrayList<>();
        list.add(new Products(1, "Test", "link", "3.0", "12000"));
        cartRecycler.setAdapter(new CartProductAdapter(list, mActivity));
        setOrderSummary("12000", "600", "12600" ,"12600");
        return contentView;
    }

    private void setOrderSummary(String totalMrp, String shippingCharge, String payableAmount, String finalAmount) {
        cartTotalMrp.setText("₹ "+ totalMrp);
        cartShippingCharge.setText("₹ "+ shippingCharge);
        cartPayableAmount.setText("₹ "+ payableAmount);
        cartFinalAmount.setText("₹ "+ finalAmount);
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
