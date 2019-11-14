package com.example.lab5

import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AlphabetIndexer
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            val dialog = AlertDialog.Builder(this@MainActivity)
            dialog.setTitle("請選擇功能")
            dialog.setMessage("請根據下方按鈕選擇要顯示的物件")
            dialog.setNeutralButton("取消") { arg0, arg1 ->
                // TODO Auto-generated method stub
                Toast.makeText(this@MainActivity, "dialog關閉", Toast.LENGTH_SHORT).show()
            }
            dialog.setNegativeButton("自定義Toast") { arg0, arg1 ->
                // TODO Auto-generated method stub
                showToast()
            }


            dialog.setPositiveButton("顯示list") { arg0, arg1 ->
                // TODO Auto-generated method stub
                showListDialog()
            }
            dialog.show()
        }
    }

    private fun showToast() {
        val toast = Toast(this@MainActivity)
        toast.setGravity(Gravity.TOP, 0, 50)
        toast.duration = Toast.LENGTH_SHORT
        val inflater = layoutInflater
        val layout = inflater.inflate(R.layout.custom_toast, findViewById<View>(R.id.custom_toast) as ViewGroup)
        toast.view = layout
        toast.show()
    }

    private fun showListDialog() {
        val list = arrayOf("message1", "message2", "message3", "message4", "message5")
        val dialog_list = AlertDialog.Builder(this@MainActivity)
        dialog_list.setTitle("使用LIST呈現")
        dialog_list.setItems(list) { arg0, arg1 ->
            // TODO Auto-generated method stub
            Toast.makeText(this@MainActivity, "你選的是" + list[arg1], Toast.LENGTH_SHORT).show()
        }
        dialog_list.show()


    }

}
