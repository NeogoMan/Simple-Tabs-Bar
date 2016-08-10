package com.app.ecommerce.ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.app.ecommerce.R;


public class TabView extends FrameLayout implements View.OnClickListener{
    private ImageView mTabImageView;
    private Drawable mImageDrawable;
    private Drawable  mImageIndecator;

    private LinearLayout mRootLayout;


    private onTabClickListener mOnTabClickListener;


    public interface onTabClickListener{
        public void onClickTab();
    }

    public TabView(Context context) {
        this(context, null);
    }

    public TabView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public TabView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeViews();
        TypedArray a       = context.obtainStyledAttributes(attrs, R.styleable.TabViewAttrs, defStyleAttr, 0);
        int iconResId      = a.getResourceId(R.styleable.TabViewAttrs_tabIcon, -1);
        int iconIndicator  = a.getResourceId(R.styleable.TabViewAttrs_indicator, -1);
        mImageIndecator    = (iconResId != -1) ? getResources().getDrawable(iconIndicator) : null;
        mImageDrawable     = (iconResId != -1) ? getResources().getDrawable(iconResId) : null;

        setIcon(mImageDrawable);

    }

    private void initializeViews() {
        inflate(getContext(), R.layout.view_tab, this);
        mRootLayout   = (LinearLayout) findViewById(R.id.root_layout);
        mTabImageView = (ImageView) findViewById(R.id.ic_icon_tab);
        mTabImageView.setOnClickListener(this);
    }

    public void setIcon(Drawable icon) {
        if(icon != null)
            mTabImageView.setImageDrawable(mImageDrawable = icon);
    }


    public void setIndecatore(Drawable indecator){
        mTabImageView.setImageDrawable(mImageIndecator=indecator);
    }

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        if(selected){
            mTabImageView.setImageDrawable(mImageIndecator);
            mRootLayout.setBackgroundColor(Color.RED);
            mTabImageView.setSelected(selected);
        }else {
            mTabImageView.setImageDrawable(mImageDrawable);
            mRootLayout.setBackgroundColor(Color.WHITE);
            mTabImageView.setSelected(selected);
        }

    }

    @Override
    public void onClick(View v) {
        performClick();
    }





    public void setmOnTabClickListener(onTabClickListener mOnTabClickListener) {
        this.mOnTabClickListener = mOnTabClickListener;
    }
}
