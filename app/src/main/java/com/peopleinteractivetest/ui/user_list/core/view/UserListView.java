package com.peopleinteractivetest.ui.user_list.core.view;

import com.peopleinteractivetest.pojo.response.UserResultResponse;
import com.peopleinteractivetest.ui.base_mvvm.BaseView;

public interface UserListView extends BaseView {

    void onSuccess(UserResultResponse userResultResponse);

    void onError(String message);
}
