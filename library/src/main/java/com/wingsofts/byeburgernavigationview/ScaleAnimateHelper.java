package com.wingsofts.byeburgernavigationview;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

/**
 * ScaleAnimateHelper using for float button
 *
 * Created by wing on 11/8/16.
 */

public class ScaleAnimateHelper implements AnimateHelper {

  public View mTarget;
  public int mCurrentState = STATE_SHOW;

  private ScaleAnimateHelper(View view) {
    mTarget = view;
  }

  public static ScaleAnimateHelper get(View view) {
    return new ScaleAnimateHelper(view);
  }

  @Override public void show() {
    ValueAnimator va = ValueAnimator.ofFloat(mTarget.getScaleX(), 1);
    va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float scale = (Float) valueAnimator.getAnimatedValue();
        mTarget.setScaleX(scale);
        mTarget.setScaleY(scale);
      }
    });
    va.setDuration(300);
    va.start();

    mCurrentState = STATE_SHOW;
  }

  @Override public void hide() {
    ValueAnimator va = ValueAnimator.ofFloat(mTarget.getScaleX(), 0);
    va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float scale = (Float) valueAnimator.getAnimatedValue();
        mTarget.setScaleX(scale);
        mTarget.setScaleY(scale);
      }
    });
    va.setDuration(300);
    va.start();
    mCurrentState = STATE_HIDE;
  }

  @Override public void setStartY(float y) {

  }

  @Override public void setMode(int modeBottom) {

  }

  public int getState() {
    return mCurrentState;
  }
}
