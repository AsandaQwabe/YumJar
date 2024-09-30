package com.example.yumjar

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EditProfileActivity : AppCompatActivity() {

    private lateinit var profileImageView: ImageView
    private lateinit var uploadPictureButton: Button
    private lateinit var deletePictureButton: Button
    private lateinit var nameEditText: EditText
    private lateinit var surnameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var numberEditText: EditText
    private lateinit var pushNotificationsSwitch: Switch
    private lateinit var saveChangesButton: Button

    private val IMAGE_PICK_CODE = 1000
    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        profileImageView = findViewById(R.id.profile_image_view)
        uploadPictureButton = findViewById(R.id.upload_picture_btn)
        deletePictureButton = findViewById(R.id.delete_picture_btn)
        nameEditText = findViewById(R.id.name)
        surnameEditText = findViewById(R.id.surname)
        emailEditText = findViewById(R.id.email)
        numberEditText = findViewById(R.id.number)
        pushNotificationsSwitch = findViewById(R.id.push_notifications)
        saveChangesButton = findViewById(R.id.save_changes_btn)


        uploadPictureButton.setOnClickListener {
            pickImageFromGallery()
        }

        deletePictureButton.setOnClickListener {
            deleteProfilePicture()
        }

        saveChangesButton.setOnClickListener {
            saveChanges()
        }
    }

    private fun pickImageFromGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

    private fun deleteProfilePicture() {
        profileImageView.setImageResource(R.drawable.default_profile_image)
        imageUri = null
    }

    private fun saveChanges() {


        val name = nameEditText.text.toString()
        val surname = surnameEditText.text.toString()
        val email = emailEditText.text.toString()
        val number = numberEditText.text.toString()
        val pushNotificationsEnabled = pushNotificationsSwitch.isChecked
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_PICK_CODE && resultCode == Activity.RESULT_OK) {
            imageUri = data?.data
            profileImageView.setImageURI(imageUri)
        }
    }
}
