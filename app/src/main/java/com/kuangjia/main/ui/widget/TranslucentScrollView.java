package com.kuangjia.main.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by Dean.zhang on 2016-12-28.
 */

public class TranslucentScrollView extends ScrollView {
    public interface OnScrollChangedListener{ void OnScrollChangedListener(ScrollView who,int l, int t, int oldl, int oldt); }
    private OnScrollChangedListener scrollChangedListener;
    public void setOnScrollChangedListener(OnScrollChangedListener listener){ scrollChangedListener= listener; }

    public TranslucentScrollView(Context context) { super(context); }
    public TranslucentScrollView(Context context, AttributeSet attrs) { super(context, attrs); }
    public TranslucentScrollView(Context context, AttributeSet attrs, int defStyleAttr) { super(context, attrs, defStyleAttr); }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (scrollChangedListener != null ) {
            scrollChangedListener.OnScrollChangedListener(this,l,t,oldl,oldt);
        }
    }

}
