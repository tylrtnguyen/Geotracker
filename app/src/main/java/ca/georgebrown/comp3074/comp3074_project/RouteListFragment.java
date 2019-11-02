package ca.georgebrown.comp3074.comp3074_project;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class RouteListFragment extends ListFragment {
    static interface RouteListListener{
        void itemClicked(long id);
    }
    private RouteListListener listener;

    public RouteListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String[] names = new String[Route.routes.length];
        for(int i = 0; i< names.length; i++){
            names[i] = "From: "+Route.routes[i].getStart() + ". To: "+Route.routes[i].getStop();
        }
        ArrayAdapter<String>arrayAdapter = new ArrayAdapter<String>(inflater.getContext(),
                android.R.layout.simple_list_item_1, names);
        setListAdapter(arrayAdapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (RouteListListener) context;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if(listener !=null){
            listener.itemClicked(id);
        }
    }
}
