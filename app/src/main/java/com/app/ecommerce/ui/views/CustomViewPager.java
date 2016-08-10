package com.app.ecommerce.ui.views;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class CustomViewPager extends ViewPager {

	private boolean allowsSwiping = true;

	public CustomViewPager(Context context) {
		super(context);
	}

	public CustomViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent event) {
		if (allowsSwiping) {
			return super.onInterceptTouchEvent(event);
		} else {
			return false;
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (allowsSwiping) {
			return super.onTouchEvent(event);
		} else {
			return false;
		}
	}

	private void allowSwiping(boolean value) {
		allowsSwiping = value;
	}

}