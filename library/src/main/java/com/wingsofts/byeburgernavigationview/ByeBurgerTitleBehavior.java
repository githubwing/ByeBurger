package com.wingsofts.byeburgernavigationview;

/**
 * Created by wing on 11/5/16.
 */

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;

/**
 * Bye Bye Burger Android Title Bar Behavior
 *
 * Created by wing on 11/4/16.
 */

public class ByeBurgerTitleBehavior extends ByeBurgerBehavior {

  private TranslateAnimateHelper mAnimateHelper;

  public ByeBurgerTitleBehavior(Context context, AttributeSet attrs) {
    super(context, attrs);

  }

  @Override
  public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target,
      int dx, int dy, int[] consumed) {

    if (isFirstMove) {
      isFirstMove = false;
      mAnimateHelper = TranslateAnimateHelper.get(child);
      mAnimateHelper.setStartY(child.getY());
      mAnimateHelper.setMode(TranslateAnimateHelper.MODE_TITLE);
    }
    if (Math.abs(dy) > mTouchSlop) {
      if (dy < 0) {

        if (mAnimateHelper.getState() == TranslateAnimateHelper.STATE_HIDE) {
          mAnimateHelper.show();
        }
      } else if (dy > 0) {
        if (mAnimateHelper.getState() == TranslateAnimateHelper.STATE_SHOW) {
          mAnimateHelper.hide();
        }
      }
    }
  }
}

