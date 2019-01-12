package com.example.osaat.linechart;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;

public class CustomMarkerView extends MarkerView {

    private final TextView tvContent;

    public CustomMarkerView (@NonNull Context context,
                             @LayoutRes int layoutResource) {
        super(context, layoutResource);
        tvContent = findViewById(R.id.tvContent);
    }

    @Override
    public void refreshContent(@NonNull Entry e,
                               @NonNull Highlight highlight) {
        tvContent.setText("" + e.getY());
        super.refreshContent(e, highlight);
    }
}
