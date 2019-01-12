package com.example.osaat.linechart;

import android.graphics.Color;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.WindowManager;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnChartGestureListener, OnChartValueSelectedListener {

    @NonNull
    private LineChart lineChart;
    @NonNull
    private final DataProvider dataProvider = new DataProvider();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        initChart();
        renderDataSets();
        renderLegend();
        renderXAxis();
        renderYAxis();
        renderMarkerView();
    }

    private void initChart() {
        lineChart = findViewById(R.id.chart);
        lineChart.setTouchEnabled(true);
        lineChart.setOnChartGestureListener(this);
        lineChart.setOnChartValueSelectedListener(this);
        lineChart.setHighlightPerTapEnabled(true);
        lineChart.setDoubleTapToZoomEnabled(false);
    }

    private void renderDataSets() {
        final LineDataSet lineYDataSet = createDataSetLine(dataProvider.getYValues(),"Line1", R.color.green);
        final LineDataSet lineDeviationDataSet = createDataSetLine(dataProvider.getDeviationValues(),"Line2", R.color.red);

        final ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineYDataSet);
        dataSets.add(lineDeviationDataSet);

        final LineData data = new LineData(dataSets);

        lineChart.setData(data);
        lineChart.animateY(1000);
        lineChart.getDescription().setText("Line Comparison Chart");
    }

    private void renderLegend() {
        final ArrayList<LegendEntry> legendEntries = new ArrayList<>();
        legendEntries.add(new LegendEntry("Deviation", Legend.LegendForm.SQUARE, 8f, 8f, null, Color.RED));
        legendEntries.add(new LegendEntry("Y", Legend.LegendForm.SQUARE, 8f, 8f, null, Color.GREEN));

        final Legend legend = lineChart.getLegend();
        legend.setFormSize(10f);
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setTextSize(12f);
        legend.setTextColor(Color.BLACK);
        legend.setXEntrySpace(5f);
        legend.setYEntrySpace(5f);
        legend.setCustom(legendEntries);
    }

    private void renderXAxis() {
        final XAxis xAxis = lineChart.getXAxis();
        xAxis.setGranularity(1f);
        xAxis.setGranularityEnabled(true);
        xAxis.setCenterAxisLabels(false);
        xAxis.setDrawGridLines(true);
        xAxis.setTextColor(Color.BLACK);
        xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);
    }

    private void renderYAxis() {
        final YAxis leftAxis = lineChart.getAxisLeft();
        leftAxis.setTextColor(Color.BLACK);

        final YAxis rightAxis = lineChart.getAxisRight();
        rightAxis.setTextColor(Color.BLACK);
    }

    private void renderMarkerView() {
        final CustomMarkerView mv = new CustomMarkerView(this, R.layout.tv_marker);
        mv.setChartView(lineChart);
        lineChart.setMarker(mv);
    }

    private LineDataSet createDataSetLine(@NonNull final List<Entry> entryList,
                                          @NonNull final String label,
                                          @ColorRes final int colour) {
        final LineDataSet lineDataSet = new LineDataSet(entryList, label);

        lineDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
        lineDataSet.setColors(getColor(colour));
        lineDataSet.setLineWidth(3);
        lineDataSet.setHighlightEnabled(true);
        lineDataSet.setDrawHighlightIndicators(true);
        lineDataSet.setHighLightColor(Color.RED);
        lineDataSet.setValueTextColor(getColor(R.color.colorPrimaryDark));
        lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);

        return lineDataSet;
    }

    @Override
    public void onChartGestureStart(@NonNull MotionEvent me, @NonNull ChartTouchListener.ChartGesture lastPerformedGesture) {
        Log.i("Gesture", "START, x: " + me.getX() + ", y: " + me.getY());
    }

    @Override
    public void onChartGestureEnd(@NonNull MotionEvent me, @NonNull ChartTouchListener.ChartGesture lastPerformedGesture) {
        Log.i("Gesture", "END, lastGesture: " + lastPerformedGesture);

        if (lastPerformedGesture != ChartTouchListener.ChartGesture.SINGLE_TAP) {
            lineChart.highlightValues(null);
        }
    }

    @Override
    public void onChartLongPressed(@NonNull MotionEvent me) {
        Log.i("LongPress", "Chart longpressed.");
    }

    @Override
    public void onChartDoubleTapped(@NonNull MotionEvent me) {
        Log.i("DoubleTap", "Chart double-tapped.");
    }

    @Override
    public void onChartSingleTapped(@NonNull MotionEvent me) {
        Log.i("SingleTap", "Chart single-tapped.");
    }

    @Override
    public void onChartFling(@NonNull MotionEvent me1, @NonNull MotionEvent me2, float velocityX, float velocityY) {
        Log.i("Fling", "Chart flinged. VeloX: " + velocityX + ", VeloY: " + velocityY);
    }

    @Override
    public void onChartScale(@NonNull MotionEvent me, float scaleX, float scaleY) {
        Log.i("Scale / Zoom", "ScaleX: " + scaleX + ", ScaleY: " + scaleY);
    }

    @Override
    public void onChartTranslate(@NonNull MotionEvent me, float dX, float dY) {
        Log.i("Translate / Move", "dX: " + dX + ", dY: " + dY);
    }

    @Override
    public void onValueSelected(@NonNull Entry e, @NonNull Highlight h) {
        final Highlight highlight[] = new Highlight[lineChart.getData().getDataSets().size()];
        for (int j = 0; j < lineChart.getData().getDataSets().size(); j++) {
            final IDataSet iDataSet = lineChart.getData().getDataSets().get(j);
            for (int i = 0; i < ((LineDataSet) iDataSet).getValues().size(); i++) {
                if (((LineDataSet) iDataSet).getValues().get(i).getX() == e.getX()) {
                    highlight[j] = new Highlight(e.getX(), e.getY(), j);
                }
            }
        }
        lineChart.highlightValues(highlight);
    }

    @Override
    public void onNothingSelected() {
        //unused
    }

}

