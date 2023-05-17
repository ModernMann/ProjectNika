package com.example.myapplication1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication1.model.AdminRaspisanie;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication1.adapter.RaspisanyyAdapter;
import com.google.android.material.resources.TextAppearance;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.FileAsyncHttpResponseHandler;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import cz.msebera.android.httpclient.Header;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

// Вывод расписания
public class MainActivity  extends AppCompatActivity {
    RecyclerView recyclerView;
    RaspisanyyAdapter raspisanyyAdapter;
    AsyncHttpClient client;
    Workbook workbook;
    List<String>  title,discriptions, imageUrl, one, two, tri, cet;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_raspisanie);
        String url = "https://github.com/VeronikaKoinova/Sosnika/raw/master/story%201%20(2).xls";
        //String url ="https://github.com/VeronikaKoinova/Diplomm/raw/main/story-1-_2_-12-1%20(1).xls";

        recyclerView = findViewById(R.id.listOfRaspisanie);
        progressBar = findViewById(R.id.progressBar);

        title = new ArrayList<>();
        discriptions = new ArrayList<>();
        imageUrl= new ArrayList<>();
        one = new ArrayList<>();
        two = new ArrayList<>();
        tri = new ArrayList<>();
        cet = new ArrayList<>();

        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        try {
            InputStream stream = getAssets().open("storr.xls");
            workbook = Workbook.getWorkbook(stream);
            Sheet sheet = workbook.getSheet(0);
            System.out.println(sheet);
            Log.d("MAIN", sheet.getRows() + "");
            for(int i=0; i < sheet.getRows() - 1; i++){
                Cell[] row = sheet.getRow(i);

                title.add(row[0].getContents());
                discriptions.add(row[1].getContents());
                imageUrl.add(row[2].getContents());
                one.add(row[3].getContents());
                two.add(row[4].getContents());
                tri.add(row[5].getContents());
            }

            showData();
            Log.d("TAG", "Успешно" +title);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showData() {
        raspisanyyAdapter = new RaspisanyyAdapter(this, title, discriptions, imageUrl, one, two, tri, cet);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(raspisanyyAdapter);
    }
}
//Qr-code
//    public class MainActivity extends AppCompatActivity {
//
//
//Button scan_dtn;
//TextView textView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        scan_dtn = findViewById(R.id.scanner);
//        textView =findViewById(R.id.text);
//
//        scan_dtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                IntentIntegrator intentIntegrator = new IntentIntegrator(MainActivity.this);
//                intentIntegrator.setOrientationLocked(true);
//                intentIntegrator.setPrompt("skaaan");
//                intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
//                intentIntegrator.initiateScan();
//            }
//        });
//
//            }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        IntentResult intentResult  = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
//        if(intentResult != null) {
//            String contents = intentResult.getContents();
//            if(contents != null){
//                textView.setText(intentResult.getContents());
//        }
//        else {
//                super.onActivityResult(requestCode, resultCode, data);
//        }
//        }
//
//    }
//public class MainActivity extends AppCompatActivity {
//    //Переход на другую стр
//    public void startActivity (View c) {
//        Intent intentt = new Intent(this, RaspisanieFile.class);
//        startActivity(intentt);
//    }
//    public void startNewActivity (View v) {
//    Intent intent = new Intent(this, Rasrisanie.class);
//    startActivity(intent);
//    }
//}