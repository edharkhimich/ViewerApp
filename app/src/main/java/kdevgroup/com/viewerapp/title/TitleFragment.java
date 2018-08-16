package kdevgroup.com.viewerapp.title;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import kdevgroup.com.viewerapp.R;
import kdevgroup.com.viewerapp.common.FragmentFactory;
import kdevgroup.com.viewerapp.viewer.ViewerFragment;
import kdevgroup.com.viewerapp.web.WebClientFragment;

public class TitleFragment extends MvpAppCompatFragment implements TitleView {

    @InjectPresenter
    TitlePresenter presenter;

    @BindView(R.id.toolbarTxtV)
    TextView toolbarTxtV;

    @BindView(R.id.titleFirstContainer)
    ImageView firstContainer;

    @BindView(R.id.titleSecContainer)
    ImageView secondContainer;

    public TitleFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_title, container, false);
        ButterKnife.bind(this, v);
        toolbarTxtV.setText(getString(R.string.toolbar_title));
        return v;
    }

    @Override
    public void showPictures() {
        secondContainer.setOnClickListener(v -> FragmentFactory.changeFragment(getFragmentManager(), R.id.container,
                new ViewerFragment(), true, null));
    }

    @Override
    public void showPage() {
        firstContainer.setOnClickListener(v -> FragmentFactory.changeFragment(getFragmentManager(), R.id.container,
                new WebClientFragment(), false, null));
    }
}
