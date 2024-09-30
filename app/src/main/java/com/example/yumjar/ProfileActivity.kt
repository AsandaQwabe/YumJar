package com.example.yumjar

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.LinearLayout

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)


        val mainLayout: LinearLayout = findViewById(R.id.main)


        val editProfileButton: Button = findViewById(R.id.editProfileButton)
        editProfileButton.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java) // Replace with your EditProfileActivity
            startActivity(intent)
        }
    }
}
