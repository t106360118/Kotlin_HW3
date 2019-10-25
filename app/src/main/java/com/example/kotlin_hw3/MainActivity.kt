package com.example.kotlin_hw3

import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.custom_toast.*
import java.security.acl.Group

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.button);
        btn.setOnClickListener {
            val dialog =AlertDialog.Builder(this);
            dialog.setTitle("請選擇功能");
            dialog.setMessage("請根據下方按鈕選擇要顯示的物件");

            dialog.setNeutralButton("取消"){_, _ ->
                Toast.makeText(this,"dialog 關閉",Toast.LENGTH_SHORT).show();

            };
            dialog.setPositiveButton("顯示list"){_, _ ->
                showListDialog();
            };
            dialog.setNegativeButton("自定義Toast"){_, _ ->
                showToast();
            };
            dialog.show();
        }
    }

     private fun showToast(){
        val toast = Toast(this);
        toast.setGravity(Gravity.TOP,0,50);
         toast.duration =Toast.LENGTH_SHORT;
         val inflater = layoutInflater;
         val layout =inflater.inflate(R.layout.custom_toast,custom_toast_root);
         toast.view=layout;
         toast.show();
    }
    private fun showListDialog(){
        val list = arrayOf( "message1","message2","message3","message4","message5");
        val dialog_list =AlertDialog.Builder(this);
        dialog_list.setTitle("使用LIST呈現");
        dialog_list.setItems(list){_, which ->
            Toast.makeText(this,"你選的是"+list[which],Toast.LENGTH_SHORT).show();
        };
        dialog_list.show();
    }
}
