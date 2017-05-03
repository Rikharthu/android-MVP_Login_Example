package com.example.uberv.mvploginexample.main;

import java.util.List;

public interface MainContract {

    // Activity (is a View) uses Presenter, Presenter uses Model to fetch data and View to update the UI (Activity)

    /**
     * Usualy implemented by an Activity or a framgnet. Contains reference to the presenter
     */
    interface MainView {
        void showProgress();

        void hideProgress();

        void setItems(List<String> items);

        void showMessage(String message);
    }

    /**
     * Presenter ir responsible to act as the middle man between view and model.
     * Thus view cant explicitly access the model and vice-versa
     * Model <--> Presenter <--> View
     * Usually is provided by the Dagger, but can also be constructed in the View
     */
    interface MainPresenter {
        void onResume();

        void onItemClicked(int position);

        void onDestroy();
    }

    /**
     * Model plays a role of a gateway to the domain layer or business logic.
     * For now it is the provider of the data we want to display in the view
     */
    interface MainModel {
        interface OnFinishedListener {
            void onFinished(List<String> items);
        }

        void findItems(OnFinishedListener listener);
    }
}
