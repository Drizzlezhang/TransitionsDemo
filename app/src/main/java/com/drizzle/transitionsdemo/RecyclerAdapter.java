package com.drizzle.transitionsdemo;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import java.util.List;

/**
 * Created by drizzle on 16/4/24.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
	private List<ItemBean> mItemBeanList;
	private Context mContext;
	private LayoutInflater mLayoutInflater;

	public RecyclerAdapter(List<ItemBean> itemBeanList, Context context) {
		mItemBeanList = itemBeanList;
		mContext = context;
		mLayoutInflater = LayoutInflater.from(mContext);
	}

	@Override public int getItemCount() {
		return mItemBeanList.size();
	}

	@Override public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return new MyViewHolder(mLayoutInflater.inflate(R.layout.main_item, parent, false));
	}

	@Override public void onBindViewHolder(final MyViewHolder holder, final int position) {
		ItemBean itemBean = mItemBeanList.get(position);
		holder.circle.setImageTintList(ColorStateList.valueOf(itemBean.color));
		holder.title.setText(itemBean.title);
		holder.layout.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v) {
				mOnItemClickListener.onItemClick(null, holder.layout, position, 0);
			}
		});
	}

	class MyViewHolder extends RecyclerView.ViewHolder {
		@Bind(R.id.item_circle) ImageView circle;
		@Bind(R.id.item_title) TextView title;
		@Bind(R.id.item_layout) LinearLayout layout;

		public MyViewHolder(View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
		}
	}

	private AdapterView.OnItemClickListener mOnItemClickListener;

	public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
		this.mOnItemClickListener = onItemClickListener;
	}
}
