package vhudnitsky.floatactionbar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.nineoldandroids.view.ViewPropertyAnimator;

import vhudnitsky.floatactionbar.ScrollDirectionListener;

/**
 * Created by v.hudnitsky on 4/16/14.
 */
public class FloatActionListViewFrame extends FrameLayout implements ScrollDirectionListener {

    private FloatActionBar floatActionBar;
    private FloatActionListView floatListView;

    public FloatActionListViewFrame(Context context) {
        super(context);
        this.floatActionBar = new FloatActionBar(context);
        this.floatListView = new FloatActionListView(context);
        attachFloatActionBar();
        initListView();
    }

    public FloatActionListViewFrame(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.floatActionBar = new FloatActionBar(context);
        this.floatListView = new FloatActionListView(context,attrs);
        attachFloatActionBar();
        initListView();
    }

    public FloatActionListViewFrame(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.floatActionBar = new FloatActionBar(context);
        this.floatListView = new FloatActionListView(context,attrs,defStyle);
        attachFloatActionBar();
        initListView();
    }

    private void attachFloatActionBar() {
        this.addView(floatActionBar);
    }

    private void initListView() {
        this.floatListView.setScrollDirectionListener(this);
        this.addView(floatListView);
        initListSize();
    }

    @Override
    public void scrollToTop() {
       floatActionBar.showAnimation();
    }

    @Override
    public void scrollToBottom() {
        this.floatActionBar.hideAnimation();
    }

    @Override
    public void scrollToFirstElem() {
        this.floatActionBar.measure(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        final int rootHeight = this.floatActionBar.getMeasuredHeight();

        ViewPropertyAnimator.animate(this.floatListView).translationY(rootHeight).setDuration(100);
    }

    @Override
    public void scrollFromFirstElem() {
        ViewPropertyAnimator.animate(this.floatListView).translationY(0).setDuration(100);
    }

    public void setCustomFloatView(int layoutId){
        floatActionBar.setCustomView(layoutId);
    }

    public ListView getActualListView(){
        return this.floatListView;
    }

    private void initListSize(){
        LayoutParams layoutParams = (LayoutParams) this.getLayoutParams();
        if(layoutParams == null){
            layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        }else{
            layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
            layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
        }
        this.setLayoutParams(layoutParams);
    }
}
