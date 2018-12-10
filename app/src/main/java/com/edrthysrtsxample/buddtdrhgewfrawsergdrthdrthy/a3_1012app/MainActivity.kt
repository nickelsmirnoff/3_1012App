package com.edrthysrtsxample.buddtdrhgewfrawsergdrthdrthy.a3_1012app

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val CAMERA_CODE = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("PIPI","created app")
        setContentView(R.layout.activity_main)
        buttonShoot.setOnClickListener {
            var YourName:String = editTextName.text.toString()
            Log.d("PIPI","name = "+YourName)
            if (YourName.isEmpty())
            {
                Log.d("PIPI","emp name")
                Toast.makeText(this, editTextName.hint,Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val CallCameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            Log.d("PIPI","cam intent created")
            if (CallCameraIntent.resolveActivity(packageManager) != null)
            {
                Log.d("PIPI","cam pic taken. trying to start activity2")
                startActivityForResult(CallCameraIntent,CAMERA_CODE)
            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode != 0)
        {
            Log.d("PIPI","WTF?! cam error buddy")
            Toast.makeText(this, "WTF?! cam error buddy)",Toast.LENGTH_SHORT).show()
            return
        }
        else
        {
            if (resultCode==Activity.RESULT_OK && data != null)
            {
                Log.d("PIPI","cam pic taken. work with it")

                val IntentCamShoot = Intent(this, CamShootActivity::class.java)
                IntentCamShoot.putExtra("YourName", editTextName.text)
                val PicUri:Uri = data.getData()
                //val Pic : Bitmap = data.extras.get("data") as Bitmap
                IntentCamShoot.putExtra("PictureUri", PicUri)
                startActivity(IntentCamShoot)


            }



        }
    }

}
