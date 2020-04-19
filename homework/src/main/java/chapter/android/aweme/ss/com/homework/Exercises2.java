package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {

    private static TextView count;
    private static View view;
    private static Button btn1;
    private static Button btn2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise2);
        count = findViewById(R.id.tv_count);
        view = findViewById(R.id.view0);
        btn1=findViewById(R.id.button1);
        btn2=findViewById(R.id.button2);
        count.append("view总数为："+getAllChildViewCount(view));
    }

    public int getAllChildViewCount(View root) {
        //todo 补全你的代码
        int viewCount = 0;

        if (null == root) {
            return 0;
        }

        if (root instanceof ViewGroup) {
            viewCount++;
            for (int i = 0; i < ((ViewGroup) root).getChildCount(); i++) {
                View view = ((ViewGroup) root).getChildAt(i);
                if (view instanceof ViewGroup) {
                    viewCount += getAllChildViewCount(view);
                }
                else {
                    viewCount++;
                }
            }
        }

        return viewCount;
    }
}
