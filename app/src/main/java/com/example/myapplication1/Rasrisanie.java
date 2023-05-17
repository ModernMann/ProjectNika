package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication1.adapter.BookAdapter;
import com.example.myapplication1.adapter.ClassAdapter;
import com.example.myapplication1.model.Book;
import com.example.myapplication1.model.Class;

import java.util.ArrayList;
import java.util.List;

public class Rasrisanie extends AppCompatActivity {
    RecyclerView classRecycler, RecyclerBook;
    ClassAdapter classAdapter;
   static  BookAdapter BookAdapter;
   static List<Book> bookList = new ArrayList<>();
    static List<Book> fullList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rasrisanie);

        List<Class> classList = new ArrayList<>();
        classList.add(new Class(1, "Булгаков"));
        classList.add(new Class(2, "Фет"));
        classList.add(new Class(3, "Толстой"));

        setClassRecycler(classList);


        bookList.add(new Book(1, "_032075_887063.jpg","Мастер и Маргарита\n М.А.Булгаков", "4543343", "4","#24577B", "Роман «Мастер и Маргарита» повествует о фантастических приключениях Воланда, называющего себя иностранным профессором и дьяволом, во время его пребывания в Москве 1930-х годов.",1 ));
        bookList.add(new Book(2, "","Стихи детям \nА.А.Фет", "5758340", "16", "#65A5D1","Афанасия Фета всегда волновали проблемы страны, поэтому эти вопросы он поднимал в своей прозе, публицистических работах и мемуарах. В публицистике его гневные тирады обличали реальность существующего мира.", 2));
        bookList.add(new Book(3, "", "Война и Мир\n Л.Н.Толстой", "3232","1", "#008500", "Второй том «Войны и мира» освещает события общественной жизни 1806–1811 годов, накануне Отечественной войны. Его по праву можно назвать единственным «мирным» во всем романе.",3));

       fullList.addAll(bookList);
        setRecyclerBook(bookList);
    }
    public void OpenCart(View view) {
        Intent intent = new Intent(this, BookPage.class);
        startActivity(intent);

    }
    private void setRecyclerBook(List<Book> bookList)
    {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        RecyclerBook = findViewById(R.id.RecyclerBook);
        RecyclerBook.setLayoutManager(layoutManager);

        BookAdapter = new BookAdapter(this, bookList);
        RecyclerBook.setAdapter(BookAdapter);
    }

    private void  setClassRecycler(List<Class> classList)
    {
      RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

      classRecycler = findViewById(R.id.classRecucler);
      classRecycler.setLayoutManager(layoutManager);

      classAdapter = new ClassAdapter(this, classList);
      classRecycler.setAdapter(classAdapter);
    }
    public static void showBookByClass (int category){
        bookList.clear();
        bookList.addAll(fullList);
    List<Book> filterBook = new ArrayList<>();
    for(Book c: bookList) {
        if(c.getCategory() == category)
            filterBook.add(c);
    }
         bookList.clear();
         bookList.addAll(filterBook);

         BookAdapter.notifyDataSetChanged();

    }
}