package com.example.androidtest.LitePal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidtest.R;
import com.example.androidtest.Util.LogUtil;

import org.litepal.LitePal;

import java.util.List;

public class LitePalActivity extends AppCompatActivity implements View.OnClickListener {
    private Button createDatabase;
    private Button addData;
    private Button updataData;
    private Button queryData;
    private Button deleteData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lite_pal);

        createDatabase = (Button) findViewById(R.id.create_database);
        createDatabase.setOnClickListener(this);
        addData = (Button) findViewById(R.id.add_data);

        addData.setOnClickListener(this);

        updataData = (Button) findViewById(R.id.updata_data);
        updataData.setOnClickListener(this);

        queryData = (Button) findViewById(R.id.query_data);
        queryData.setOnClickListener(this);

        deleteData = (Button) findViewById(R.id.delete_data);
        deleteData.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        AB ab = new AB();
        if (id == R.id.create_database) {
            LitePal.getDatabase();
        } else if (id == R.id.add_data) {
            ab.setA("a");
            ab.setB("c");
            ab.save();
        } else if (id == R.id.updata_data) {
            ab.setB("b");
            ab.updateAll("A=?", "a");
        } else if (id == R.id.query_data) {
            List<AB> abs = LitePal.findAll(AB.class);
            for (AB ab1 : abs) {
                LogUtil.d("A----------", ab1.getA());
                LogUtil.d("B----------", ab1.getB());
            }
        } else if (id == R.id.delete_data) {
            LitePal.deleteAll(AB.class, "A=?", "a");
        }
    }
}
