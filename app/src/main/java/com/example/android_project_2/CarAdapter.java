package com.example.android_project_2;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class CarAdapter  extends BaseAdapter {

    private Context context;
    private List<Car> carList;
    private LayoutInflater inflater;

    public CarAdapter(Context context, List<Car> carList) {
        this.context = context;
        this.carList = carList;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return carList.size();
    }

    @Override
    public Object getItem(int position) {
        return carList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.grid_item, parent, false);
        }

        ImageView carImage = convertView.findViewById(R.id.carImage);
        TextView carName = convertView.findViewById(R.id.carName);

        Car car = carList.get(position);
        carImage.setImageResource(car.getImageResId());
        carName.setText(car.getName());

        // Detect screen orientation
        int orientation = context.getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            carImage.getLayoutParams().width = 500;  // Increase image size
            carImage.getLayoutParams().height = 600;
            carImage.requestLayout(); // Force UI update

            // Increase text size and padding in portrait
            carName.setTextSize(16);  // Bigger text
            carName.setPadding(0, 8, 0, 8); // More space around text
        }

        return convertView;
    }

}
