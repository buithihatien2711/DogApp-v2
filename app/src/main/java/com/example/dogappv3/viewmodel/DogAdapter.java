package com.example.dogappv3.viewmodel;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dogappv3.R;
import com.example.dogappv3.model.DogBreed;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.ViewHolder> {

    private List<DogBreed> dogBreeds;
    private Context context;


    public DogAdapter(Context context) {
        this.context = context;
    }

    public DogAdapter(List<DogBreed> dogBreeds) {
        this.dogBreeds = dogBreeds;
    }

    public DogAdapter(List<DogBreed> dogBreeds, Context context) {
        this.dogBreeds = dogBreeds;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_dog, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtName.setText(dogBreeds.get(position).getName());
        holder.txtBredFor.setText(dogBreeds.get(position).getBredFor());

        //Using Glide library to display the image
//        Glide.with(context)
//                .load(dogBreeds.get(position).getUrl())
//                .into(holder.ivAvatar);

        //Using Picasso library to display the image
        Picasso.get().load(dogBreeds.get(position).getUrl())
                .into((holder.ivAvatar));
    }

    @Override
    public int getItemCount() {
        if(dogBreeds != null){
            return dogBreeds.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtName;
        public ImageView ivAvatar;
        public TextView txtBredFor;
        public ViewHolder(View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txt_name);
            ivAvatar = itemView.findViewById(R.id.iv_avatar);
            txtBredFor = itemView.findViewById(R.id.txt_bred_for);
            itemView.setTag(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DogBreed dog = dogBreeds.get(getAdapterPosition());
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("dog", dog);
                    Navigation.findNavController(view).navigate(R.id.detailsFragment, bundle);
                }
            });
        }

    }
}

