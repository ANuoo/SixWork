package com.example.anuo.sixwork;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutFragment extends Fragment {
    View view;
    ImageView imageView;
    TextView textView;
    private int imageId;
    private String title;

    public void SetView(int imageId, String title) {
        this.title = title;
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frangment_item, container, false);
        imageView = view.findViewById(R.id.img_fragment);
        textView = view.findViewById(R.id.txt_fragment);
        imageView.setImageResource(imageId);
        textView.setText(title);
        return view;
    }
}
