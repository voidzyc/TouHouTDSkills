package com.example.touhoutd;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.touhoutd.base.BaseActivity;

import org.litepal.crud.DataSupport;

import java.util.List;

public class SkillActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "SkillActivity";

    private TextView nameView;
    private TextView skillView;
    private ImageView imageView;
    private Button pytsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skill_layout);

        AssetManager mgr = getAssets();
        Typeface tf1 = Typeface.createFromAsset(mgr, "fonts/汉仪橄榄体简.TTF");
        Typeface tf2 = Typeface.createFromAsset(mgr, "fonts/汉仪书魂体简.TTF");

        Intent intent = getIntent();
        String name = intent.getStringExtra("extra_name");

        List<Avatar> avatars =
                DataSupport.where("name == ?", name).find(Avatar.class);
        final Avatar avatar = avatars.get(0);

        nameView = (TextView) findViewById(R.id.name_view);
        nameView.setText(name);
        nameView.setTypeface(tf1);

        skillView = (TextView) findViewById(R.id.skill_view);
        skillView.setText(avatar.getSkillName1() + "\n" + avatar.getSkillDes1());
        skillView.setMovementMethod(new ScrollingMovementMethod());
        skillView.setTypeface(tf2);

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        button1.setText(avatar.getSkillName1());
        button2.setText(avatar.getSkillName2());
        button3.setText(avatar.getSkillName3());
        button4.setText(avatar.getSkillName4());
        button1.setTypeface(tf1);
        button2.setTypeface(tf1);
        button3.setTypeface(tf1);
        button4.setTypeface(tf1);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

        Drawable image1 = getBaseContext().getResources().getDrawable(R.mipmap.num_1);
        Drawable image2 = getBaseContext().getResources().getDrawable(R.mipmap.num_2);
        Drawable image3 = getBaseContext().getResources().getDrawable(R.mipmap.num_3);
        Drawable image4 = getBaseContext().getResources().getDrawable(R.mipmap.num_4);
        Drawable image5 = getBaseContext().getResources().getDrawable(R.mipmap.num_5);
        int w = image1.getIntrinsicWidth();
        int h = image1.getIntrinsicHeight();
        image1.setBounds(0, 0, w, h);
        image2.setBounds(0, 0, w, h);
        image3.setBounds(0, 0, w, h);
        image4.setBounds(0, 0, w, h);
        image5.setBounds(0, 0, w, h);
        button1.setCompoundDrawables(selectUnlock(avatar.getSkillunlock1(), image1, image2, image3, image4, image5), null, null, null);
        button2.setCompoundDrawables(selectUnlock(avatar.getSkillunlock2(), image1, image2, image3, image4, image5), null, null, null);
        button3.setCompoundDrawables(selectUnlock(avatar.getSkillunlock3(), image1, image2, image3, image4, image5), null, null, null);
        button4.setCompoundDrawables(selectUnlock(avatar.getSkillunlock4(), image1, image2, image3, image4, image5), null, null, null);

        imageView = (ImageView) findViewById(R.id.image_view);
        imageView.setImageResource(avatar.getImageId());
        float itemWidth = (ScreenUtils.getScreenWidth(this) - 15 * 2) / 2;
        float itemHeight = itemWidth * 358 / 256;
        RelativeLayout.LayoutParams layoutParams =
                (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.height = (int) itemHeight;
        imageView.setLayoutParams(layoutParams);

        pytsButton = findViewById(R.id.image_button);
        pytsButton.setTypeface(tf1);
        pytsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skillView.setText(avatar.getPyts());
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

        skillView = (TextView) findViewById(R.id.skill_view);
        switch (v.getId()) {
            case R.id.button1:
                skillView.setText(avatar.getSkillName1() + "\n" + avatar.getSkillDes1());
                break;
            case R.id.button2:
                skillView.setText(avatar.getSkillName2() + "\n" + avatar.getSkillDes2());
                break;
            case R.id.button3:
                skillView.setText(avatar.getSkillName3() + "\n" + avatar.getSkillDes3());
                break;
            case R.id.button4:
                skillView.setText(avatar.getSkillName4() + "\n" + avatar.getSkillDes4());
                break;
            default:
                break;
        }
    }

    private Drawable selectUnlock(int num, Drawable image1, Drawable image2, Drawable image3, Drawable image4, Drawable image5) {
        switch (num) {
            case 1:
                return image1;
            case 2:
                return image2;
            case 3:
                return image3;
            case 4:
                return image4;
            case 5:
                return image5;
            case 0:
                return null;
            default:
                return null;
        }
    }
}
