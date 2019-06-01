package com.example.averagescore;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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
        alert(average);
    }

    private void alert(double average){
        String message = new String();
        String tilte = new String();
        int pic = 0;
        if(average==100){
           message = "100";
           tilte = "pass";
           pic = R.drawable.circle;
        }else if(average<=99 && average>=80){
            message = "congratulation";
            tilte = "pass";
            pic = R.drawable.square;
        }else if(average<=79 && average>=60){
            message = "dangerous";
            tilte = "pass";
            pic = R.drawable.triangle;
        }else{
            message = "sorry";
            tilte = "fail";
            pic = R.drawable.fail;
        }


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(message);
            builder.setTitle(tilte);
            builder.setIcon(pic);
            builder.setPositiveButton("OK",null);
            builder.setNegativeButton("Cancel",null);
            builder.setNeutralButton("Nothing",null);
            builder.show();
    }
    public void onBackClick(View view){ finish();}
}
