package com.roanderson.design_compose

import android.os.CountDownTimer

class Timer {
   fun time(){
       val timer = object: CountDownTimer(20000, 1000) {
           override fun onTick(millisUntilFinished: Long) {}

           override fun onFinish() {}
       }
       timer.start()
   }
}