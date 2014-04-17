package vhudnitsky.floatactionbar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AbsListView;
import android.widget.ListView;
import vhudnitsky.floatactionbar.ScrollDirectionListener;

/**
 * Created by v.hudnitsky on 4/16/14.
 */
public class FloatActionListView extends ListView implements AbsListView.OnScrollListener{
    private ScrollDirectionListener scrollDirectionListener;
    private int previousFirstVisibleItem;

    public FloatActionListView(Context context) {
        super(context);
        super.setOnScrollListener(this);
    }

    public FloatActionListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        super.setOnScrollListener(this);
    }

    public FloatActionListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        super.setOnScrollListener(this);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

        if (scrollDirectionListener != null) {
            if (this.previousFirstVisibleItem > firstVisibleItem) {
                scrollDirectionListener.scrollToTop();
            } else if (this.previousFirstVisibleItem < firstVisibleItem) {
                scrollDirectionListener.scrollToBottom();
            }
            this.previousFirstVisibleItem = firstVisibleItem;
        }
    }

    public void setScrollDirectionListener(ScrollDirectionListener scrollDirectionListener) {
        this.scrollDirectionListener = scrollDirectionListener;
    }
}
