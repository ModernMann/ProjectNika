package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication1.model.Request;

public class PageCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_category);

        ConstraintLayout PageBg = findViewById(R.id.RageBg);
        ImageView pageImage = findViewById(R.id.pageImage);
        TextView PageTitle = findViewById(R.id.PageTitle);
        TextView Pagenamber = findViewById(R.id.Pagenamber);
        TextView Pagecolvo = findViewById(R.id.Pagecolvo);
        TextView PageText = findViewById(R.id.PageText);

        PageBg.setBackgroundColor(getIntent().getIntExtra("PageBg", 0));
        pageImage.setImageResource(getIntent().getIntExtra("pageImage", 0));
        PageTitle.setText(getIntent().getStringExtra("PageTitle"));
        Pagenamber.setText(getIntent().getStringExtra("Pagenamber"));
        Pagecolvo.setText(getIntent().getStringExtra("Pagecolvo"));
        PageText.setText(getIntent().getStringExtra("PageText"));

    }

    public void  addToCart (View view){
            int item_id = getIntent().getIntExtra("PageId", 0);
            Request.items_id.add(item_id);
            Toast.makeText(this, "Добавлено!", Toast.LENGTH_LONG).show();

    }
}