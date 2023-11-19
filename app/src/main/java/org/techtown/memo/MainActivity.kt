package org.techtown.memo

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import org.techtown.memo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var viewBinding: ActivityMainBinding
    private var memo: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.nextScreenBtn.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)
            intent.putExtra("memo", viewBinding.editTextEt.text.toString())
            startActivity(intent)

            val create = Toast.makeText(this.applicationContext, "메모가 성공적으로 저장되었습니다.", Toast.LENGTH_SHORT)
            create.show()
        }
    }

    override fun onRestart() {
        super.onRestart()
        AlertDialog.Builder(this)
            .setTitle("")
            .setMessage("이어서 작성하시겠습니까?")
            .setPositiveButton("예") {dialog, which ->
                viewBinding.editTextEt.setText(memo)
            }
            .setNegativeButton("아니오") {dialog, which ->
                viewBinding.editTextEt.text.clear()
            }
            .create()
            .show()
    }

    override fun onPause() {
        super.onPause()
        memo = viewBinding.editTextEt.text.toString()
        viewBinding.editTextEt.text.clear()
    }

    override fun onResume() {
        super.onResume()
        val text = memo.toString()
    }
}