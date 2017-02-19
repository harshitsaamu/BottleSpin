package com.hgc.bottlespin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class select_truth_dare extends Fragment {
    ImageView truth,dare;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_select_truth_dare, container, false);
        truth=(ImageView)layout.findViewById(R.id.id_truth);
        dare=(ImageView)layout.findViewById(R.id.id_dare);
        truth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
show_truth();
            }
        });
        dare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           show_dare();
            }
        });
        return layout;
    }
    public void  show_dare()
    {
        Toast.makeText(getActivity(), "Dare", Toast.LENGTH_SHORT).show();
    }
    public void show_truth()
    {
        Toast.makeText(getActivity(), "Truth", Toast.LENGTH_SHORT).show();
    }
}
