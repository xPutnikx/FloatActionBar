package vhudnitsky.floatactionbar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;
import android.widget.ScrollView;
import vhudnitsky.floatactionbar.ScrollDirectionListener;

/**
 * Created by v.hudnitsky on 4/16/14.
 */
public class FloatActionScrollView extends ScrollView{
    public FloatActionScrollView(Context context) {
        super(context);
    }

    public FloatActionScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FloatActionScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
    }


}
