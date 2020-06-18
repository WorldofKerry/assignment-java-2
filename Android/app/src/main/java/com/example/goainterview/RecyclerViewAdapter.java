package com.example.goainterview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    Context mContext;
    int mImages[];
    OnItemClickListener mListener;

    public RecyclerViewAdapter (Context context, int images[]) {
        mContext = context;
        mImages = images;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.item_image, parent, false);
        return new MyViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mImageView.setImageResource(mImages[position*2]);
        holder.mImageView2.setImageResource(mImages[position*2+1]);
    }

    @Override
    public int getItemCount() {
        // Two images per recyclerView item
        return mImages.length/2;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        ImageView mImageView2;

        public MyViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_recycler_view);
            mImageView2 = itemView.findViewById(R.id.image_recycler_view_2);

            // On click listener for when images are selected
            mImageView.setOnClickListener(new View.OnClickListener()      {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onImageViewLeftClick(position);
                        }
                    }
                }
            });

            mImageView2.setOnClickListener(new View.OnClickListener()      {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onImageViewRightClick(position);
                        }
                    }
                }
            });

            };

        }

    public interface OnItemClickListener {
        void onImageViewLeftClick(int position);
        void onImageViewRightClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

}
