package com.example.kotlinsixfirst

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.kotlinsixfirst.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var openActivity: ActivityResultLauncher<Intent>

    override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
        initBtn()
        initLaunch()
    }

    private fun initLaunch() {
        openActivity =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == Activity.RESULT_OK) {
                    val intent: Intent? = it.data
                    val text = intent?.getStringExtra(API_BACK_KEY)
                    setText(text)
                }
            }
    }

    private fun setText(text: String?) {
        binding.txtFirst.setText(text)
    }


    private fun initBtn() {
        binding.btnFirst.setOnClickListener {
            val text = binding.txtFirst.text.toString()
            if (text.isNotBlank())
                transaction(text)
            else
                toast(this, getString(R.string.blank))
        }
    }

    private fun transaction(text: String) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(API_KEY, text)
        openActivity.launch(intent)

    }


}