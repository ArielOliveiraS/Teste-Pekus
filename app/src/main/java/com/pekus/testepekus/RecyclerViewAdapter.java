package com.pekus.testepekus;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements View.OnClickListener{

    private ComunicaGeral comunicaGeral;
    private int recyclerList;
    private Context context;

    RecyclerViewAdapter(int recyclerLength, ComunicaGeral comunicaGeral, Context context) {
        this.recyclerList = recyclerLength;
        this.comunicaGeral = comunicaGeral;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate ( R.layout.item_lista, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        String nConverter = String.format( "% 05d " , position +1);


        String formatPosition = "Item " + String.valueOf(position +1);

        holder.textViewNum.setText(nConverter);

        holder.textViewPosicao.setText(formatPosition);


        holder.linearLayout.setTag(R.string.tag1, holder);
        holder.linearLayout.setTag(R.string.tag2, position);
        holder.linearLayout.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return recyclerList;
    }

    @Override
    public void onClick(View view)
    {
        ViewHolder viewHolder;
        int posicao;
        try
        {
            viewHolder = (ViewHolder) view.getTag(R.string.tag1);
            if (view == viewHolder.linearLayout){
                posicao = (int) view.getTag(R.string.tag2);

                comunicaGeral.comunicaGeral(getClass(), view.getId(), true, posicao);
            }

        }catch (Exception ex){
            Log.i("tag1", ex.getMessage());
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNum;
        TextView textViewPosicao;
        LinearLayout linearLayout;

        ViewHolder(View itemView) {
            super(itemView);
            textViewNum = itemView.findViewById(R.id.textViewNum);
            textViewPosicao = itemView.findViewById(R.id.txtPosição);
            linearLayout = itemView.findViewById(R.id.lId);
        }

    }
}

