package com.example.freqmax;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class AthleteAdapter extends BaseAdapter {

    LayoutInflater inflater;
    List<Athlete> athletes;

    public AthleteAdapter(List<Athlete> athletes, Context ctx){
        this.athletes = athletes;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount(){
        return athletes.size();
    }

    @Override
    public Object getItem(int position) {
        return athletes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = inflater.inflate(R.layout.athlete_list, null);

        TextView txtName = v.findViewById(R.id.athleteName);
        TextView txtFCM = v.findViewById(R.id.FCM);

        Athlete a = athletes.get(position);
        txtName.setText(a.getName());
        txtFCM.setText(a.getFCM());

        return v;

    }

}