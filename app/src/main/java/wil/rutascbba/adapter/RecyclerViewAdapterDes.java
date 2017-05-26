package wil.rutascbba.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import wil.rutascbba.R;
import wil.rutascbba.otros.CircularImageView;

/**
 * Created by william on 11/04/2017.
 */

public class RecyclerViewAdapterDes extends RecyclerView.Adapter<RecyclerViewAdapterDes.CustomViewHolder>{
    private List<ItemDes> itemDes;
    private Context mContext;

    public RecyclerViewAdapterDes(Context context, List<ItemDes> itemDes) {
        this.itemDes = itemDes;
        this.mContext = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item_des, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        ItemDes item = itemDes.get(i);
        customViewHolder.textViewDes.setText(item.getRuta());
    }

    @Override
    public int getItemCount() {
        return (null != itemDes ? itemDes.size() : 0);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView textViewDes;

        public CustomViewHolder(View view) {
            super(view);
            this.textViewDes = (TextView) view.findViewById(R.id.textView_item_des);

        }
    }
}