package com.mxin.android.film_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String[] filmName = new String []{"寒战2","x战警-天启","微微一笑","aaa","bbb","ccc","ddd"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layout_film = findViewById(R.id.layout_film);


        for (int i = 0 ;i < filmName.length;i++){
            View filmView = getLayoutInflater().inflate(R.layout.film_item,null);

            ImageView ivFilmIcon = findViewById(R.id.iv_filmIcon);
            TextView tvFilmName = findViewById(R.id.tv_filmName);
            TextView tvFilmCount = findViewById(R.id.tv_filmCount);

           /* ivFilmIcon.setImageResource(R.mipmap.ic_launcher);

            tvFilmName.setText(filmName[i]);*/
            layout_film.addView(filmView);

        }



    }
}
