package jwel.prime.com.mjwel.adapters;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import jwel.prime.com.mjwel.activities.HomeActivity;
import jwel.prime.com.mjwel.R;
import jwel.prime.com.mjwel.model.Category;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private static int previousCategory = -1;
    private int selectedCategory = 0;
    private List<Category> categoryList;
    private HomeActivity activity;
    public CategoryAdapter(HomeActivity activity ,List<Category> list) {
        this.activity = activity;
        this.categoryList = list;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View categoryListItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_categories_layout,parent,false);
        return new CategoryViewHolder(categoryListItem);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, final int position) {
        Category category = categoryList.get(position);
        holder.categoryName.setText(category.getCategoryName());
        holder.categoryLayout.setBackground(activity.getResources().getDrawable(R.drawable.category_default));
        holder.categoryName.setTextColor(activity.getResources().getColor(R.color.category_text));
        if(selectedCategory == position) {
            holder.categoryLayout.setBackground(activity.getResources().getDrawable(R.drawable.gear_button));
            holder.categoryName.setTextColor(activity.getResources().getColor(R.color.white));
        }
        holder.categoryLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previousCategory = selectedCategory;
                selectedCategory = position;
                notifyItemChanged(previousCategory);
                notifyItemChanged(selectedCategory);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{
        private ImageView categoryImage;
        private TextView categoryName;
        private ConstraintLayout categoryLayout;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryImage = itemView.findViewById(R.id.category_image);
            categoryName = itemView.findViewById(R.id.category_name);
            categoryLayout = itemView.findViewById(R.id.category_layout);
        }
    }
}
