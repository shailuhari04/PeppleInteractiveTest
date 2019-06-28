package com.peopleinteractivetest.ui.user_list.core.view;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.peopleinteractivetest.R;
import com.peopleinteractivetest.adapter.UserListAdapter;
import com.peopleinteractivetest.databinding.ActivityMainBinding;
import com.peopleinteractivetest.pojo.response.Result;
import com.peopleinteractivetest.pojo.response.UserResultResponse;
import com.peopleinteractivetest.ui.user_list.core.view_model.UserListVewModelFactory;
import com.peopleinteractivetest.ui.user_list.core.view_model.UserListViewModel;
import com.peopleinteractivetest.utils.AlertUtils;
import com.peopleinteractivetest.utils.NetworkUtils;

import java.util.ArrayList;
import java.util.List;

public class UserListActivity extends AppCompatActivity implements UserListAdapter.OnActionClickLstener, UserListView {

    private ActivityMainBinding binding;
    private static final String TAG = "UserListActivity";
    private UserListAdapter adapter;
    private List<Result> list;
    private UserListViewModel userListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //

        setUpBinding();
        initializeView();
        setupViewModel();

    }

    /**
     * Set ContentView with DataBinding
     */
    private void setUpBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }


    /**
     * initialize viewModel with associated view
     */
    private void setupViewModel() {
        userListViewModel = ViewModelProviders.of(this, new UserListVewModelFactory(this)).get(UserListViewModel.class);
    }

    /**
     * View Initialization (RecyclerView and Adapter)
     */
    private void initializeView() {
        list = new ArrayList<>();
        adapter = new UserListAdapter(list, this);
        binding.rvUserList.setLayoutManager(new LinearLayoutManager(this));
        binding.rvUserList.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (NetworkUtils.isConnectedToNetwork(this)) {
            loadData();
        } else {
            AlertUtils.showNetworkAlert(this);
        }
    }

    /**
     * Api Call (Get User Data)
     */
    private void loadData() {
        userListViewModel.getUserData();
    }


    /**
     * update the recyclerView list with animation
     *
     * @param position
     * @param cvRowItem
     */
    @Override
    public void onDeclineClick(final int position, View cvRowItem) {
        // Load the animation like this
        Animation animSlide = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_left);

        // Start the animation like this
        cvRowItem.startAnimation(animSlide);

        animSlide.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                list.remove(position);
                adapter.notifyDataSetChanged();

                if (list.size() == 0) {
                    loadData();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }


    /**
     * update the recyclerView list with animation
     *
     * @param position
     * @param cvRowItem
     */
    @Override
    public void onAcceptClick(final int position, View cvRowItem) {
        // Load the animation like this
        Animation animSlide = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_right);

        // Start the animation like this
        cvRowItem.startAnimation(animSlide);

        animSlide.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                list.remove(position);
                adapter.notifyDataSetChanged();

                if (list.size() == 0) {
                    loadData();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    @Override
    public void onSuccess(UserResultResponse userResultResponse) {
        list = userResultResponse.getResults();
        adapter.setList(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String message) {
        AlertUtils.showErrorAlert(this, message);
    }

    @Override
    public void showProgress() {
        AlertUtils.showProgress(this);
    }

    @Override
    public void hideProgress() {
        AlertUtils.hideProgress();
    }

    @Override
    public boolean isInternetAvailable() {
        return NetworkUtils.isConnectedToNetwork(this);
    }
}
