package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication1.model.AdminRaspisanie;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication1.adapter.RaspisanyyAdapter;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.FileAsyncHttpResponseHandler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import cz.msebera.android.httpclient.Header;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;


public class RaspisanieFile extends AppCompatActivity {
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
        //String url = "https://github.com/VeronikaKoinova/Sosnika/raw/master/tetx.xls";
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

        client = new AsyncHttpClient();
        progressBar.setVisibility(View.VISIBLE);
        client.get(url, new FileAsyncHttpResponseHandler(this ) {
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, File file) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(RaspisanieFile.this, "Download file", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onSuccess(int statusCode, Header[] headers, File file) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(RaspisanieFile.this, "File Downaleded", Toast.LENGTH_SHORT).show();
                WorkbookSettings ws =  new WorkbookSettings();
                ws.setGCDisabled(true);
                if (file != null){
                    try {
                        workbook = workbook.getWorkbook(file);
                        Sheet sheet = workbook.getSheet(0);
                        for(int i=0; i < sheet.getRows(); i++){
                            Cell[] row = sheet.getRow(i);
                            title.add(row[0].getContents());
                            discriptions.add(row[1].getContents());
                            imageUrl.add(row[2].getContents());
                            one.add(row[3].getContents());
                            two.add(row[4].getContents());
                            tri.add(row[5].getContents());
                            cet.add(row[6].getContents());

                        }

                        showData();
                        Log.d("TAG", "Успешно" +title);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (BiffException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        });

    }

    private void showData() {
        raspisanyyAdapter = new RaspisanyyAdapter(this, title, discriptions, imageUrl, one, two, tri, cet);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(raspisanyyAdapter);
    }
}