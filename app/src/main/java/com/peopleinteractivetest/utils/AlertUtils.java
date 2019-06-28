package com.peopleinteractivetest.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.provider.Settings;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class AlertUtils {

    private static SweetAlertDialog sweetAlertDialog;

    /**
     * Show Loading / Progress Dialog while data is fetching form api
     *
     * @param context
     */
    public static void showProgress(Context context) {
        sweetAlertDialog = new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE);
        sweetAlertDialog.getProgressHelper().setBarColor(Color.parseColor("#24BCCB"));
        sweetAlertDialog.setTitleText(Constants.PROGRESS_TITLE);
        sweetAlertDialog.setCancelable(true);
        sweetAlertDialog.show();
    }


    /**
     * Hide The Showing Loading / Progress Dialog
     */
    public static void hideProgress() {
        if (sweetAlertDialog.isShowing()) {
            sweetAlertDialog.dismissWithAnimation();
        }
    }

    /**
     * Show Internet Connection Alert
     *
     * @param context
     */
    public static void showNetworkAlert(final Context context) {
        new SweetAlertDialog(context, SweetAlertDialog.NORMAL_TYPE)
                .setTitleText(Constants.NETWORK_ALERT_TITLE)
                .setContentText(Constants.NETWORK_ALERT_TEXT)
                .setConfirmText(Constants.NETWORK_ALERT_CONFIRM_TEXT)
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        context.startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                        sDialog.dismissWithAnimation();
                    }
                })
                .show();
    }


    /**
     * Show Error Alert
     *
     * @param context
     * @param message
     */
    public static void showErrorAlert(Context context, String message) {
        new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                .setTitleText(Constants.ERROR_ALERT_TITLE)
                .setContentText(message)
                .show();
    }

}
