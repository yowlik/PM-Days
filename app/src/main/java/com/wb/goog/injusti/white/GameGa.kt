package com.wb.goog.injusti.white

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import com.wb.goog.injusti.R

import com.wb.goog.injusti.databinding.ActivityGameGaBinding


class GameGa : AppCompatActivity() {
    lateinit var binding: ActivityGameGaBinding
    lateinit var anim:Animation
    lateinit var anim1:Animation
    var scr=100
    lateinit var scre:String
    var roll= mutableListOf<Int>(R.drawable.sl1,R.drawable.sl2,R.drawable.sl3)
    lateinit var buts:Array<Button>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityGameGaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        buts= arrayOf(binding.im1,binding.im2,binding.im3,binding.im4,binding.im5,binding.im6,binding.im7,
            binding.im8,binding.im9)
        anim=AnimationUtils.loadAnimation(this,R.anim.comb)
        anim1=AnimationUtils.loadAnimation(this,R.anim.spin)
        binding.start.setOnClickListener {
            scr=scr-10
            binding.score.text="$scr"
            binding.start.startAnimation(anim1)
            for (i in 0..8){
                buts[i].startAnimation(anim)
                buts[i].setText(roll.random())
                if(buts[i].text=="res/drawable/sl1.png"){
                    buts[i].setBackgroundResource(R.drawable.sl1)
                }
                else if(buts[i].text=="res/drawable/sl2.png"){
                    buts[i].setBackgroundResource(R.drawable.sl2)
                }
                else if(buts[i].text=="res/drawable/sl3.png"){
                    buts[i].setBackgroundResource(R.drawable.sl3)
                }
            }
            checkWin(binding.im1,binding.im2,binding.im3)
            checkWin(binding.im4,binding.im5,binding.im6)
            checkWin(binding.im7,binding.im8,binding.im9)
            checkWin(binding.im1,binding.im5,binding.im9)
            checkWin(binding.im3,binding.im5,binding.im7)
            if(scr<=0){
                scre="You lose\nTry again"
                val intent= Intent(this@GameGa, Resu::class.java)
                intent.putExtra("key",scre)
                startActivity(intent)

            }
        }


    }
    private fun checkWin(im:Button,im1:Button,im2:Button){
        if(im1.text==im.text&&im.text==im2.text){
            scr=scr+15
            binding.score.text="$scr"
            if(scr>=200){
                scre="You win\nCan you repeat?"
                val intent= Intent(this@GameGa, Resu::class.java)
                intent.putExtra("key",scre)
                startActivity(intent)

            }
        }
    }
}