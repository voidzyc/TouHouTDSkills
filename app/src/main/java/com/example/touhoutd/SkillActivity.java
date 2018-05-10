package com.example.touhoutd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.litepal.crud.DataSupport;

import java.util.List;

public class SkillActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "SkillActivity";

    private TextView nameView;
    private TextView skillview;
    private ImageView imageView;
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skill_layout);

        Intent intent = getIntent();
        String name = intent.getStringExtra("extra_name");

        List<Avatar> avatars =
                DataSupport.where("name == ?", name).find(Avatar.class);
        final Avatar avatar = avatars.get(0);

        nameView = (TextView) findViewById(R.id.name_view);
        nameView.setText(name);
        skillview = (TextView) findViewById(R.id.skill_view);
        skillview.setText(avatar.getSkillName1() + "\n" + avatar.getSkillDes1());
        skillview.setMovementMethod(new ScrollingMovementMethod());

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        button1.setText(avatar.getSkillName1());
        button2.setText(avatar.getSkillName2());
        button3.setText(avatar.getSkillName3());
        button4.setText(avatar.getSkillName4());
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

        imageView = (ImageView) findViewById(R.id.image_view);
        imageView.setImageResource(avatar.getImageId());
        float itemWidth = (ScreenUtils.getScreenWidth(this) - 15 * 2) / 2;
        float itemHeight = itemWidth * 358 / 256;
        RelativeLayout.LayoutParams layoutParams =
                (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.height = (int) itemHeight;
        imageView.setLayoutParams(layoutParams);

        imageView = findViewById(R.id.pyts_icon);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skillview.setText(avatar.getPyts());
            }
        });

    }

    @Override
    public void onClick(View v) {

        Intent intent = getIntent();
        String name = intent.getStringExtra("extra_name");

        List<Avatar> avatars =
                DataSupport.where("name == ?", name).find(Avatar.class);
        Avatar avatar = avatars.get(0);

        skillview = (TextView) findViewById(R.id.skill_view);
        switch (v.getId()) {
            case R.id.button1:
                skillview.setText(avatar.getSkillName1() + "\n" + avatar.getSkillDes1());
                break;
            case R.id.button2:
                skillview.setText(avatar.getSkillName2() + "\n" + avatar.getSkillDes2());
                break;
            case R.id.button3:
                skillview.setText(avatar.getSkillName3() + "\n" + avatar.getSkillDes3());
                break;
            case R.id.button4:
                skillview.setText(avatar.getSkillName4() + "\n" + avatar.getSkillDes4());
                break;
            default:
                break;
        }
    }
}
