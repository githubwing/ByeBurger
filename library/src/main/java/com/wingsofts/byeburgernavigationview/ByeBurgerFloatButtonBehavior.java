package com.wingsofts.byeburgernavigationview;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;

/**
 * Behavior for Float Button
 * Created by wing on 11/8/16.
 */

public class ByeBurgerFloatButtonBehavior extends ByeBurgerBehavior {

  public ByeBurgerFloatButtonBehavior(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
    if(canInit) {
      mAnimateHelper = ScaleAnimateHelper.get(child);
      canInit = false;
    }
    return super.layoutDependsOn(parent, child, dependency);
  }


  @Override protected void onNestPreScrollInit(View child) {

  }
}
