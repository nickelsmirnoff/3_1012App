package com.edrthysrtsxample.buddtdrhgewfrawsergdrthdrthy.a3_1012app

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.util.Log

import kotlinx.android.synthetic.main.activity_cam_shoot.*
import kotlinx.android.synthetic.main.content_cam_shoot.*

class CamShootActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cam_shoot)
        setSupportActionBar(toolbar)
        var IIntent: Intent = getIntent()
        val PicUri: Uri = IIntent.getParcelableExtra("PicUri")
        val Btmp: Bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), PicUri)
        Log.d("PIPI","Picture taken by 2st activity, putting into imgview")
        YourName.text = IIntent.getStringExtra("YourName")
        YourPhoto.setImageBitmap(Btmp)




    }

}
