package com.example.osaat.linechart;

import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;

public class DataProvider {
    public ArrayList<Entry> getYValues() {
        final ArrayList<Entry> lineEntries = new ArrayList<>();
        lineEntries.add(new Entry(0, 50));
        lineEntries.add(new Entry(1, 40));
        lineEntries.add(new Entry(2, 43));
        lineEntries.add(new Entry(3, 42));
        lineEntries.add(new Entry(4, 41));
        lineEntries.add(new Entry(5, 39));
        lineEntries.add(new Entry(6, 34));
        lineEntries.add(new Entry(7, 39));
        lineEntries.add(new Entry(8, 42));
        lineEntries.add(new Entry(9, 43));
        lineEntries.add(new Entry(10, 44));
        lineEntries.add(new Entry(11, 45));
        lineEntries.add(new Entry(12, 46));
        lineEntries.add(new Entry(13, 39));
        lineEntries.add(new Entry(14, 38));
        lineEntries.add(new Entry(15, 44));
        lineEntries.add(new Entry(16, 43));
        lineEntries.add(new Entry(17, 42));
        lineEntries.add(new Entry(18, 41));
        lineEntries.add(new Entry(19, 39));
        lineEntries.add(new Entry(20, 38));
        lineEntries.add(new Entry(21, 40));
        lineEntries.add(new Entry(22, 43));
        lineEntries.add(new Entry(23, 45));
        lineEntries.add(new Entry(24, 39));
        lineEntries.add(new Entry(25, 34));
        lineEntries.add(new Entry(26, 34));
        lineEntries.add(new Entry(27, 23));
        lineEntries.add(new Entry(28, 22));
        lineEntries.add(new Entry(29, 20));

        return lineEntries;
    }

    public ArrayList<Entry> getDeviationValues() {
        final ArrayList<Entry> lineEntries = new ArrayList<>();
        lineEntries.add(new Entry(0, 1));
        lineEntries.add(new Entry(1, 2));
        lineEntries.add(new Entry(2, 0));
        lineEntries.add(new Entry(3, 4));
        lineEntries.add(new Entry(4, 5));
        lineEntries.add(new Entry(5, 6));
        lineEntries.add(new Entry(6, 2));
        lineEntries.add(new Entry(7, -1));
        lineEntries.add(new Entry(8, -3));
        lineEntries.add(new Entry(9, -4));
        lineEntries.add(new Entry(10, -2));
        lineEntries.add(new Entry(11, 3));
        lineEntries.add(new Entry(12, 4));
        lineEntries.add(new Entry(13, 2));
        lineEntries.add(new Entry(14, -1));
        lineEntries.add(new Entry(15, 0));
        lineEntries.add(new Entry(16, 1));
        lineEntries.add(new Entry(17, 3));
        lineEntries.add(new Entry(18, 4));
        lineEntries.add(new Entry(19, 2));
        lineEntries.add(new Entry(20, -1));
        lineEntries.add(new Entry(21, -2));
        lineEntries.add(new Entry(22, -4));
        lineEntries.add(new Entry(23, -2));
        lineEntries.add(new Entry(24, -1));
        lineEntries.add(new Entry(25, -4));
        lineEntries.add(new Entry(26, 2));
        lineEntries.add(new Entry(27, 2));
        lineEntries.add(new Entry(28, 1));
        lineEntries.add(new Entry(29, 1));

        return lineEntries;
    }
}
