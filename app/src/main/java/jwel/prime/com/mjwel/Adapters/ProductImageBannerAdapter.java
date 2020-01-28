package jwel.prime.com.mjwel.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

import jwel.prime.com.mjwel.R;
import jwel.prime.com.mjwel.model.ProductImagesBanner;

public class ProductImageBannerAdapter extends PagerAdapter {
    private Context context;
    private List<ProductImagesBanner> list = new ArrayList<>();
    private LayoutInflater inflater;
    public ProductImageBannerAdapter(Context context, List<ProductImagesBanner> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View productImageLayout = inflater.inflate(R.layout.banner_image, container, false);
        ImageView productImage = productImageLayout.findViewById(R.id.product_bimage);
        container.addView(productImageLayout,0);
        return productImageLayout;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }
}
