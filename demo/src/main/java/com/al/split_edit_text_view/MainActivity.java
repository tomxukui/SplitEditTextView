package com.al.split_edit_text_view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.al.open.OnInputListener;
import com.al.open.SplitEditTextView;

public class MainActivity extends AppCompatActivity {

    private Button btnChangeStyle;
    private Button btnChangeMode;
    private SplitEditTextView splitEdit1;
    private SplitEditTextView splitEdit2;
    private SplitEditTextView splitEdit3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setView();
    }

    private void initView() {
        btnChangeStyle = findViewById(R.id.btnChangeStyle);
        btnChangeMode = findViewById(R.id.btnChangeMode);
        splitEdit1 = findViewById(R.id.splitEdit1);
        splitEdit2 = findViewById(R.id.splitEdit2);
        splitEdit3 = findViewById(R.id.splitEdit3);
    }

    private void setView() {
        btnChangeStyle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                changeInputBoxStyle(splitEdit1);
                changeInputBoxStyle(splitEdit2);
                changeInputBoxStyle(splitEdit3);
            }

        });

        btnChangeMode.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                changeContentShowMode(splitEdit1);
                changeContentShowMode(splitEdit2);
                changeContentShowMode(splitEdit3);
            }

        });

        splitEdit1.setOnInputListener(new OnInputListener() {

            @Override
            public void onInputChanged(String text) {
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onInputFinished(String text) {
            }

        });

        splitEdit2.setOnInputListener(new OnInputListener() {

            @Override
            public void onInputChanged(String text) {
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onInputFinished(String text) {
            }

        });

        splitEdit3.setOnInputListener(new OnInputListener() {

            @Override
            public void onInputChanged(String text) {
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onInputFinished(String text) {
            }

        });
    }

    private void changeInputBoxStyle(SplitEditTextView view) {
        switch (view.getInputBoxStyle()) {

            case SplitEditTextView.INPUT_BOX_STYLE_SINGLE: {
                view.setInputBoxStyle(SplitEditTextView.INPUT_BOX_STYLE_CONNECT);
            }
            break;

            case SplitEditTextView.INPUT_BOX_STYLE_CONNECT: {
                view.setInputBoxStyle(SplitEditTextView.INPUT_BOX_STYLE_UNDERLINE);
            }
            break;

            case SplitEditTextView.INPUT_BOX_STYLE_UNDERLINE: {
                view.setInputBoxStyle(SplitEditTextView.INPUT_BOX_STYLE_SINGLE);
            }
            break;

        }
    }

    private void changeContentShowMode(SplitEditTextView view) {
        if (view.getContentShowMode() == SplitEditTextView.CONTENT_SHOW_MODE_PASSWORD) {
            view.setContentShowMode(SplitEditTextView.CONTENT_SHOW_MODE_TEXT);

        } else {
            view.setContentShowMode(SplitEditTextView.CONTENT_SHOW_MODE_PASSWORD);
        }
    }

}
