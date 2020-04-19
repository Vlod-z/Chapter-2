package chapter.android.aweme.ss.com.homework;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class chat extends AppCompatActivity {
    private TextView tv_content_info;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);
        tv_content_info = findViewById(R.id.tv_content_info);

        Intent dataIntent = getIntent();
        int index = dataIntent.getIntExtra("index",0);

        tv_content_info.append("这是第"+index+"个item");

    }
}
