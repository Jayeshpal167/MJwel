package jwel.prime.com.mjwel.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import jwel.prime.com.mjwel.activities.HomeActivity;
import jwel.prime.com.mjwel.R;
import jwel.prime.com.mjwel.model.BestOffer;

public class BestOfferAdapter extends RecyclerView.Adapter<BestOfferAdapter.BestOfferViewHolder> {
    private HomeActivity homeActivity;
    private List<BestOffer> list;

    public BestOfferAdapter(HomeActivity homeActivity, List<BestOffer> list) {
        this.homeActivity = homeActivity;
        this.list = list;
    }

    @NonNull
    @Override
    public BestOfferViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View bestOfferView = LayoutInflater.from(parent.getContext()).inflate(R.layout.best_of_offer, parent, false);
        return new BestOfferViewHolder(bestOfferView);
    }

    @Override
    public void onBindViewHolder(@NonNull BestOfferViewHolder holder, int position) {
        BestOffer bestOffer = list.get(position);
        holder.validity.setText(bestOffer.getBestOfferValidity());
        holder.title.setText(bestOffer.getBestOfferTitle());
        holder.tagline.setText(bestOffer.getBestOfferTagline());
        holder.discount.setText(bestOffer.getBestOfferDiscount());
        //for image call getter of the bestOffer it contains link TODO
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class BestOfferViewHolder extends RecyclerView.ViewHolder{
        private ImageView backimage;
        private TextView validity, discount, title, tagline;
        public BestOfferViewHolder(@NonNull View itemView) {
            super(itemView);
            discount = itemView.findViewById(R.id.discount_percent);
            title = itemView.findViewById(R.id.offer_title);
            tagline = itemView.findViewById(R.id.offer_tagline);
            validity = itemView.findViewById(R.id.validity_offer);
        }
    }
}
