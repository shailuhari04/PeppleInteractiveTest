package com.peopleinteractivetest.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.card.MaterialCardView;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class RowItemUserListBinding extends ViewDataBinding {
  @NonNull
  public final MaterialCardView cvAccept;

  @NonNull
  public final MaterialCardView cvDecline;

  @NonNull
  public final MaterialCardView cvRowItem;

  @NonNull
  public final CircleImageView profileImage;

  @NonNull
  public final TextView tvInfo;

  @NonNull
  public final TextView tvName;

  @NonNull
  public final TextView tvReceiveTime;

  @Bindable
  protected String mName;

  @Bindable
  protected String mInfo;

  @Bindable
  protected String mReceiveTime;

  protected RowItemUserListBinding(Object _bindingComponent, View _root, int _localFieldCount,
      MaterialCardView cvAccept, MaterialCardView cvDecline, MaterialCardView cvRowItem,
      CircleImageView profileImage, TextView tvInfo, TextView tvName, TextView tvReceiveTime) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cvAccept = cvAccept;
    this.cvDecline = cvDecline;
    this.cvRowItem = cvRowItem;
    this.profileImage = profileImage;
    this.tvInfo = tvInfo;
    this.tvName = tvName;
    this.tvReceiveTime = tvReceiveTime;
  }

  public abstract void setName(@Nullable String name);

  @Nullable
  public String getName() {
    return mName;
  }

  public abstract void setInfo(@Nullable String info);

  @Nullable
  public String getInfo() {
    return mInfo;
  }

  public abstract void setReceiveTime(@Nullable String receiveTime);

  @Nullable
  public String getReceiveTime() {
    return mReceiveTime;
  }

  @NonNull
  public static RowItemUserListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.row_item_user_list, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static RowItemUserListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<RowItemUserListBinding>inflateInternal(inflater, com.peopleinteractivetest.R.layout.row_item_user_list, root, attachToRoot, component);
  }

  @NonNull
  public static RowItemUserListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.row_item_user_list, null, false, component)
   */
  @NonNull
  @Deprecated
  public static RowItemUserListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<RowItemUserListBinding>inflateInternal(inflater, com.peopleinteractivetest.R.layout.row_item_user_list, null, false, component);
  }

  public static RowItemUserListBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static RowItemUserListBinding bind(@NonNull View view, @Nullable Object component) {
    return (RowItemUserListBinding)bind(component, view, com.peopleinteractivetest.R.layout.row_item_user_list);
  }
}
