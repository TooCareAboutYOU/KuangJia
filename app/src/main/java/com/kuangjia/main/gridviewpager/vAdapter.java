package com.kuangjia.main.gridviewpager;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class vAdapter extends PagerAdapter{
	public List<View> vList;
	public vAdapter(List<View> vList) {
	  this.vList = vList;
	}
	
	@Override
	public int getCount() { return vList.size(); }

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) { return arg0==arg1; }

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		((ViewPager)container).removeView(vList.get(position));
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		((ViewPager)container).addView(vList.get(position));	
		return vList.get(position);
	}
	
	

}
