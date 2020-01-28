package jwel.prime.com.mjwel.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import jwel.prime.com.mjwel.Activity.HomeActivity;
import jwel.prime.com.mjwel.R;
import jwel.prime.com.mjwel.model.ProductTag;

public class ProductTagAdapter extends RecyclerView.Adapter<ProductTagAdapter.ProductTagViewHolder> {
    private HomeActivity activity;
    private List<ProductTag> productTags;

    public ProductTagAdapter(HomeActivity activity, List<ProductTag> productTags) {
        this.activity = activity;
        this.productTags = productTags;
    }

    @NonNull
    @Override
    public ProductTagViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View productview = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_tag,parent, false);
        return new ProductTagViewHolder(productview);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductTagViewHolder holder, int position) {
        ProductTag productTag = productTags.get(position);
        holder.productTagName.setText(productTag.getTagName());
    }

    @Override
    public int getItemCount() {
        return productTags.size();
    }


    public class ProductTagViewHolder extends RecyclerView.ViewHolder {
        private TextView productTagName;
        public ProductTagViewHolder(@NonNull View itemView) {
            super(itemView);
            productTagName = itemView.findViewById(R.id.product_tag_name);
        }
    }
}
