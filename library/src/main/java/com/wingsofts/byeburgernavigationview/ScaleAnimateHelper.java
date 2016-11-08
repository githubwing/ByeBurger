package com.wingsofts.byeburgernavigationview;

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
    mTarget.setVisibility(View.VISIBLE);
    ScaleAnimation sa = new ScaleAnimation(0f,1f,0f,1f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
    sa.setDuration(300);
    mTarget.startAnimation(sa);
    mCurrentState = STATE_SHOW;
  }

  @Override public void hide() {
    mTarget.setVisibility(View.GONE);
    ScaleAnimation sa = new ScaleAnimation(1.0f,0f,1.0f,0f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
    sa.setDuration(300);
    mTarget.startAnimation(sa);
    mCurrentState = STATE_HIDE;
  }

  public int getState(){
    return mCurrentState;
  }
}
