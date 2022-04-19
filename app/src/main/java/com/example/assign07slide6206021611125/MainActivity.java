package com.example.assign07slide6206021611125;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements OnClickListener{
    ImageView show;
    int res_image[] = {R.drawable.img, R.drawable.img_1, R.drawable.img_2, R.drawable.img_3,
                        R.drawable.img_4, R.drawable.img_5, R.drawable.img_6,R.drawable.img_7} ;
    Button btnStart, btnStop;
    Handler mHandler = new Handler( Looper.myLooper());
    int n = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show = (ImageView) findViewById(R.id.show);
        show.setImageResource(res_image[n]);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(this);
        btnStop = (Button) findViewById(R.id.btnStop);
        btnStop.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnStart){
            n = 0;
            show.setImageResource(res_image[n]);
            mHandler.postDelayed( mUpdateTimeTask , 700);
        }
        else if (id == R.id.btnStop){
            mHandler.removeCallbacks(mUpdateTimeTask);
        }
    }

    public Runnable mUpdateTimeTask = new Runnable () {
        public void run() {
            if (n < 7) {
                n ++;
                show.setImageResource(res_image[n]);
                mHandler.postDelayed(this, 700);
            }
            else {
                n = 0;
                show.setImageResource(res_image[n]);
                mHandler.postDelayed( mUpdateTimeTask , 700);
            }

        }
    };
}