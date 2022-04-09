package com.example.dogappv3.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dogappv3.R;
import com.example.dogappv3.model.DogBreed;
import com.example.dogappv3.viewmodel.DogAdapter;
import com.example.dogappv3.viewmodel.DogsApiService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ListFragment extends Fragment {
    private DogsApiService apiService;
    private RecyclerView rvDogs;
    private ArrayList<DogBreed> dogBreeds;
    private DogAdapter dogAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvDogs = view.findViewById(R.id.rv_dogs);
        dogBreeds = new ArrayList<DogBreed>();
        dogAdapter = new DogAdapter(dogBreeds);
        apiService = new DogsApiService();

        rvDogs.setAdapter(dogAdapter);
        rvDogs.setLayoutManager(new GridLayoutManager(this.getContext(), 2));

        apiService.getDogs()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<DogBreed>>() {
                    @Override
                    public void onSuccess(@io.reactivex.rxjava3.annotations.NonNull List<DogBreed> dogBreeds1) {
                        for (DogBreed dog : dogBreeds1) {
                            Log.d("Debug", dog.getName());
                            dogBreeds.add(dog);
                            dogAdapter.notifyDataSetChanged();
                        }

                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        Log.d("DEBUG1", e.getMessage());
                    }
                });
    }
}