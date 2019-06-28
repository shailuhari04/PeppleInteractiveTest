package com.peopleinteractivetest.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.peopleinteractivetest.ui.user_list.core.view.UserListActivity;

public class NavigatorUtils {

    public static void exitActivity(Activity context) {
        context.finish();
    }

    public static void gotoUserListActivity(Context context) {
        Intent i = new Intent(context, UserListActivity.class);
        context.startActivity(i);
    }
}
