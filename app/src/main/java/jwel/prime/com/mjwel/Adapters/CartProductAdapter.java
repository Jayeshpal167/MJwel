package jwel.prime.com.mjwel.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import jwel.prime.com.mjwel.Activity.HomeActivity;
import jwel.prime.com.mjwel.R;
import jwel.prime.com.mjwel.model.Products;

public class CartProductAdapter extends RecyclerView.Adapter<CartProductAdapter.CartProductViewHolder> {
    private List<Products> list;
    private HomeActivity homeActivity;

    public CartProductAdapter(List<Products> list, HomeActivity homeActivity) {
        this.list = list;
        this.homeActivity = homeActivity;
    }

    @NonNull
    @Override
    public CartProductAdapter.CartProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cartProducts = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item,parent,false);
        return new CartProductViewHolder(cartProducts);
    }

    @Override
    public void onBindViewHolder(@NonNull final CartProductAdapter.CartProductViewHolder holder, int position) {
        final int[] Quantity = {1};
        Products product = list.get(position);
        holder.cartProductName.setText(product.getProductName());
        holder.cartProductPrice.setText(product.getProductPrice());
        holder.cartProductPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Quantity[0]++;
                holder.cartProductQty.setText(String.valueOf(Quantity[0]));
            }
        });
        holder.cartProductMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Quantity[0] == 1)
                    Toast.makeText(homeActivity, "Minimum quantity must be 1!!", Toast.LENGTH_SHORT).show();
                else{
                    Quantity[0]--;
                    holder.cartProductQty.setText(String.valueOf(Quantity[0]));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CartProductViewHolder extends RecyclerView.ViewHolder{
        private ImageView cartProductImage, cartProductPlus, cartProductMinus;
        private TextView cartProductName, cartProductPrice, cartProductQty;
        private Button cartRemove;
        public CartProductViewHolder(@NonNull View itemView) {
            super(itemView);
            cartProductImage = itemView.findViewById(R.id.cart_product_image);
            cartProductName = itemView.findViewById(R.id.cart_product_name);
            cartProductQty = itemView.findViewById(R.id.cart_product_qty);
            cartProductPrice = itemView.findViewById(R.id.cart_product_price);
            cartProductPlus = itemView.findViewById(R.id.cart_product_qty_plus);
            cartProductMinus = itemView.findViewById(R.id.cart_product_qty_minus);
        }
    }
}
