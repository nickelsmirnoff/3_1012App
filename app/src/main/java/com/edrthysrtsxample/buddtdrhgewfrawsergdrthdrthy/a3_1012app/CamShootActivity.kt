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
        Log.d("PIPI","act2 launched. getting intent")
        var IIntent: Intent = getIntent()
        Log.d("PIPI","intent got")

        var PicUri: Uri = IIntent.getParcelableExtra("PicUri")
        Log.d("PIPI","Uri got"+PicUri.toString())
        var nameStr = IIntent.getStringExtra("YourName")
        Log.d("PIPI","name = "+nameStr)
        YourName.text = nameStr
        Log.d("PIPI","name = "+YourName.text.toString())
        var Btmp: Bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), PicUri)
        var size:Int = Math.min(Btmp.height, Btmp.width)
        var move: Int = Math.abs((Btmp.width-Btmp.height)/2)
        Log.d("PIPI", Btmp.toString()+" "+size.toString())
        var SqBtmp:Bitmap = Bitmap.createBitmap(Btmp, 0,0,size,size)


        Log.d("PIPI","Picture taken by 2st activity, putting into imgview")

        YourPhoto.setImageBitmap(SqBtmp)




    }

}
