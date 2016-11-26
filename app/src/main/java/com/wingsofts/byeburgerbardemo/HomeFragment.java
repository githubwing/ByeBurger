package com.wingsofts.byeburgerbardemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by wing on 11/4/16.
 */

public class HomeFragment extends Fragment {
  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View v = View.inflate(getContext(), R.layout.fragment_home, null);
    RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
    recyclerView.setAdapter(new Adapter());
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    return v;
  }

  public static HomeFragment newInstance() {
    Bundle args = new Bundle();
    HomeFragment fragment = new HomeFragment();
    fragment.setArguments(args);
    return fragment;
  }

  class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      return new ViewHolder(View.inflate(parent.getContext(), R.layout.item_main, null));
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override public int getItemCount() {
      return 20;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
      TextView textView;

      public ViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.text);
      }
    }
  }
}
