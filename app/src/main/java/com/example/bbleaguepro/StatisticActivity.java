package com.example.bbleaguepro;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Pair;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;


public class StatisticActivity extends AppCompatActivity {
    PieChart pChart1;
    PieChart pChart2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistics);

        GroupLineChart();

    }


    public void GroupLineChart(){
        pChart1 = (PieChart) findViewById(R.id.pie_chart_1);
        pChart2 = (PieChart) findViewById(R.id.pie_chart_2);

        List<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(18.5f, "Green"));
        entries.add(new PieEntry(26.7f, "Yellow"));
        entries.add(new PieEntry(24.0f, "Red"));
        entries.add(new PieEntry(30.8f, "Blue"));
        PieDataSet set = new PieDataSet(entries, "Election Results");
        PieData data = new PieData(set);
        pChart1.setData(data);
        pChart1.invalidate(); // refresh

        List<PieEntry> entries2 = new ArrayList<>();
        entries2.add(new PieEntry(18.5f, "Green"));
        entries2.add(new PieEntry(26.7f, "Yellow"));
        entries2.add(new PieEntry(24.0f, "Red"));
        entries2.add(new PieEntry(30.8f, "Blue"));
        PieDataSet set2 = new PieDataSet(entries2, "Election Results");
        PieData data2 = new PieData(set2);
        pChart2.setData(data2);
        pChart2.invalidate(); // refresh








    }
}
