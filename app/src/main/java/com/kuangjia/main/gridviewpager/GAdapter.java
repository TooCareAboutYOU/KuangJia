package com.kuangjia.main.gridviewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kuangjia.main.R;

import java.util.List;

public class GAdapter extends BaseAdapter{
	
	public List<Caterory> gList;
	public Context context;
	public GAdapter(List<Caterory> gList,Context context) {
		this.gList=gList;
		this.context=context;
	}
	
	@Override
	public int getCount() { return gList.size(); }

	@Override
	public Object getItem(int position) { return gList.get(position); }

	@Override
	public long getItemId(int position) { return position; }

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		HorldView h =null;
		if(convertView==null){
			convertView = LayoutInflater.from(context).inflate(R.layout.item_gridviewpager, null);
			h= new HorldView();
			h.img = (ImageView) convertView.findViewById(R.id.img_g);
			h.tvg=  (TextView) convertView.findViewById(R.id.tv_g);
			convertView.setTag(h);
		}else{
			h = (HorldView) convertView.getTag();
		}
		
		Caterory c = gList.get(position);
		h.img.setImageResource(c.getImg());
		h.tvg.setText(c.getName());
		return convertView;
	}
	
	class HorldView{
		public ImageView img;
		public TextView tvg;
	}

}
