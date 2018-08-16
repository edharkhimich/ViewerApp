package kdevgroup.com.viewerapp.common;

import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ViewerWebClient extends WebViewClient {

    private WebClientErrorListener listener;

    public ViewerWebClient(WebClientErrorListener listener) {
        this.listener = listener;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }

    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        listener.openViewer();
    }

    public interface WebClientErrorListener {
        void openViewer();
    }
}
