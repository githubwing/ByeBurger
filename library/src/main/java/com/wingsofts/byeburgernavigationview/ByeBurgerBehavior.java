package com.wingsofts.byeburgernavigationview;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;

/**
 * Base Behavior
 * Created by wing on 11/8/16.
 */

public class ByeBurgerBehavior extends CoordinatorLayout.Behavior<View> {

  protected final int mTouchSlop;
  protected boolean isFirstMove = true;

  public ByeBurgerBehavior(Context context, AttributeSet attrs) {
    super(context, attrs);
    mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
  }
}
