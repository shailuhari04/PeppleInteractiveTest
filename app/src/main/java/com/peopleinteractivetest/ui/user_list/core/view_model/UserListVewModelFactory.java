package com.peopleinteractivetest.ui.user_list.core.view_model;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.peopleinteractivetest.ui.user_list.core.view.UserListView;

public class UserListVewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private UserListView userListView;

    public UserListVewModelFactory(UserListView userListView) {
        this.userListView = userListView;
    }

    /**
     * Here we are providing the instance of view inside the viewModel
     *
     * @param modelClass
     * @param <T>
     * @return
     */
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new UserListViewModel(userListView);
    }
}