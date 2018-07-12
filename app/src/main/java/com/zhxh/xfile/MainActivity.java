package com.zhxh.xfile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tvFile)
    TextView tvFile;
    @BindView(R.id.btnShow)
    Button btnShow;
    @BindView(R.id.btnChange)
    Button btnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnShow})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnShow:
                tvFile.setText("展示所有文件名");
                break;
            case R.id.btnChange:
                tvFile.setText("展示所有改名后的文件名");
                break;
            default:
                break;
        }
    }

}

