package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    static String strOutput = "";
    EditText editText;


    int cou_status = 0;
    //cou_status 1:加法 ,cou_status 2:減法
    long int_sum = 0;
    long int_a = 0 ,int_b = 0;

    int capacity = 50;
    long[] array = new long[capacity];
    int[] status = new int[capacity];


    String[] emoji = new String[capacity];

    int size = 0;


    TextView tv;//宣告和普通文字框變數為tv（與控制元件ID一致）

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_linear);

    }

    /** Called when the user taps the Send button */
    /* public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    } */
    public void list_add(long value,String view_type,int status_type) {
        if (size < capacity) {
            array[size] = value;
            emoji[size] = view_type;
            status[size] = status_type;
            size++;
        } else {
            // 当数组已满时，将元素往后移
            for (int i = 0; i < size - 1; i++) {
                array[i] = array[i + 1];
                emoji[i] = emoji[i + 1];
                status[i] = status[i + 1];
            }
            array[size - 1] = value;
            emoji[size - 1] = view_type;
            status[size - 1] = status_type;
        }

    }
    public void buttonClick(View view) {
        EditText editText = findViewById(R.id.editText_number);
        int numberStr = 0;

        switch (view.getId()) {
            case R.id.button_1:
                numberStr = 1;
                int_sum = (10*int_sum)+numberStr;
                break;
            case R.id.button_2:
                numberStr = 2;
                int_sum = (10*int_sum)+numberStr;
                break;
            case R.id.button_3:
                numberStr = 3;
                int_sum = (10*int_sum)+numberStr;
                break;
            case R.id.button_4:
                numberStr = 4;
                int_sum = (10*int_sum)+numberStr;
                break;
            case R.id.button_5:
                numberStr = 5;
                int_sum = (10*int_sum)+numberStr;
                break;
            case R.id.button_6:
                numberStr = 6;
                int_sum = (10*int_sum)+numberStr;
                break;
            case R.id.button_7:
                numberStr = 7;
                int_sum = (10*int_sum)+numberStr;
                break;
            case R.id.button_8:
                numberStr = 8;
                int_sum = (10*int_sum)+numberStr;
                break;
            case R.id.button_9:
                numberStr = 9;
                int_sum = (10*int_sum)+numberStr;
                break;
            case R.id.button_11:
                int_sum = int_sum*10;
                break;

            case R.id.button_plus:
//              TODO: (新增計算功能) 1:加法
                list_add(int_sum,"+",1);
                int_sum = 0;
                break;

            case R.id.button_equal:

//                計算
                if (size > 0) {
                    long result = int_sum;
                    for (int i = 0; i < size; i++) {
                        if (status[i] == 1) { // 加法操作
                            result += array[i];
                        }
                    }
                    int_sum = result; // 更新int_sum为计算结果
                }

//                復位
                size = 0;
                Arrays.fill(array, 0);
                Arrays.fill(status, 0);
                Arrays.fill(emoji, null);


                break;


        }

        String View_string = "";
        if (status[0] == 0) {
            View_string = Long.toString(int_sum);
//            editText.setText("O");
//            editText.setText(Long.toString(int_sum));
        } else {
//            editText.setText("K");
            if (size > 0) {
                String side_view = "";
                for (int i = 0; i < size; i++) {
                    if (status[i] == 1) { // 加法操作
                        side_view += Long.toString(array[i])+emoji[i]+"\n";
                    }
                }
                View_string = side_view+Long.toString(int_sum);
            }
        }
        editText.setText(View_string);


    }

}

