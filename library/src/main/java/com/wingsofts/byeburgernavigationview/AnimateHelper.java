package com.wingsofts.byeburgernavigationview;

import android.util.Log;
import android.view.View;
import android.view.animation.TranslateAnimation;

/**
 * A Animate Helper to control view's visibility
 * Created by wing on 11/5/16.
 */

public class AnimateHelper {
  public View mTarget;
  public float mStartY;
  public static int STATE_SHOW = 1;
  public static int STATE_HIDE = 0;
  public int mCurrentState = STATE_SHOW;
  public int mMode = MODE_TITLE;
  public static int MODE_TITLE = 233;
  public static int MODE_BOTTOM = 2333;

  private AnimateHelper(View view) {
    mTarget = view;
  }

  public static AnimateHelper get(View target) {
    return new AnimateHelper(target);
  }

  public void show() {
    if (mMode == MODE_TITLE) {
      showTitle();
    } else if (mMode == MODE_BOTTOM) {
      showBottom();
    }
  }


  private void hideTitle() {
    mTarget.setY(-mTarget.getMeasuredHeight());
    TranslateAnimation ta = new TranslateAnimation(0f, 0f,mTarget.getMeasuredHeight(),0f);
    ta.setDuration(300);
    mTarget.startAnimation(ta);

    mCurrentState = STATE_HIDE;


  }
  private void showTitle() {

    mTarget.setY(mStartY);
    TranslateAnimation ta = new TranslateAnimation(0f, 0f,-mTarget.getMeasuredHeight(),0);
    ta.setDuration(300);
    mTarget.startAnimation(ta);
    mCurrentState = STATE_SHOW;

  }

  public void hide() {
    if (mMode == MODE_TITLE) {
      hideTitle();
    } else if (mMode == MODE_BOTTOM) {
      hideBottom();
    }
  }

  private void showBottom() {
    mTarget.setY(mStartY);
    TranslateAnimation ta = new TranslateAnimation(0f, 0f,mTarget.getMeasuredHeight(),0);
    ta.setDuration(300);
    mTarget.startAnimation(ta);
    mCurrentState = STATE_SHOW;

  }
  private void hideBottom() {

    mTarget.setY(mStartY+mTarget.getMeasuredHeight());

    TranslateAnimation ta = new TranslateAnimation(0f, 0f,-mTarget.getMeasuredHeight(),0);

    mTarget.startAnimation(ta);
    ta.setDuration(300);
    mCurrentState = STATE_HIDE;
  }


  public void setStartY(float y) {
    mStartY = y;
  }

  public int getState() {
    return mCurrentState;
  }

  public void setMode(int mode) {
    mMode = mode;
  }

  private void setState(int state){
    mCurrentState = state;
  }
}
