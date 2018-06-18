package com.aaron.coffeeordersystem.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;

import com.aaron.coffeeordersystem.R;

public class PurchaseOrderDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEWTYPE_DETAIL = 0;
    private static final int VIEWTYPE_CONFIRM = 1;
    private Context mContext;

    public PurchaseOrderDetailAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_purchase_order_detail, parent, false);

        View view;
        int layoutId;
        RecyclerView.ViewHolder mViewHolder = null;

        switch (viewType){
            case VIEWTYPE_DETAIL:
                layoutId = R.layout.fragment_purchase_order_detail;
                view = LayoutInflater.from(mContext).inflate(layoutId,parent,false);
                mViewHolder = new PurchaseOrderDetailViewHolder(view);
                break;

            case VIEWTYPE_CONFIRM:
                layoutId = R.layout.fragment_purchase_confirm;
                view = LayoutInflater.from(mContext).inflate(layoutId,parent,false);
                mViewHolder = new PurchaseConfirmViewHolder(view);
                break;
            default:
                throw new IllegalArgumentException("Invalid view type, value of " + viewType);
        }
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof PurchaseOrderDetailViewHolder){
        }else {
//            ((PurchaseConfirmViewHolder)holder).mBtnConfirm.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                }
//            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 2)
        {
            return VIEWTYPE_CONFIRM;
        }
        else
        {
            return VIEWTYPE_DETAIL;
        }
    }

    @Override
    public int getItemCount() {

        return 2 + 1;
    }

    public class PurchaseOrderDetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private RadioGroup mRdoGroupType;
        private RadioGroup mRdoGroupSurgar;
        public PurchaseOrderDetailViewHolder(final View itemview) {
            super(itemview);
            mRdoGroupType = itemview.findViewById(R.id.rdoGrp_type);
            mRdoGroupSurgar = itemview.findViewById(R.id.rdoGrp_sugar);

        }

        @Override
        public void onClick(View view) {
        }
    }

    public class PurchaseConfirmViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Button mBtnConfirm;
        public PurchaseConfirmViewHolder(final View itemview) {
            super(itemview);
//            mBtnConfirm = itemview.findViewById(R.id.btn_confirm);

        }

        @Override
        public void onClick(View view) {
        }
    }
}
