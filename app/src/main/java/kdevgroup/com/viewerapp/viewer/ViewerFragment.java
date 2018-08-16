package kdevgroup.com.viewerapp.viewer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import kdevgroup.com.viewerapp.R;

public class ViewerFragment extends MvpAppCompatFragment implements ViewerView {

    @InjectPresenter
    ViewerPresenter presenter;

    @BindView(R.id.viewerViewPager)
    ViewPager viewPager;

    @BindView(R.id.dots_indicator)
    DotsIndicator dotsIndicator;

    ViewerViewPagerAdapter viewPagerAdapter;

    public ViewerFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_viewer, container, false);
        ButterKnife.bind(this, v);
        viewPagerAdapter = new ViewerViewPagerAdapter(Objects.requireNonNull(getActivity()));

        viewPager.setAdapter(viewPagerAdapter);
        dotsIndicator.setViewPager(viewPager);
        return v;
    }
}
