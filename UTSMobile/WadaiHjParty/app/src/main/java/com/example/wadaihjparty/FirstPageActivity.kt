package com.example.wadaihjparty


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.wadaihjparty.databinding.ActivityFirstPageBinding

class FirstPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.firstpage_container, FirstPageFragment())
            .commit()
    }
}