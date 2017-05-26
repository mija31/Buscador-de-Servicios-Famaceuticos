package wil.rutascbba.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import wil.rutascbba.R;
import wil.rutascbba.adapter.ItemDes;
import wil.rutascbba.adapter.RecyclerViewAdapterDes;


public class FragmentDesVuelta extends Fragment {
    List<ItemDes>  list = new ArrayList<>();
    Toolbar mToolbar;

    public FragmentDesVuelta() {
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_des_vuelta, container, false);

        mToolbar = (Toolbar) getActivity().findViewById(R.id.toolbar_des);
        createItemList();
        initRecyclerView(view);
        return view;
    }

    private void initRecyclerView(View v) {
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView_vuelta);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerViewAdapterDes recyclerAdapter = new RecyclerViewAdapterDes(getActivity(),list);
        recyclerView.setAdapter(recyclerAdapter);
    }

    private void createItemList() {
        list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            list.add(new ItemDes("RUTAS VUELTA"+i));

        }
    }
}
