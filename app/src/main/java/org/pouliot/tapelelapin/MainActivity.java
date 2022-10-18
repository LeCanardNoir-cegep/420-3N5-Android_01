package org.pouliot.tapelelapin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.pouliot.tapelelapin.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    List<Button> buttons = new ArrayList<>();
    int positionLapin;
    int pafs = 0;
    int flops = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        this.buttons.add(binding.btn1);
        this.buttons.add(binding.btn2);
        this.buttons.add(binding.btn3);
        this.buttons.add(binding.btn4);

        this.bougeLapin();

        for (Button b: this.buttons) {
            b.setOnClickListener(view -> {
                reagirClick(view);
            });
        }

    }

    private void reagirClick(View view) {
        Button lapinCourant = this.buttons.get(positionLapin);
        if(view == lapinCourant){
            this.pafs ++;
            binding.pafs.setText(this.pafs + "pafs");
            Log.i("TapeLapin", "Bravo Lapin: " + this.pafs);
            bougeLapin();
        }else{
            this.flops ++;
            binding.flops.setText(this.flops + "flops");
            Log.i("TapeLapin", "HA! HA! moron,.... taupe: " + this.flops);
        }
    }

    private void bougeLapin() {

        for (Button b: this.buttons) {
            b.setText("Taupe");
        }

        Random random = new Random();
        this.positionLapin = random.nextInt(4);
        Button b = this.buttons.get(positionLapin);
        b.setText("Lapin");
    }
}