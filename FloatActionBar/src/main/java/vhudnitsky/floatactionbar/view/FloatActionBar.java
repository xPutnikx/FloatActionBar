package vhudnitsky.floatactionbar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.nineoldandroids.view.ViewPropertyAnimator;

import vhudnitsky.floatactionbar.R;

/**
 * Created by v.hudnitsky on 4/16/14.
 */
public class FloatActionBar extends RelativeLayout {
    private boolean hideIsEnded = true;
    private boolean showIsEnded = true;
    private boolean actionBarIsShowed = true;
    private int rootHeight;

    public FloatActionBar(Context context) {
        super(context);
        calculateMeasureHeight();
    }

    public FloatActionBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        calculateMeasureHeight();
    }

    public FloatActionBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        calculateMeasureHeight();
    }

    private void initCustomView(View view){
        RelativeLayout.LayoutParams params = initLayoutParams(view);
        this.addView(view, params);
        calculateMeasureHeight();
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

    private void calculateMeasureHeight() {
        measure(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        rootHeight = getMeasuredHeight();
    }

    public void showAnimation(){
        if (showIsEnded && !actionBarIsShowed) {
            ViewPropertyAnimator.animate(this).setDuration(500).translationY(0).setListener(new com.nineoldandroids.animation.Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(com.nineoldandroids.animation.Animator animator) {
                    showIsEnded = false;
                }

                @Override
                public void onAnimationEnd(com.nineoldandroids.animation.Animator animator) {
                    showIsEnded = true;
                    actionBarIsShowed = true;
                }

                @Override
                public void onAnimationCancel(com.nineoldandroids.animation.Animator animator) {

                }

                @Override
                public void onAnimationRepeat(com.nineoldandroids.animation.Animator animator) {

                }
            });
        }
    }

    public void hideAnimation(){
        if (hideIsEnded && actionBarIsShowed) {
            ViewPropertyAnimator.animate(this).setDuration(500).translationY(-rootHeight).setListener(new com.nineoldandroids.animation.Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(com.nineoldandroids.animation.Animator animator) {
                    hideIsEnded = false;
                }

                @Override
                public void onAnimationEnd(com.nineoldandroids.animation.Animator animator) {
                    hideIsEnded = true;
                    actionBarIsShowed = false;
                }

                @Override
                public void onAnimationCancel(com.nineoldandroids.animation.Animator animator) {

                }

                @Override
                public void onAnimationRepeat(com.nineoldandroids.animation.Animator animator) {

                }
            });
        }
    }
}
