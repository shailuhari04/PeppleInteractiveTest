package com.peopleinteractivetest.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivitySplahBinding extends ViewDataBinding {
  @NonNull
  public final ImageView ivLogo;

  protected ActivitySplahBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView ivLogo) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ivLogo = ivLogo;
  }

  @NonNull
  public static ActivitySplahBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_splah, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySplahBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivitySplahBinding>inflateInternal(inflater, com.peopleinteractivetest.R.layout.activity_splah, root, attachToRoot, component);
  }

  @NonNull
  public static ActivitySplahBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_splah, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySplahBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivitySplahBinding>inflateInternal(inflater, com.peopleinteractivetest.R.layout.activity_splah, null, false, component);
  }

  public static ActivitySplahBinding bind(@NonNull View view) {
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
  public static ActivitySplahBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivitySplahBinding)bind(component, view, com.peopleinteractivetest.R.layout.activity_splah);
  }
}
