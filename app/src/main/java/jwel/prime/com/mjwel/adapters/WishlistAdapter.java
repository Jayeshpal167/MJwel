package jwel.prime.com.mjwel.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import jwel.prime.com.mjwel.activities.HomeActivity;
import jwel.prime.com.mjwel.fragments.FragmentLauncher;
import jwel.prime.com.mjwel.fragments.ProductDetailFragment;
import jwel.prime.com.mjwel.R;
import jwel.prime.com.mjwel.model.Products;

public class WishlistAdapter extends RecyclerView.Adapter<WishlistAdapter.WishlistViewHolder> {
    private HomeActivity homeActivity;
    private List<Products> list;

    public WishlistAdapter(HomeActivity homeActivity, List<Products> list) {
        this.homeActivity = homeActivity;
        this.list = list;
    }

    @NonNull
    @Override
    public WishlistAdapter.WishlistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View wishlistView = LayoutInflater.from(parent.getContext()).inflate(R.layout.wishlist_item,parent,false);
        return new WishlistViewHolder(wishlistView);
    }

    @Override
    public void onBindViewHolder(@NonNull WishlistAdapter.WishlistViewHolder holder, int position) {
        Products product = list.get(position);
        holder.wishlistProductName.setText(product.getProductName());
        holder.wishlistProductPrice.setText(product.getProductPrice());
        holder.wishlistProductRating.setText(product.getProductRating());
        holder.wishlistProductImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentLauncher.launchFragment(homeActivity, R.id.homeFrame, new ProductDetailFragment(), true, false);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class WishlistViewHolder extends RecyclerView.ViewHolder {
        private ImageView wishlistProductImage;
        private TextView wishlistProductName, wishlistProductRating, wishlistProductPrice;
        private Button wishlistAddTocart;
        public WishlistViewHolder(@NonNull View itemView) {
            super(itemView);
            wishlistAddTocart = itemView.findViewById(R.id.wishlist_add_to_cart);
            wishlistProductImage = itemView.findViewById(R.id.wishlist_product_image);
            wishlistProductName = itemView.findViewById(R.id.wishlist_product_name);
            wishlistProductPrice = itemView.findViewById(R.id.wishlist_product_price);
            wishlistProductRating = itemView.findViewById(R.id.wishlist_product_rating);
        }
    }
}
