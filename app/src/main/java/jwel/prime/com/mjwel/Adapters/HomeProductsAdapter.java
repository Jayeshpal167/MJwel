package jwel.prime.com.mjwel.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import jwel.prime.com.mjwel.Activity.HomeActivity;
import jwel.prime.com.mjwel.Fragments.FragmentLauncher;
import jwel.prime.com.mjwel.Fragments.ProductDetailFragment;
import jwel.prime.com.mjwel.R;
import jwel.prime.com.mjwel.model.Products;

public class HomeProductsAdapter extends RecyclerView.Adapter<HomeProductsAdapter.HomeProductsViewHolder> {
    private List<Products> productList;
    private HomeActivity activity;

    public HomeProductsAdapter(HomeActivity activity, List<Products> productList) {
        this.productList = productList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public HomeProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View productItemList = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_products, parent, false);
        return new HomeProductsViewHolder(productItemList);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeProductsViewHolder holder, int position) {
        Products product = productList.get(position);
        holder.productName.setText(product.getProductName());
        holder.productPrice.setText(product.getProductPrice());
        holder.productRating.setText(product.getProductRating());
        holder.productCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentLauncher.launchFragment(activity, R.id.homeFrame, new ProductDetailFragment(), true, false);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class HomeProductsViewHolder extends RecyclerView.ViewHolder {
        private TextView productName, productRating, productPrice;
        private ImageView productImage;
        private CardView productCard;
        public HomeProductsViewHolder(@NonNull View itemView) {
            super(itemView);
            productCard = itemView.findViewById(R.id.productCard);
            productImage = itemView.findViewById(R.id.home_product_image);
            productName = itemView.findViewById(R.id.home_product_name);
            productPrice = itemView.findViewById(R.id.home_product_price);
            productRating = itemView.findViewById(R.id.home_product_rating);
        }
    }
}
