package kdevgroup.com.viewerapp.web;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(SkipStrategy.class)
interface WebClientView extends MvpView {

    void showPage();

    void showViewer();

}
