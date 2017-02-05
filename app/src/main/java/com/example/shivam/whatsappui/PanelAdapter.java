package com.example.shivam.whatsappui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class PanelAdapter extends RecyclerView.Adapter<PanelAdapter.ViewHolder>{

    private  ArrayList<Contents> co;

  //  Context c;
  ArrayList<String>name;
  ArrayList<String>message;
  ArrayList<String>time;
  ArrayList<Bitmap>img;
    public PanelAdapter(Context c, ArrayList<String>name, ArrayList<String>message, ArrayList<String>time, ArrayList<Bitmap>img  ) {

        this.co = co;
  //      this.c = c;
        //name= new ArrayList<>();
        //message= new ArrayList<>();
        //time= new ArrayList<>();
        //img= new ArrayList<>();

        this.name=name ;
        this.message = message ;
        this.time = time ;
        this.img  = img ;


    }

    @Override

    public PanelAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.panel,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(PanelAdapter.ViewHolder holder, int position) {

  //      holder.name.setText(this.co.get(position).getTitle());
    //    holder.message.setText(this.co.get(position).getMessage());
      //  holder.time.setText(this.co.get(position).getTime());
        //holder.im.setImageBitmap(this.co.get(position).getD());
        holder.name.setText(this.name.get(position));
        holder.message.setText(this.message.get(position));
        holder.time.setText(this.time.get(position));
        holder.im.setImageBitmap(this.img.get(position));
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView message;
        private TextView time;
        private ImageButton im ;


        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.textView);
            message = (TextView)itemView.findViewById(R.id.textView2);
            time = (TextView)itemView.findViewById(R.id.textView3);
            im = (ImageButton)itemView.findViewById(R.id.imageButton);


        }
    }

}
