package vhudnitsky.floatactionbar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import vhudnitsky.floatactionbar.R;

/**
 * Created by v.hudnitsky on 4/16/14.
 */
public class FloatActionBar extends RelativeLayout {
    private Animation hideAnimation;
    private Animation showAnimation;
    private boolean hideIsEnded = true;
    private boolean showIsEnded = true;
    private boolean actionBarIsShowed = true;

    public FloatActionBar(Context context) {
        super(context);
        initAnimation();
    }

    public FloatActionBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAnimation();
    }

    public FloatActionBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initAnimation();
    }

    private void initCustomView(View view){
        RelativeLayout.LayoutParams params = initLayoutParams(view);
        this.addView(view, params);
        initAnimation();
    }

    public void setCustomView(int layoutId){
        View innerView = inflate(getContext(), layoutId, null);
        initCustomView(innerView);
    }

    private LayoutParams initLayoutParams(View view){
        RelativeLayout.LayoutParams params = (LayoutParams) view.getLayoutParams();
        if(params == null){
            params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }else {
            params.width = ViewGroup.LayoutParams.MATCH_PARENT;
            params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        }
        int defMargin = (int) getContext().getResources().getDimension(R.dimen.def_margin);
        params.setMargins(defMargin,defMargin,defMargin,defMargin);
        return params;
    }

    private void initAnimation() {
        measure(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        final int rootHeight = getMeasuredHeight();
        final int defMargin = (int) getContext().getResources().getDimension(R.dimen.def_margin);

        hideAnimation = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) getLayoutParams();
                if ((params != null ? params.topMargin : 0) != -rootHeight) {
                    params.topMargin = (int) (-rootHeight * interpolatedTime);
                    setLayoutParams(params);
                }
            }
        };
        hideAnimation.setDuration(300);
        hideAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                hideIsEnded = false;
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                hideIsEnded = true;
                actionBarIsShowed = false;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        showAnimation = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) getLayoutParams();
                if ((params != null ? params.topMargin : 0) != defMargin ) {
                    params.topMargin = (int) (defMargin * interpolatedTime);
                    setLayoutParams(params);
                }
            }
        };
        showAnimation.setDuration(500);
        showAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                showIsEnded = false;
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                showIsEnded = true;
                actionBarIsShowed = true;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void showAnimation(){
        if (showIsEnded && !actionBarIsShowed) {
            startAnimation(showAnimation);
        }
    }

    public void hideAnimation(){
        if (hideIsEnded && actionBarIsShowed) {
            startAnimation(hideAnimation);
        }
    }
}
