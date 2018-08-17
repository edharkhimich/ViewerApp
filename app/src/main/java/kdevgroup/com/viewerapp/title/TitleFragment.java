package kdevgroup.com.viewerapp.title;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
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

public class TitleFragment extends MvpAppCompatFragment implements TitleView {

    @BindView(R.id.titleWbVw)
    WebView webView;

    @InjectPresenter
    TitlePresenter presenter;

    private ViewerWebClient.WebClientErrorListener listener = ()
            -> presenter.getViewState().showViewer();

    private ViewerWebClient webClient = new ViewerWebClient(listener);

    public TitleFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_title, container, false);
        ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        webView.setOnKeyListener((v, keyCode, event) -> {
            if (event.getAction() == KeyEvent.ACTION_DOWN) {
                WebView webView = (WebView) v;

                switch (keyCode) {
                    case KeyEvent.KEYCODE_BACK:
                        if (webView.canGoBack()) {
                            webView.goBack();
                            return true;
                        }
                        break;
                }
            }

            return false;
        });
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

