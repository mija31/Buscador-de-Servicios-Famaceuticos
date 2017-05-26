package wil.rutascbba.fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import wil.rutascbba.activities.MapsActivity;
import wil.rutascbba.adapter.ItemRecyclerView;
import wil.rutascbba.R;
import wil.rutascbba.adapter.RecyclerViewAdapter;
import wil.rutascbba.otros.ItemClickSupport;

public class FragmentMini extends Fragment {

    List<ItemRecyclerView>  list = new ArrayList<>();;
    Toolbar mToolbar;
    public FragmentMini() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mini, container, false);
        mToolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        createItemList();
        initRecyclerView(view);
        return view;
    }
    private void initRecyclerView(View v) {
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getActivity(),list);
        recyclerView.setAdapter(recyclerAdapter);
        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {

                TextView textView = (TextView) v.findViewById(R.id.textView_titulo);
                String titulo = textView.getText().toString();
                Intent i = new Intent(getContext(), MapsActivity.class);
                i.putExtra("titulo",titulo);
                startActivity(i);
            }
        });
    }

    private void createItemList() {
        list = new ArrayList<>();
        for (int i =0 ; i < 300; i++){
            list.add(new ItemRecyclerView("LINEA"+i+"","SINDICATO"+i, ContextCompat.getDrawable(getContext(),R.drawable.ic_delete_white_36dp)));

        }


    }
}
