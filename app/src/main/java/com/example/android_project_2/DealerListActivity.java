package com.example.android_project_2;

import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DealerListActivity extends AppCompatActivity {

    private ListView dealerListView;
    private TextView dealerTitle;
    private Map<String, List<String>> dealerData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealer_list);

        dealerListView = findViewById(R.id.dealerListView);
        dealerTitle = findViewById(R.id.dealerTitle);

        // Get the selected car name from intent
        String carName = getIntent().getStringExtra("carName");
        dealerTitle.setText("Dealers for " + carName);

        // Initialize dealer data
        initializeDealers();

        // Get dealers for the selected car brand
        List<String> dealers = dealerData.getOrDefault(carName, new ArrayList<>());

        // Display dealers in ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dealers);
        dealerListView.setAdapter(adapter);
    }

    // Function to initialize car dealers data
    private void initializeDealers() {
        dealerData = new HashMap<>();

        dealerData.put("Mazda 3", List.of(
                "McGrath City Mazda - 3255 N. Cicero Ave, Chicago, IL 60641",
                "Oak Lawn Mazda - 6750 W 95th St, Oak Lawn, IL"
        ));

        dealerData.put("Honda Civic", List.of(
                "McGrath City Honda - 6720 W Grand Ave, Chicago, IL 60707",
                "Honda of Downtown Chicago - 1111 N Clark St, Chicago, IL 60610"
        ));

        dealerData.put("Toyota Corolla", List.of(
                "Toyota on Western - 6941 S Western Ave, Chicago, IL 60636",
                "Toyota of Lincoln Park - 1561 N Fremont St, Chicago, IL 60642"
        ));

        dealerData.put("BMW 3 Series", List.of(
                "Perillo BMW - 1035 N Clark St, Chicago, IL 60610",
                "Laurel BMW of Westmont - 430 E Ogden Ave, Westmont, IL"
        ));

        dealerData.put("Audi A4", List.of(
                "Fletcher Jones Audi - 1111 N Clark St, Chicago, IL 60610",
                "Audi Westmont - 276 E Ogden Ave, Westmont, IL"
        ));

        dealerData.put("Ford Mustang", List.of(
                "Golf Mill Ford - 9401 N Milwaukee Ave, Niles, IL 60714",
                "Metro Ford Sales - 6455 S Western Ave, Chicago, IL 60636"
        ));

        dealerData.put("Tesla Model 3", List.of(
                "Tesla Chicago - 1053 W Grand Ave, Chicago, IL 60642",
                "Tesla Schaumburg - 320 W Golf Rd, Schaumburg, IL"
        ));

        dealerData.put("Nissan Altima", List.of(
                "Berman Nissan of Chicago - 3456 N Kedzie Ave, Chicago, IL 60618",
                "Hawkinson Nissan - 5513 Miller Circle Dr, Matteson, IL 60443"
        ));

        dealerData.put("Mercedes C-Class", List.of(
                "Mercedes-Benz of Chicago - 1520 W North Ave, Chicago, IL 60642",
                "Loeber Motors Mercedes-Benz - 4255 W Touhy Ave, Lincolnwood, IL 60712"
        ));
    }

}
