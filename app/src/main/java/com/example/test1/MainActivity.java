package com.example.test1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private Button greetButton;
    private Button clearButton;
    private TextView greetingTextView;
    private TextView titleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // 初始化视图组件
        initViews();

        // 设置按钮点击监听器
        setupButtonListeners();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initViews() {
        nameEditText = findViewById(R.id.nameEditText);
        greetButton = findViewById(R.id.greetButton);
        clearButton = findViewById(R.id.clearButton);
        greetingTextView = findViewById(R.id.greetingTextView);
        titleTextView = findViewById(R.id.titleTextView);
    }

    private void setupButtonListeners() {
        // 问候按钮点击事件
        greetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString().trim();

                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "请输入您的姓名", Toast.LENGTH_SHORT).show();
                    greetingTextView.setText("请先输入姓名");
                } else {
                    String greeting = "您好, " + name + "!\n欢迎学习Android开发!";
                    greetingTextView.setText(greeting);
                    Toast.makeText(MainActivity.this, "问候成功!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 清空按钮点击事件
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameEditText.setText("");
                greetingTextView.setText("");
                Toast.makeText(MainActivity.this, "已清空", Toast.LENGTH_SHORT).show();
            }
        });
    }
}