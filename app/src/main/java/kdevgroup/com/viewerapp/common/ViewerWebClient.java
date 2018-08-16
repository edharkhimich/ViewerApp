package kdevgroup.com.viewerapp.common;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ViewerWebClient extends WebViewClient {

    private WebClientErrorListener listener;

    public ViewerWebClient(WebClientErrorListener listener) {
        this.listener = listener;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        listener.openViewer();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
        Log.d("mlogs", "onReceivedError: " + errorResponse.getStatusCode());
        if (errorResponse.getStatusCode() == 503 || errorResponse.getStatusCode() == 404) {
            listener.openViewer();
        }
    }

    public interface WebClientErrorListener {
        void openViewer();
    }
}
