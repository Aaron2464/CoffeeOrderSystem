package com.aaron.coffeeordersystem.fragment;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aaron.coffeeordersystem.Object.CoffeeItem;
import com.aaron.coffeeordersystem.R;
import com.aaron.coffeeordersystem.adapter.PurchaseItemAdapter;
import com.aaron.coffeeordersystem.adapter.PurchaseOrderDetailAdapter;
import com.aaron.coffeeordersystem.util.LinearItemDecoration;
import com.aaron.coffeeordersystem.util.MarginDecoration;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PurchaseFragment extends Fragment {

    private DatabaseReference db = FirebaseDatabase.getInstance().getReference();
    private RecyclerView mRecyclerViewPurchaseItem;
    private RecyclerView mRecyclerViewPurchaseOrderDetail;
    private PurchaseItemAdapter mPurchaseItemAdapter;
    private PurchaseOrderDetailAdapter mPurchaseOrderDetailAdapter;
    private ArrayList<CoffeeItem> mData = new ArrayList<>();

    public PurchaseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_purchase, container, false);
        mRecyclerViewPurchaseItem = view.findViewById(R.id.recycler_item);
        mRecyclerViewPurchaseItem.addItemDecoration(new MarginDecoration(getContext()));
        mRecyclerViewPurchaseItem.setHasFixedSize(true);
        mRecyclerViewPurchaseItem.setLayoutManager(new GridLayoutManager(getContext(),4));

        mRecyclerViewPurchaseOrderDetail = view.findViewById(R.id.recycler_item_detail);
        mRecyclerViewPurchaseOrderDetail.addItemDecoration(new LinearItemDecoration(1, Color.parseColor("#e7e7e7")));
        mRecyclerViewPurchaseOrderDetail.setHasFixedSize(true);
        mRecyclerViewPurchaseOrderDetail.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        db.child("items").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    CoffeeItem mCoffeeItem = childSnapshot.getValue(CoffeeItem.class);
                    Log.d("Aaron", "snapshot: " + mCoffeeItem.getImage());
                    mData.add(mCoffeeItem);
                }
                mPurchaseItemAdapter = new PurchaseItemAdapter(getContext(),mData);
                mPurchaseItemAdapter.notifyDataSetChanged();
                mRecyclerViewPurchaseItem.setAdapter(mPurchaseItemAdapter);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mPurchaseOrderDetailAdapter = new PurchaseOrderDetailAdapter(getContext());
        mPurchaseOrderDetailAdapter.notifyDataSetChanged();
        mRecyclerViewPurchaseOrderDetail.setAdapter(mPurchaseOrderDetailAdapter);
    }
}
