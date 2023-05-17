package com.example.myapplication1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication1.R;
import com.example.myapplication1.Rasrisanie;
import com.example.myapplication1.model.Class;

import java.util.List;

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ClassViewHolder> {

    Context context;
    List<Class> category;

    public ClassAdapter(Context context, List<Class> category) {
        this.context = context;
        this.category = category;
    }

    @NonNull
    @Override
    public ClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  categoryItems = LayoutInflater.from(context).inflate(R.layout.category_class, parent, false);
        return new ClassViewHolder(categoryItems);
    }

    @Override
    public void onBindViewHolder(@NonNull  ClassViewHolder holder, int position) {
        holder.classTitle.setText(category.get(position).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Rasrisanie.showBookByClass(category.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return category.size();
    }

    public static final class ClassViewHolder extends RecyclerView.ViewHolder {

        TextView classTitle;

        public ClassViewHolder(@NonNull View itemView) {
            super(itemView);

            classTitle = itemView.findViewById(R.id.classTitle);
        }
    }


}
