package com.peopleinteractivetest.ui.user_list.core.view_model;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.peopleinteractivetest.pojo.response.UserResultResponse;
import com.peopleinteractivetest.ui.user_list.core.model.UserListModel;
import com.peopleinteractivetest.ui.user_list.core.view.UserListView;
import com.peopleinteractivetest.utils.Constants;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class UserListViewModel extends ViewModel {

    private static final String TAG = "UserListViewModel";
    private UserListView userListView;
    private UserListModel userListModel;

    public UserListViewModel(UserListView userListView) {
        this.userListView = userListView;
        this.userListModel = new UserListModel();
    }

    /**
     * Get Observable from UserListMode and Subscribe It and update view
     */
    public void getUserData() {
        userListModel.apiCall()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserResultResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.i(TAG, "onSubscribe: getUserData");
                        userListView.showProgress();
                    }

                    @Override
                    public void onNext(UserResultResponse userResultResponse) {
                        Log.i(TAG, "onNext: getUserData");
                        userListView.onSuccess(userResultResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError: getUserData");
                        userListView.hideProgress();
                        if (e instanceof IOException)
                            userListView.onError(Constants.IOEXCEPTION_MESSAGE);
                        userListView.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.i(TAG, "onComplete: getUserData");
                        userListView.hideProgress();
                    }
                });
    }

}
