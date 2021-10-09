package com.example.freqmax;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText txtName;
    EditText txtAge;
    Button button;
    ListView listAthletes;
    List<Athlete> athletes = new ArrayList<>();
    AthleteAdapter adapter;

    View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            handleClickCalculateAdd(v);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.athleteNameInput);
        txtAge = findViewById(R.id.athleteAgeInput);
        button = findViewById(R.id.button);
        button.setOnClickListener(buttonClickListener);
        listAthletes = findViewById(R.id.listAthletes);
        adapter = new AthleteAdapter(athletes, getBaseContext());
        listAthletes.setAdapter(adapter);

    }

    public void handleClickCalculateAdd(View v){

        boolean aux = true;

        Athlete a = new Athlete();
        a.setName(txtName.getText().toString());
        a.setAge(txtAge.getText().toString());

        if(athletes.size() == 0){
            athletes.add(a);
        } else if (athletes.size() > 0) {
            for(int i = 0; i < athletes.size(); i++){
                if(Integer.parseInt(a.getAge()) < Integer.parseInt(athletes.get(i).getAge())){
                    athletes.add(i,a);
                    aux = false;
                    break;
                }
            }
            if (aux) {
                athletes.add(a);
            }
        }

        adapter.notifyDataSetChanged();

        txtName.setText("");
        txtAge.setText("");

    }

}