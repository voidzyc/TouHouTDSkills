package com.example.touhoutd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.crud.DataSupport;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private List<AvatarIcon> avatarIconList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String DB_PATH = "/data/data/com.example.touhoutd/databases/";
        String DB_NAME = "AvatarStore.db";

        // 检查 SQLite 数据库文件是否存在
        if ((new File(DB_PATH + DB_NAME)).exists() == false) {
            // 如 SQLite 数据库文件不存在，再检查一下 database 目录是否存在
            File f = new File(DB_PATH);
            // 如 database 目录不存在，新建该目录
            if (!f.exists()) {
                f.mkdir();
            }

            try {
                // 得到 assets 目录下的数据库文件作为输入流
                InputStream is = getBaseContext().getAssets().open(DB_NAME);
                // 输出流
                OutputStream os = new FileOutputStream(DB_PATH + DB_NAME);

                // 文件写入
                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }

                // 关闭文件流
                os.flush();
                os.close();
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        initAvatarIconList();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new
                GridLayoutManager(this, 4);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setPadding(15, 0, 15, 0);
        DataAdapter adapter = new DataAdapter(this, avatarIconList);
        recyclerView.setAdapter(adapter);

        /*Log.d(TAG, Integer.toString(R.drawable.wymls));
        Log.d(TAG, Integer.toString(R.drawable.wymls_lh));
        Log.d(TAG, Integer.toString(R.drawable.gmdj));
        Log.d(TAG, Integer.toString(R.drawable.yjyj));
        Log.d(TAG, Integer.toString(R.drawable.ddlxs));
        Log.d(TAG, Integer.toString(R.drawable.qjy_lh));*/

        /*Button addData = (Button) findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Avatar avatar = new Avatar();
                avatar.setName("八云紫");
                avatar.setImageIconId(R.drawable.byz);
                avatar.setImageId(R.drawable.byz_lh);
                avatar.setSkillName1("罔两[八云紫的神陷]");
                avatar.setSkillDes1("技能：单位目标 \n" +
                        "影响；敌方单位\n" +
                        "伤害类型：魔法\n" +
                        "八云紫操控隙间将目标神隐。\n" +
                        "\n" +
                        "[组合提升-博丽灵梦]\n" +
                        "储存数量提升为5.\n");
                avatar.setSkillName2("结界[动与静的均衡]");
                avatar.setSkillDes2("技能：点目标\n" +
                        "影响；敌方单位\n" +
                        "伤害类型：魔法\n" +
                        "八云紫将隙间内的单位投向目标点。对目标点造成伤害和眩晕。\n" +
                        "\n" +
                        "[星级相关]\n" +
                        "伤害：能量点*星级*1\n");
                avatar.setSkillName3("[深弹幕结界-梦幻泡影-]");
                avatar.setSkillDes3("技能：点目标 \n" +
                        "影响；友方单位\n" +
                        "伤害类型：魔法\n" +
                        "八云紫引导一秒，传向目标点。\n" +
                        "3秒后经过一秒引导返回。\n" +
                        "\n" +
                        "[组合提升-八云蓝，橙]\n" +
                        "蓝和橙将会一起被传送。\n");
                avatar.setSkillName4("废线[废弃车站下车之旅]");
                avatar.setSkillDes4("技能：无目标 \n" +
                        "影响；敌方单位\n" +
                        "伤害类型：纯粹\n" +
                        "八云紫从隙间中召唤废弃的电车，从出怪口沿道道路进行疾驰。\n" +
                        "对被电车碰撞到的单位造成伤害并眩晕。电车持续30秒。\n" +
                        "\n" +
                        "[星级相关]\n" +
                        "伤害：能量点*星级*10/每秒\n" +
                        "\n" +
                        "[组合提升-八云蓝，橙]\n" +
                        "增加电车的5节车厢。\n");
                avatar.save();
            }
        });

        Button queryData = (Button) findViewById(R.id.query_data);
        queryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Avatar> avatars = DataSupport.findAll(Avatar.class);
                for (Avatar avatar: avatars) {
                    Log.d(TAG, avatar.getName());
                    Log.d(TAG, Integer.toString(avatar.getImageIconId()));
                    Log.d(TAG, Integer.toString(avatar.getImageId()));
                    Log.d(TAG, avatar.getSkillName1());
                    Log.d(TAG, avatar.getSkillDes1());
                    Log.d(TAG, avatar.getSkillName2());
                    Log.d(TAG, avatar.getSkillDes2());
                    Log.d(TAG, avatar.getSkillName3());
                    Log.d(TAG, avatar.getSkillDes3());
                    Log.d(TAG, avatar.getSkillName4());
                    Log.d(TAG, avatar.getSkillDes4());
                }
            }
        });

        Button deleteData = (Button) findViewById(R.id.delete_data);
        deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataSupport.deleteAll(Avatar.class, "name == ?", "博丽灵梦");
            }
        });*/
    }

    private void initAvatarIconList() {
        List<Avatar> avatars = DataSupport.findAll(Avatar.class);
        for (Avatar avatar: avatars) {
            AvatarIcon avatarIcon =
                    new AvatarIcon(avatar.getName(), avatar.getImageIconId(), 113, 113);
            avatarIconList.add(avatarIcon);
        }
    }
}
