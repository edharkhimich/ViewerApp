package kdevgroup.com.viewerapp.title;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(SkipStrategy.class)
interface TitleView extends MvpView {

    void showPage();

    void showViewer();

}
