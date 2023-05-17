package com.example.myapplication1.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication1.PageCategory;
import com.example.myapplication1.R;
import com.example.myapplication1.model.Book;

import org.w3c.dom.Text;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BooksViewHolder> {

    Context context;
   List<Book> books;

    public BookAdapter(Context context, List<Book> books) {
        this.context = context;
        this.books = books;
    }

    @NonNull
    @Override
    public BooksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  BookItems = LayoutInflater.from(context).inflate(R.layout.book_item, parent, false);
        return new BookAdapter.BooksViewHolder(BookItems);

    }

    @Override
    public void onBindViewHolder(@NonNull BooksViewHolder holder, int position) {

    holder.books.setBackgroundColor(Color.parseColor(books.get(position).getColor()));

    int ImageId = context.getResources().getIdentifier(books.get(position).getImg(), "drawable", context.getPackageName());
    holder.bookImage.setImageResource(ImageId);

    holder.booksTitle.setText(books.get(position).getTitle());
    holder.namber.setText(books.get(position).getNomer());
    holder.colvo.setText(books.get(position).getColvo());

    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, PageCategory.class);
            intent.putExtra("RageBg",Color.parseColor(books.get(position).getColor()) );
            intent.putExtra("pageImage",ImageId );
            intent.putExtra("PageTitle",books.get(position).getTitle() );
            intent.putExtra("Pagenamber",books.get(position).getNomer());
            intent.putExtra("Pagecolvo",books.get(position).getColvo());
            intent.putExtra("PageText",books.get(position).getText());
            intent.putExtra("PageId",books.get(position).getId());
            context.startActivity(intent);
        }
    });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public static final class BooksViewHolder extends RecyclerView.ViewHolder{

            LinearLayout books;
            ImageView bookImage;
            TextView booksTitle, colvo, namber;
        public BooksViewHolder(@NonNull View itemView) {
            super(itemView);

            books = itemView.findViewById(R.id.books);
            bookImage = itemView.findViewById(R.id.bookImage);
            booksTitle = itemView.findViewById(R.id.booksTitle);
            colvo = itemView.findViewById(R.id.colvo);
            namber = itemView.findViewById(R.id.namber);
        }
    }
}
