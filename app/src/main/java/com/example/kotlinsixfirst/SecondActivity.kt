package com.example.kotlinsixfirst

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinsixfirst.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater).also { setContentView(it.root) }
        initBtn()
        initData()
    }

    private fun initBtn() {
        binding.btnSecond.setOnClickListener {
            val text = binding.txtSecond.text.toString()
            if (text.isNotBlank())
                transaction(text)
            else
                toast(this, getString(R.string.blank))
        }
    }

    private fun transaction(text: String) {
        val intent = Intent()
        intent.putExtra(API_BACK_KEY, text)
        setResult(RESULT_OK, intent)
        finish()
    }

    private fun initData() {
        val date: Bundle? = intent.extras
        val text = date?.getString(API_KEY)
        initTxt(text)
    }

    private fun initTxt(text: String?) {
        binding.txtSecond.setText(text)
    }


}