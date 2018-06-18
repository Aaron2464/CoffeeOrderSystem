package com.aaron.coffeeordersystem.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.aaron.coffeeordersystem.Object.CoffeeItem;
import com.aaron.coffeeordersystem.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PurchaseItemAdapter extends RecyclerView.Adapter<PurchaseItemAdapter.ViewHolder> {

    private ArrayList<CoffeeItem> mCoffeeItems;
    private Context mContext;

    public PurchaseItemAdapter(Context mContext, ArrayList<CoffeeItem> data) {
        mCoffeeItems = data;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_purchase_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.get().load(mCoffeeItems.get(position).getImage()).fit().centerCrop().placeholder(R.mipmap.placeholder_coffee).into(holder.mImageView_gridcoffee);
    }

    @Override
    public int getItemCount() {
        Log.d("Aaron", "size: " + mCoffeeItems.size());
        return mCoffeeItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageButton mImageView_gridcoffee;

        public ViewHolder(final View itemview) {
            super(itemview);
            mImageView_gridcoffee = itemview.findViewById(R.id.imageview_gridcoffee);

            mImageView_gridcoffee.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {


        }
    }
}
