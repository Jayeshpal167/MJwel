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
import jwel.prime.com.mjwel.model.PointsModel;

public class PointsAdapter extends RecyclerView.Adapter<PointsAdapter.PointsViewHolder> {
    private HomeActivity homeActivity;
    private List<PointsModel> list;

    public PointsAdapter(HomeActivity homeActivity, List<PointsModel> list) {
        this.homeActivity = homeActivity;
        this.list = list;
    }

    @NonNull
    @Override
    public PointsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View points = LayoutInflater.from(parent.getContext()).inflate(R.layout.point_item,parent,false);
        return new PointsViewHolder(points);
    }

    @Override
    public void onBindViewHolder(@NonNull PointsViewHolder holder, int position) {
        PointsModel pointsModel = list.get(position);
        holder.pointsString.setText(pointsModel.getPointString());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class PointsViewHolder extends RecyclerView.ViewHolder {
        TextView pointsString;
        public PointsViewHolder(@NonNull View itemView) {
            super(itemView);
            pointsString = itemView.findViewById(R.id.point_string);
        }
    }
}
