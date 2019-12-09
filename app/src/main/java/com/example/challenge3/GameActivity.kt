package com.example.challenge3

import android.animation.ValueAnimator
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.text.PrecomputedText
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.timeout.*
import kotlinx.android.synthetic.main.timeout.view.*

class GameActivity : AppCompatActivity() {

    var handler = Handler()

    var handler2 = Handler()

    var handler3 = Handler()





    var i:Long = 30

    var i2:Long= 0

    var i3:Int =0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)







       val pref_myself = sharedPreference_myself(this@GameActivity )


//
//        /*__________________________*/
//
       val my_duration=pref_myself.get_duration_my_self()?.toLong()
//
     val my_img=pref_myself.get_img_my_self()?.toInt()

       val pref_competitor = sharedPreference_competitor(this@GameActivity )
//
      val competitor_delay_millis=pref_competitor.get_delay_millis_competitor()?.toLong()
//
       val competitor_duration=pref_competitor.get_duration_competitor()?.toLong()
//
      val competitor_img=pref_competitor.get_img_competitor()?.toInt()










        /*__________________________*/

        overridePendingTransition(0, 0)

        valueAnimator(competitor_duration!!)

        valueAnimator2(my_duration!!)



        my_image(my_imv,my_img!!)

        my_image(competitor_imv,competitor_img!!)



        my_imv.setOnClickListener {

            animator2.start()

            i3+=1

            score2.setText("myself_score:$i3")

        }


   //   val mytask = Mytask()



        val runnable3 = object :Runnable{
            override fun run() {


                handler3.postDelayed(this ,1000)


                i -= 1

                text.setText("倒數計時:00:$i")


                if(i<10){

                    text.setText("倒數計時:00:0$i")
                }


                if (i<=0){

                    handler3.removeCallbacks(this)

                    text.setText("倒數計時:00:00")

                }

            }


        }

        handler3.postDelayed(runnable3,1000)




        val runnable = object :Runnable{
            override fun run() {


                handler.postDelayed(this ,competitor_delay_millis!!)


                  i2 += 1

                score.setText("competitor_score:$i2")

                animator.start()

                if (i<=0){

                    handler.removeCallbacks(this)

                    my_imv.isEnabled = false

                    Thread.sleep(1350)

                    val mDialogView = LayoutInflater.from(this@GameActivity).inflate(R.layout.timeout, null)

                    mDialogView.my_score.setText("myself_score:$i3")

                    my_image(mDialogView.my_imageView,my_img!!)

                    my_image(mDialogView.competitor_imageView,competitor_img!!)

                    mDialogView.competitor_totalscore.setText("competitor_score:$i2")



                    if (i2>i3){

                        mDialogView.competitror_crown.visibility =View.VISIBLE

                    }

                    else if(i2<i3){

                        mDialogView.my_crown.visibility =View.VISIBLE


                    }

                    else{

                        mDialogView.competitror_crown.visibility =View.VISIBLE
                        mDialogView.my_crown.visibility =View.VISIBLE


                    }

                    mDialogView.return_page.setOnClickListener {

                                    pref_myself.delete_myself()

                                    pref_competitor.delete_competitor()

                                    val intent = Intent(this@GameActivity,MainActivity::class.java)

                                    startActivity(intent)

                                    finish()
                    }

                    val mBuilder = AlertDialog.Builder(this@GameActivity)
                        .setView(mDialogView)
                        .show()

                }



            }


        }

        handler.postDelayed(runnable,competitor_delay_millis!!)









//        val runnable2 = object :Runnable{
//            override fun run() {
//
//
//                handler2.postDelayed(this ,1500)
//
//
//                val my_animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotation2)
//
//                star.startAnimation( my_animation)
//
//                val my_animation2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotation)
//
//                star2.startAnimation( my_animation2)
//
//
//
//                if (i<=0){
//
//                    handler2.removeCallbacks(this)
//
//                }
//
//
//
//            }
//
//
//        }
//
//
//        handler2.postDelayed(runnable2,1500)

    }


    private lateinit var animator: ValueAnimator




    fun valueAnimator(duration:Long) {
        animator= ValueAnimator.ofFloat(0.0f, -500.0f, 0.0f)
        animator.duration = duration
        animator.addUpdateListener {
            Log.wtf("aaaa","valueAnimator()")
            competitor_imv.translationY = it.animatedValue as Float

        }
    }

    private lateinit var animator2:ValueAnimator

    fun valueAnimator2(duration:Long) {
        animator2= ValueAnimator.ofFloat(0.0f, -500.0f, 0.0f)
        animator2.duration = duration
        animator2.addUpdateListener {
            Log.wtf("aaaa","valueAnimator()")
            my_imv.translationY = it.animatedValue as Float
        }
    }


    fun my_image(image:ImageView,number:Int){

        if(number == 1){

            image.setImageResource(R.drawable.dragon)

        }

        else if(number == 2){

            image.setImageResource(R.drawable.turtle)

        }

        else if(number == 3){

            image.setImageResource(R.drawable.frog)

        }

        else {

            image.setImageResource(R.drawable.chun)

        }




    }


//    inner class Mytask() : AsyncTask<Int, Int, Int>(){
//
//        var handler = Handler()
//
//        override fun doInBackground(vararg params: Int?): Int {
//
//
//
//          val runnable = object :Runnable{
//              override fun run() {
//
//                  handler.postDelayed(this ,1000)
//
//
//
//
//              }
//
//
//
//
//          }
//            handler
//
//        }
//
//
//    }




}
