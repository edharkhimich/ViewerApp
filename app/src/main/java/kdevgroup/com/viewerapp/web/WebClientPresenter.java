package kdevgroup.com.viewerapp.web;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class WebClientPresenter extends MvpPresenter<WebClientView> {

    @Override
    protected void onFirstViewAttach() {
        getViewState().showPage();
    }

}
