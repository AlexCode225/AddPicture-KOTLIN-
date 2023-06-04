 package com.example.addpicture

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.cardview.widget.CardView

 class MainActivity : AppCompatActivity() {

    private lateinit var image: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val Card1: CardView=findViewById(R.id.Card1);

        Card1.setOnClickListener {
          image = findViewById(R.id.Imguload)
            UploadImage(image)


        }





    }

     private fun UploadImage(image: ImageView){
         val intent= Intent ()
         intent.action =Intent.ACTION_GET_CONTENT
         intent.type = "image/*"
  startActivityForResult(intent, 1)
     }


     override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
         super.onActivityResult(requestCode, resultCode, data)
         if (requestCode == 1){
             image.setImageURI(data?.data)
         }
     }

}