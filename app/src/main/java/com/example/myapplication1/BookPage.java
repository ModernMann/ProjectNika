package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication1.model.Book;
import com.example.myapplication1.model.Request;

import java.util.ArrayList;
import java.util.List;

public class BookPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_page);

        ListView requestList = findViewById(R.id.RequestList);

        List<String> BookTitle = new ArrayList<>();
        for(Book c: Rasrisanie.fullList) {
            if(Request.items_id.contains(c.getId()))
            BookTitle.add(c.getTitle());
        }
            requestList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,BookTitle));

    }
}