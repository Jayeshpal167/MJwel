package jwel.prime.com.mjwel.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import jwel.prime.com.mjwel.R;
import jwel.prime.com.mjwel.adapters.PointsAdapter;
import jwel.prime.com.mjwel.constant.ToolBarManagerHome;
import jwel.prime.com.mjwel.model.PointsModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutUsFragment extends BaseHomeFragment {

    public AboutUsFragment() {
        // Required empty public constructor
    }

    private View contentView;
    private RecyclerView aboutUsRecycler;
    private TextView aboutUsTitle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.fragment_about_us, container, false);
        aboutUsRecycler = contentView.findViewById(R.id.about_us_recycler);
        aboutUsRecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        List<PointsModel> list = new ArrayList<>();
        list.add(new PointsModel(1, "MJWEL is India's Leading ZERO FEE online B2B, B2C, O2O jewellery market place, bringing together Manufacture, Whole seller, Retailers and supporting them to sell their product globally."));
        aboutUsRecycler.setAdapter(new PointsAdapter(mActivity, list));
        return contentView;
    }

    @Override
    public void onStart() {
        super.onStart();
        mActivity.enableDrawer(true);
        mActivity.hideBackButton();
        ToolBarManagerHome.getInstance().setHeaderTitle("");
    }
}
