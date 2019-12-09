package com.example.challenge3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_loading.*

class LoadingActivity : AppCompatActivity() {

    var handler = Handler()

    var i:Long = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        var runnable = object :Runnable{
                    override fun run() {


                        handler.postDelayed(this ,1000)


                           i -= 1

                          coundowner.setText("$i")



                        if (i<=0){

                            handler.removeCallbacks(this)

                            val intent = Intent(this@LoadingActivity,GameActivity::class.java)

                            startActivity(intent)

                            finish()



                        }



                    }


                }

                handler.postDelayed(runnable,1000)

    }
}
