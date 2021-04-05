package com.example.examples.viewmodel;

import com.example.examples.view.historyItem;
import com.example.examples.model.HistoryModel;

import java.util.ArrayList;
import java.util.Collection;

public class HistoryProcessor {
    public static ArrayList<historyItem> getList(){
        return HistoryModel.getList();
    }
    public static void push(historyItem e){
        HistoryModel.push(e);
    }
    public static void addAll(Collection<historyItem>e){
        HistoryModel.addAll(e);
    }
}
