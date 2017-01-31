package com.example.shivam.whatsappui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class PanelAdapter extends RecyclerView.Adapter<PanelAdapter.ViewHolder>{

    private  ArrayList<String> name;
    private ArrayList<String> message;
    private ArrayList <String> time;

    Context c;



    public PanelAdapter(Context c, ArrayList<String> name , ArrayList<String> message, ArrayList<String> time ) {

        this.c = c;
        this.message = message;
        this.name = name;
        this.time = time;

    }

    @Override

    public PanelAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.panel,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(PanelAdapter.ViewHolder holder, int position) {

        holder.name.setText(this.name.get(position));
        holder.message.setText(this.message.get(position));
        holder.time.setText(this.time.get(position));

    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView message;
        private TextView time;


        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.textView);
            message = (TextView)itemView.findViewById(R.id.textView2);
            time = (TextView)itemView.findViewById(R.id.textView3);



        }
    }
}
