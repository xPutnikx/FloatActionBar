package vhudnitsky.floatactionbar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ListView;
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
        this.floatListView.setScrollDirectionListener(this);
    }

    public FloatActionListViewFrame(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.floatActionBar = new FloatActionBar(context);
        this.floatListView = new FloatActionListView(context,attrs);
        this.floatListView.setScrollDirectionListener(this);
    }

    public FloatActionListViewFrame(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.floatActionBar = new FloatActionBar(context);
        this.floatListView = new FloatActionListView(context,attrs,defStyle);
        this.floatListView.setScrollDirectionListener(this);
    }

    @Override
    public void scrollToTop() {
       floatActionBar.showAnimation();
    }

    @Override
    public void scrollToBottom() {
        floatActionBar.showAnimation();
    }

    public void setCustomFloatView(int layoutId){
        floatActionBar.setCustomView(layoutId);
    }

    public ListView getActualListView(){
        return this.floatListView;
    }
}
