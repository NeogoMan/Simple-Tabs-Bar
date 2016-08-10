package com.app.ecommerce.ui.views;


import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.app.ecommerce.R;

public class TabsBarView extends FrameLayout implements View.OnClickListener {

    private LinearLayout mTabsViewLayout;
    private TabView      mTabView;


    private onSelectTabListener mOnSelectTabListener;



    public interface onSelectTabListener{
        public void onSelectTeb(int position);
    }

    public TabsBarView(Context context) {
        this(context, null);
    }

    public TabsBarView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public TabsBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeViews();
    }

    private void initializeViews() {
        inflate(getContext(), R.layout.tabs_bar_view,this);
        mTabsViewLayout       = (LinearLayout) findViewById(R.id.tabs_view_layout);

        for (int i = 0; i <mTabsViewLayout.getChildCount() ; i++) {
            ((TabView)mTabsViewLayout.getChildAt(i)).setOnClickListener(this);
        }
        selectTab(0);
    }


    public void selectTab(int position) {
        for (int i = 0; i <mTabsViewLayout.getChildCount() ; i++) {
            if(i == position){
                mTabView = (TabView) mTabsViewLayout.getChildAt(position);
                mTabView.setSelected(true);
            }else {
                mTabView = (TabView) mTabsViewLayout.getChildAt(i);
                mTabView.setSelected(false);
            }
        }
    }

    @Override
    public void onClick(View v) {
        selectTab(mTabsViewLayout.indexOfChild(v));
        if (mOnSelectTabListener!=null){
            mOnSelectTabListener.onSelectTeb(mTabsViewLayout.indexOfChild(v));
        }
    }

    public void setmOnSelectTabListener(onSelectTabListener mOnSelectTabListener) {
        this.mOnSelectTabListener = mOnSelectTabListener;
    }


}

