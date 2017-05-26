package wil.rutascbba.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import wil.rutascbba.otros.CircularImageView;
import wil.rutascbba.R;

/**
 * Created by william on 11/04/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder>{
    private List<ItemRecyclerView> itemRecyclerViews;
    private Context mContext;

    public RecyclerViewAdapter(Context context, List<ItemRecyclerView> itemRecyclerViews) {
        this.itemRecyclerViews = itemRecyclerViews;
        this.mContext = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        ItemRecyclerView recyclerView = itemRecyclerViews.get(i);

        customViewHolder.textViewTit.setText(recyclerView.getTitulo());
        customViewHolder.textViewSindi.setText(recyclerView.getSindi());
        customViewHolder.imageView.setImageDrawable(recyclerView.getImg());
    }

    @Override
    public int getItemCount() {
        return (null != itemRecyclerViews ? itemRecyclerViews.size() : 0);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView textViewTit;
        protected TextView textViewSindi;
        protected CircularImageView imageView;


        public CustomViewHolder(View view) {
            super(view);
            this.textViewTit = (TextView) view.findViewById(R.id.textView_titulo);
            this.textViewSindi = (TextView) view.findViewById(R.id.textView_sindi);
            this.imageView = (CircularImageView) view.findViewById(R.id.img);
        }
    }
}