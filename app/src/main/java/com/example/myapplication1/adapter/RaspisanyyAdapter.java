package com.example.myapplication1.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication1.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RaspisanyyAdapter extends RecyclerView.Adapter<RaspisanyyAdapter.ViewHolder> {
    public static final String TAG = "TAG";
    LayoutInflater inflater;
    List<String>  title,discriptions, imageUrl, one, two, tri, cet;

    public RaspisanyyAdapter(Context context, List<String> title, List<String> discriptions, List<String> imageUrl, List<String> one, List<String> two, List<String> tri, List<String> cet){
    this.inflater = LayoutInflater.from(context);
    this.title =  title;
    this.discriptions = discriptions;
    this.imageUrl = imageUrl;
    this.one = one;
    this.two = two;
    this.tri = tri;
    //this.cet = cet;
        Log.d("TAG", "Adapter" +title);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  inflater.inflate(R.layout.custom_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     String titles = title.get(position);
     String discription = discriptions.get(position);
     String img = imageUrl.get(position);
    String on = one.get(position);
     String tw = two.get(position);
     String tr = tri.get(position);
//     String ce = cet.get(position);

        Log.d("TAG", "Adapter" +title);

        holder.title.setText(titles);
        holder.content.setText(discription);
        Picasso.get().load(img).into(holder.listImg);
       holder.one.setText(on);
       holder.two.setText(tw);
       holder.tri.setText(tr);
//        holder.cet.setText(ce);
    }

    @Override
    public int getItemCount() {
        return title.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView listImg;
        TextView title,content, one, two, tri, cet;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            listImg = itemView.findViewById(R.id.listimage);
            title = itemView.findViewById(R.id.title);
            content = itemView.findViewById(R.id.discriptions);
           one = itemView.findViewById(R.id.textView2);
            two = itemView.findViewById(R.id.textView3);
            tri = itemView.findViewById(R.id.textView4);
            cet = itemView.findViewById(R.id.textView5);
        }
    }
}
