package com.example.midtronics_test;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

    ArrayList<String> countryList;
    public Resources res;
    Context context;
    private final RVClickListener rvListener;


    public CountryAdapter(Context context, ArrayList<String> nameList, RVClickListener listener) {
        countryList = nameList;
        this.context = context;
        this.rvListener = listener;
    }

    @NonNull
    @Override
    public CountryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.rv_items,parent,false);
        return new ViewHolder(view, rvListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryAdapter.ViewHolder holder, int position) {
        holder.countryName.setText(countryList.get(position));

    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView countryName;
        RVClickListener listener;


        public ViewHolder(@NonNull View itemView, RVClickListener rvListener) {
            super(itemView);
            this.countryName = itemView.findViewById(R.id.btn_countryName);
            this.listener = rvListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(getBindingAdapterPosition());
        }
    }

    public interface RVClickListener{
        void onClick(int position);
    }

}
