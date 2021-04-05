package com.example.examples.view;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.examples.R;
import com.example.examples.model.History;
import com.example.examples.viewmodel.FragmentsProcessor;
import com.example.examples.viewmodel.ProcessDB;

public class FragmentOne extends Fragment {
    private EditText objX1;
    private EditText objX2;
    private EditText objY1;
    private EditText objY2;
    private TextView resText;
    private Button buttonRes;
    private int i;
    public String resultText;
    private Button button;
    View view;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }
    

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_one, container, false);
        objX1=view.findViewById(R.id.inputX1);
        objX2=view.findViewById(R.id.inputX2);
        objY1=view.findViewById(R.id.inputY1);
        objY2=view.findViewById(R.id.inputY2);
        resText=view.findViewById(R.id.textResult);
        buttonRes=view.findViewById(R.id.buttonAccess);
        if(resultText!=null){
            resText.setText(resultText);
        }





        button=view.findViewById(R.id.buttonAccess);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        OnClickRes();

                    }
                }
        );
        return view;
    }


    public void OnClickRes(){
        Double x1=Double.parseDouble(objX1.getText().toString());
        Double x2=Double.parseDouble(objX2.getText().toString());
        Double y1=Double.parseDouble(objY2.getText().toString());
        Double y2=Double.parseDouble(objY1.getText().toString());
        Double res= FragmentsProcessor.getLength(x1,x2,y1,x2);
        resultText=Double.toString(res);
        ProcessDB a=new ProcessDB(getActivity());
        History history = new History(1,resultText);


        a.insert(history);
        resText.setText(resultText);
        MainActivity parent = (MainActivity)getActivity();


        parent.addHistory(new historyItem("Результат 1 фрагмента:"+resultText));


        Toast.makeText(getActivity(), resultText, Toast.LENGTH_SHORT).show();




    }




}