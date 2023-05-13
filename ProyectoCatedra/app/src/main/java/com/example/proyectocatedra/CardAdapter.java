package com.example.proyectocatedra;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private ArrayList<CardData> cardDataList;

    public CardAdapter(ArrayList<CardData> cardDataList) {
        this.cardDataList = cardDataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_record, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CardData cardData = cardDataList.get(position);
        holder.netSalaryTextView.setText(cardData.getNetSalary());
        holder.deductionsTextView.setText(cardData.getDeductions());
        holder.baseSalaryTextView.setText(cardData.getBaseSalary());
    }

    @Override
    public int getItemCount() {
        return cardDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView netSalaryTextView,deductionsTextView,baseSalaryTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            netSalaryTextView = itemView.findViewById(R.id.txtCardNetSalary);
            deductionsTextView = itemView.findViewById(R.id.txtCardDeductions);
            baseSalaryTextView = itemView.findViewById(R.id.txtCardBaseSalary);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, ViewData.class);
                    intent.putExtra("id", cardDataList.get(getAdapterPosition()).getId());
                    context.startActivity(intent);
                }
            });
        }
    }
}
