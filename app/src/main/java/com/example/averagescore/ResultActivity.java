package com.example.averagescore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class ResultActivity extends AppCompatActivity {
    private TextView tvResult;

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.result_activity);
        tvResult = (TextView)findViewById(R.id.textView3);
        showResults();
    }
    private void showResults(){
        NumberFormat nf = NumberFormat.getInstance();
        Bundle bundle = getIntent().getExtras();
        int Programming = bundle.getInt("Programming");
        int DataStructure = bundle.getInt("DataStructure");
        int Alogrithm = bundle.getInt("Alogrithm");
        int sum = Programming + DataStructure + Alogrithm ;
        double average = sum / 3.0;
        String Text = "Programming =" + Programming +
                "\nDataStructure =" + DataStructure +
                "\nAlogrithm =" + Alogrithm +
                "\nsum =" + sum +
                "\naverage" + nf.format(average);
        tvResult.setText(Text);
    }
    public void onBackClick(View view){ finish();}
}
