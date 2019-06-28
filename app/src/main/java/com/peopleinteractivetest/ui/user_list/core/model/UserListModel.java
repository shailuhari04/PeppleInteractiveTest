package com.peopleinteractivetest.ui.user_list.core.model;

import com.peopleinteractivetest.pojo.response.UserResultResponse;
import com.peopleinteractivetest.remote.RetrofitClient;

import io.reactivex.Observable;

public class UserListModel {

    /**
     * Get Observable of user form Api Request
     *
     * @return
     */
    public Observable<UserResultResponse> apiCall() {
        return RetrofitClient.getAPIService().getUsers(10);
    }

}
