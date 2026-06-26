package ru.solar.marketapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private final List<Item> itemList;
    public ItemClickListener clickListener;
    public void setClickListener(ItemClickListener myListener){
        this.clickListener = myListener;
    }


    public MyAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item item = itemList.get(position);

        holder.text_title.setText(item.getItemName());
        holder.text_description.setText(item.getItemDesc());
        holder.image_item.setImageResource(item.getItemImg());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView image_item;
        TextView text_title,text_description;
       public MyViewHolder(@NonNull View itemView) {
           super(itemView);
           image_item = itemView.findViewById(R.id.image_item);
           text_title = itemView.findViewById(R.id.text_title);
           text_description = itemView.findViewById(R.id.text_description);

           itemView.setOnClickListener(this);
       }

        @Override
        public void onClick(View v) {
            if(clickListener != null){
                clickListener.onClick(v,getBindingAdapterPosition());
            }
        }
    }
}
