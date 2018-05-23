package com.example.touhoutd;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.touhoutd.base.BaseActivity;

import org.litepal.crud.DataSupport;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

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

        List<Avatar> avatars = DataSupport.select("name").find(Avatar.class);
        for (Avatar avatar : avatars) {
            int imageiconid = ImageMapping.getImageMapping(avatar.getName());
            avatar.setImageIconId(imageiconid);
            avatar.setImageId(imageiconid + 1);
            avatar.updateAll("name = ?", avatar.getName());
        }

        //初始化头像列表
        initAvatarIconList();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new
                GridLayoutManager(this, 4);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setPadding(15, 28, 15, 0);
        DataAdapter adapter = new DataAdapter(this, avatarIconList);
        recyclerView.setAdapter(adapter);

        //LitePal.getDatabase();

    }

    private void initAvatarIconList() {
        //按rarity读取数据库数据
        List<Avatar> avatarsSSR =
                DataSupport.where("rarity == ?", "SSR").find(Avatar.class);
        List<Avatar> avatarsSR =
                DataSupport.where("rarity == ?", "SR").find(Avatar.class);
        List<Avatar> avatarsR =
                DataSupport.where("rarity == ?", "R").find(Avatar.class);
        List<Avatar> avatarsN =
                DataSupport.where("rarity == ?", "N").find(Avatar.class);
        List<Avatar> avatars = new ArrayList<>();
        avatars.addAll(avatarsSSR);
        avatars.addAll(avatarsSR);
        avatars.addAll(avatarsR);
        avatars.addAll(avatarsN);
        for (Avatar avatar : avatars) {
            AvatarIcon avatarIcon =
                    new AvatarIcon(avatar.getName(), avatar.getImageIconId(), 113, 113);
            avatarIconList.add(avatarIcon);
        }
    }
}
