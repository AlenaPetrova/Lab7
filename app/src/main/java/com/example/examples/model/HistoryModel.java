package com.example.examples.model;

import com.example.examples.view.historyItem;

import java.util.ArrayList;
import java.util.Collection;

public class HistoryModel {
    private static ArrayList<historyItem> historyList=new ArrayList();
    public static ArrayList<historyItem> getList(){
        return historyList;

    }
    public static void push(historyItem e){
        historyList.add(e);
    }
    public static void addAll(Collection<historyItem>e){
        historyList.addAll(e);
    }
}
