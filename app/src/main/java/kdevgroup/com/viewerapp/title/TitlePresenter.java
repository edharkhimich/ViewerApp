package kdevgroup.com.viewerapp.title;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class TitlePresenter extends MvpPresenter<TitleView> {

    @Override
    protected void onFirstViewAttach() {
        getViewState().showPage();
    }
}
