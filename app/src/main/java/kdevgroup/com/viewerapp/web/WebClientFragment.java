package kdevgroup.com.viewerapp.web;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import kdevgroup.com.viewerapp.R;
import kdevgroup.com.viewerapp.common.FragmentFactory;
import kdevgroup.com.viewerapp.common.ViewerWebClient;
import kdevgroup.com.viewerapp.viewer.ViewerFragment;

import static kdevgroup.com.viewerapp.common.Constants.BASE;

public class WebClientFragment extends MvpAppCompatFragment implements WebClientView {

    @BindView(R.id.webClientWbVw)
    WebView webView;

    @InjectPresenter
    WebClientPresenter presenter;

    private ViewerWebClient.WebClientErrorListener listener = ()
            -> presenter.getViewState().showViewer();

    private ViewerWebClient webClient = new ViewerWebClient(listener);


    public WebClientFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_web, container, false);
        ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void showPage() {
        webView.setWebViewClient(webClient);
        webView.loadUrl(BASE);
    }

    @Override
    public void showViewer() {
        FragmentFactory.changeFragment(getFragmentManager(),
                R.id.container, new ViewerFragment(), false, null);
    }

}
