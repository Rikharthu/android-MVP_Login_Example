package com.example.uberv.mvploginexample.main;

import java.util.List;

public class MainPresenterImpl
        implements MainContract.MainPresenter, MainContract.MainModel.OnFinishedListener {

    private MainContract.MainView mMainView;
    // service used to find items
    private ItemsFinder mItemsFinder;

    public MainPresenterImpl(MainContract.MainView mainView, ItemsFinder itemsFinder) {
        mMainView = mainView;
        // you can also use dagger to get reference to the service. it doesn't matter
        // the point is that View layer should not explicitly reference the Model/Data layer
        // - only through the Presenter
        mItemsFinder = itemsFinder;
    }

    @Override
    public void onResume() {
        if (mMainView != null) {
            mMainView.showProgress();
        }

        mItemsFinder.findItems(this);
    }

    @Override
    public void onItemClicked(int position) {
        if (mMainView != null) {
            mMainView.showMessage(String.format("Position %d clicked", position + 1));
        }
    }

    @Override
    public void onDestroy() {
        mMainView = null;
    }

    @Override
    public void onFinished(List<String> items) {
        if (mMainView != null) {
            mMainView.setItems(items);
            mMainView.hideProgress();
        }
    }

    // TODO ???
    public MainContract.MainView getMainView() {
        return mMainView;
    }
}
