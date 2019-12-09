package com.example.challenge3

import android.animation.ValueAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref_competitor = sharedPreference_competitor(this@MainActivity )

        val pref_myself = sharedPreference_myself(this@MainActivity )

        pref_myself.delete_myself()

        pref_competitor.delete_competitor()


        enter.setOnClickListener {


            val intent = Intent(this@MainActivity,LoadingActivity::class.java)

            startActivity(intent)

            finish()

        }



        competitor_imageView.setOnClickListener {


          if (competitor_imageView.getTag().equals("chun")) {

              competitor_imageView.setImageResource(R.drawable.dragon)

              competitor_imageView .setTag("dragon")

              competitor_name.setText("小火龍")

              competitor_fire.setText("戰鬥力：3500")

              competitor_introduce.setText("尾巴上的火焰代表目前的心情，高\n興時火焰會搖晃，生氣時火焰會燃\n燒的更猛烈，當其尾部火焰熄滅，便\n會死亡。")


              pref_competitor.save_delay_millis_competitor("333")//120//250

              pref_competitor.save_img_competitor("1")

              pref_competitor.save_duration_competitor("233")//150


            }

          else  if(competitor_imageView.getTag().equals("dragon")){

                competitor_imageView.setImageResource(R.drawable.turtle)

                competitor_imageView .setTag("turtle")

                competitor_name.setText("傑尼龜")

                competitor_fire.setText("戰鬥力：2500")

                competitor_introduce.setText("其圓滑的外形及表面的淺溝\n都能降低水中的阻力，這樣\n就能游得更快。")

              pref_competitor.save_delay_millis_competitor("430")//90//333

              pref_competitor.save_img_competitor("2")

              pref_competitor.save_duration_competitor("330")//233


            }


            else if(competitor_imageView.getTag().equals("turtle")){


                competitor_imageView.setImageResource(R.drawable.frog)

                competitor_imageView .setTag("frog")

                competitor_name.setText("妙蛙種子")

                competitor_fire.setText("戰鬥力：1500")

                competitor_introduce.setText("有如青蛙般的身體上背著大顆\n充滿營養的種子，與種子是共\n生關係。")

              pref_competitor.save_delay_millis_competitor("770")//70//430

              pref_competitor.save_img_competitor("3")

              pref_competitor.save_duration_competitor("670")//330
            }

           else {

                competitor_imageView.setImageResource(R.drawable.chun)

                competitor_imageView .setTag("chun")

                competitor_name.setText("皮卡丘")

                competitor_fire.setText("戰鬥力：500")

                competitor_introduce.setText("代表技能是電擊、十萬伏特、\n電光一閃、鐵尾、打雷、伏\n特攻擊、電球。")

              pref_competitor.save_delay_millis_competitor("250") //40//770

              pref_competitor.save_img_competitor("4")

              pref_competitor.save_duration_competitor("150")//670


            }

        }


        my_imageView.setOnClickListener {


            if (my_imageView.getTag().equals("chun")) {

                my_imageView.setImageResource(R.drawable.dragon)

                my_imageView .setTag("dragon")

                my_name.setText("小火龍")

                my_fire.setText("戰鬥力：3500")

                my_introduce.setText("尾巴上的火焰代表目前的心情，高\n興時火焰會搖晃，生氣時火焰會燃\n燒的更猛烈，當其尾部火焰熄滅，便\n會死亡。")

                pref_myself.save_duration_my_self("200")//120

                pref_myself.save_img_my_self("1")

            }

          else  if(my_imageView.getTag().equals("dragon")){

                my_imageView.setImageResource(R.drawable.turtle)

                my_imageView .setTag("turtle")

                my_name.setText("傑尼龜")

                my_fire.setText("戰鬥力：2500")

                my_introduce.setText("其圓滑的外形及表面的淺溝\n都能降低水中的阻力，這樣\n就能游得更快。")

                pref_myself.save_duration_my_self("247")//200

                pref_myself.save_img_my_self("2")


            }


          else  if(my_imageView.getTag().equals("turtle")){


                my_imageView.setImageResource(R.drawable.frog)

                my_imageView .setTag("frog")

                my_name.setText("妙蛙種子")

                my_fire.setText("戰鬥力：1500")

                my_introduce.setText("有如青蛙般的身體上背著大顆\n充滿營養的種子，與種子是共\n生關係。")

                pref_myself.save_duration_my_self("500")//247

                pref_myself.save_img_my_self("3")
            }

            else{

                my_imageView.setImageResource(R.drawable.chun)

                my_imageView .setTag("chun")

                my_name.setText("皮卡丘")

                my_fire.setText("戰鬥力：500")

                my_introduce.setText("代表技能是電擊、十萬伏特、\n電光一閃、鐵尾、打雷、伏\n特攻擊、電球。")

                pref_myself.save_duration_my_self("120")//500

                pref_myself.save_img_my_self("4")
            }


        }

    }


}