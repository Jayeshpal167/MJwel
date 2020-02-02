package jwel.prime.com.mjwel.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import jwel.prime.com.mjwel.R;
import jwel.prime.com.mjwel.model.NewsAndUpdates;

public class NewAndUpdatesRecyclerAdapter extends RecyclerView.Adapter<NewAndUpdatesRecyclerAdapter.NewAndUpdatesRecyclerViewHolder> {
    List<NewsAndUpdates> list;

    public NewAndUpdatesRecyclerAdapter(List<NewsAndUpdates> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public NewAndUpdatesRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View newsAndUpdates = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_updates_item,parent,false);
        return new NewAndUpdatesRecyclerViewHolder(newsAndUpdates);
    }

    @Override
    public void onBindViewHolder(@NonNull NewAndUpdatesRecyclerViewHolder holder, int position) {
        NewsAndUpdates andUpdates = list.get(position);
        holder.subHeading.setText(andUpdates.getNewsAndUpdatesSubHeading());
        holder.content.setText(andUpdates.getNewsAndUpdatesContent());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NewAndUpdatesRecyclerViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView subHeading, content;
        public NewAndUpdatesRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.news_updates_image);
            subHeading = itemView.findViewById(R.id.news_updates_subheading);
            content = itemView.findViewById(R.id.news_updates_content);
        }
    }
}
