package com.example.android_project_2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
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

        // Handle short click (open new activity)
        convertView.setOnClickListener(v -> {
            Intent intent = new Intent(context, CarDetailActivity.class);
            intent.putExtra("imageResId", car.getImageResId());
            intent.putExtra("carUrl", car.getManufacturerUrl());
            context.startActivity(intent);
        });

        // Long click - Show context menu
        convertView.setOnLongClickListener(v -> {
            showContextMenu(car);
            return true;
        });

        return convertView;

        // Function to show a context menu dialog

    }

    private void showContextMenu(Car car) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Options for " + car.getName())
                .setItems(new CharSequence[]{"View Full Image", "Open Manufacturer’s Website", "Show Dealers in Chicago"},
                        (dialog, which) -> {
                            switch (which) {
                                case 0: // View Full Image
                                    Intent imageIntent = new Intent(context, CarDetailActivity.class);
                                    imageIntent.putExtra("imageResId", car.getImageResId());
                                    imageIntent.putExtra("carUrl", car.getManufacturerUrl());
                                    context.startActivity(imageIntent);
                                    break;

                                case 1: // Open Manufacturer’s Website
                                    Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(car.getManufacturerUrl()));
                                    context.startActivity(webIntent);
                                    break;

                                case 2: // Show Dealers in Chicago
                                    Intent dealerIntent = new Intent(context, DealerListActivity.class);
                                    dealerIntent.putExtra("carName", car.getName());
                                    context.startActivity(dealerIntent);
                                    break;
                            }
                        });

        builder.show();
    }

}
