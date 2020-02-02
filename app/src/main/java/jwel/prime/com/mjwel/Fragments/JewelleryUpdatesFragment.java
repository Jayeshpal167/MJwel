package jwel.prime.com.mjwel.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import jwel.prime.com.mjwel.Adapters.NewAndUpdatesRecyclerAdapter;
import jwel.prime.com.mjwel.R;
import jwel.prime.com.mjwel.model.NewsAndUpdates;

/**
 * A simple {@link Fragment} subclass.
 */
public class JewelleryUpdatesFragment extends Fragment {


    public JewelleryUpdatesFragment() {
        // Required empty public constructor
    }

    private RecyclerView jewelleryUpdatesRecycler;
    private View contentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        contentView = inflater.inflate(R.layout.fragment_jewellery_updates, container, false);
        jewelleryUpdatesRecycler = contentView.findViewById(R.id.jewellery_updates_recycler);
        jewelleryUpdatesRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        List<NewsAndUpdates> list = new ArrayList<>();
        list.add(new NewsAndUpdates(1,
                "link",
                "In the international markets, gold shed over 1 per cent after vaulting above the $1,600 level for the first time in nearly seven years on Wednesday.",
                "Bullion counters slipped on Wednesday after tensions in West Asia eased following reassuring comments from US President Donald Trump. This helped investors to seek riskier assets. Trump said the US did not necessarily have to respond militarily to the Iranian attacks on military bases housing US troops in Iraq overnight. He said no Americans were"));
        jewelleryUpdatesRecycler.setAdapter(new NewAndUpdatesRecyclerAdapter(list));
        return contentView;
    }

}
