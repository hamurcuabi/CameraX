package com.emrehmrc.camerax

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.emrehmrc.camerax.databinding.ActivityMainBinding
import com.emrehmrc.camerax_capture.CameraXCaptureActivity
import com.emrehmrc.camerax_capture.CameraXCaptureActivity.Companion.CameraXFilePath
import com.emrehmrc.camerax_capture.CameraXCaptureActivity.Companion.REQUEST_CAMERAX_CAPTURE

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            val newIntent = Intent(this, CameraXCaptureActivity::class.java)
            startActivityForResult(newIntent, REQUEST_CAMERAX_CAPTURE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CAMERAX_CAPTURE && resultCode == RESULT_OK) {
            val test = data?.getStringExtra(CameraXFilePath)
            binding.imageView.setImageURI(Uri.parse(test))
        }
    }
}