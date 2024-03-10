override fun onScroll(
        e1: MotionEvent?,
        event: MotionEvent,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        minSwipeY += distanceY

        val sWidth = Resources.getSystem().displayMetrics.widthPixels
        val sHeight = Resources.getSystem().displayMetrics.heightPixels

        val border = 100 * Resources.getSystem().displayMetrics.density.toInt()
        if(event.x < border || event.y < border || event.x > sWidth - border || event.y > sHeight - border)
            return false

        //minSwipeY for slowly increasing brightness & volume on swipe --> try changing 50 (<50 --> quick swipe & > 50 --> slow swipe
        // & test with your custom values
        if(abs(distanceX) < abs(distanceY) && abs(minSwipeY) > 50){
            if(event.x < sWidth/2){
                //brightness
                binding.brightnessIcon.visibility = View.VISIBLE
//                playPauseBtn.visibility = View.GONE
                binding.volumeIcon.visibility = View.GONE
                val increase = distanceY > 0
                val newValue = if(increase) brightness + 1 else brightness - 1
                if(newValue in 0..30) brightness = newValue
                binding.brightnessIcon.text = brightness.toString()
                setScreenBrightness(brightness)
            }
            else{
                //volume
                binding.brightnessIcon.visibility = View.GONE
//                playPauseBtn.visibility = View.GONE
                binding.volumeIcon.visibility = View.VISIBLE
                val maxVolume = audioManager!!.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
                val increase = distanceY > 0
                val newValue = if(increase) volume + 1 else volume - 1
                if(newValue in 0..maxVolume) volume = newValue
                binding.volumeIcon.text = volume.toString()
                audioManager!!.setStreamVolume(AudioManager.STREAM_MUSIC, volume, 0)
            }
            minSwipeY = 0f
        }
        return true
    }
