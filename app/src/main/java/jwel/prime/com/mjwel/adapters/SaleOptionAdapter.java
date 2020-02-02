package jwel.prime.com.mjwel.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import jwel.prime.com.mjwel.activities.HomeActivity;
import jwel.prime.com.mjwel.R;
import jwel.prime.com.mjwel.model.SaleOption;

public class SaleOptionAdapter extends RecyclerView.Adapter<SaleOptionAdapter.SaleOptionViewHolder> {
    private HomeActivity activity;
    private List<SaleOption> saleList;
    private static int previousSelectedState = -1;

    private int selectedState = 0;

    public SaleOptionAdapter(HomeActivity activity, List<SaleOption> list) {
        this.activity = activity;
        this.saleList = list;
    }

    @NonNull
    @Override
    public SaleOptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View saleOptionView = LayoutInflater.from(parent.getContext()).inflate(R.layout.sale_option, parent, false);
        return new SaleOptionViewHolder(saleOptionView);
    }

    @Override
    public void onBindViewHolder(@NonNull SaleOptionViewHolder holder, final int position) {
        SaleOption saleOption = saleList.get(position);
        holder.saleItem.setText(saleOption.getSaleName());
        holder.saleItem.setTextColor(activity.getResources().getColor(R.color.category_inactive_text));
        holder.saleItem.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        if(selectedState == position){
            holder.saleItem.setTextColor(activity.getResources().getColor(R.color.category_text));
            holder.saleItem.setCompoundDrawablesWithIntrinsicBounds(null, null, null, activity.getResources().getDrawable(R.drawable.active_dot));
        }
        holder.saleItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previousSelectedState = selectedState;
                selectedState = position;
                notifyItemChanged(previousSelectedState);
                notifyItemChanged(selectedState);
            }
        });
    }


    @Override
    public int getItemCount() {
        return saleList.size();
    }

    public class SaleOptionViewHolder extends RecyclerView.ViewHolder {
        private TextView saleItem;
        public SaleOptionViewHolder(@NonNull View itemView) {
            super(itemView);
            saleItem = itemView.findViewById(R.id.sale_item);
        }
    }
}
