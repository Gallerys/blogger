override fun onScroll(
        e1: MotionEvent?,
        event: MotionEvent,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        minSwipeY += distanceY
        minSwipeX += distanceX

        val sWidth = Resources.getSystem().displayMetrics.widthPixels
        val sHeight = Resources.getSystem().displayMetrics.heightPixels

        val border = 50 * Resources.getSystem().displayMetrics.density.toInt()
        if (event.x < border || event.y < border || event.x > sWidth - border || event.y > sHeight - border)
            return false

        // minSwipeY for slowly increasing brightness & volume on swipe
        // minSwipeX for detecting horizontal swipes
        if (abs(minSwipeX) > 100) {
            if (abs(distanceX) > abs(distanceY)) {
                // Horizontal swipe
                if (distanceX > 0) {
                    // Swipe right for forward (adjust the time as needed)
                    player.seekTo(player.currentPosition - 10000)
                } else {
                    // Swipe left for rewind (adjust the time as needed)
                    player.seekTo(player.currentPosition + 10000)
                }
                minSwipeX = 0f
            } else {
                // Vertical swipe
                if (event.x < sWidth / 2) {
                    // brightness
                    binding.brightnessIcon.visibility = View.VISIBLE
                    binding.volumeIcon.visibility = View.GONE
                    val increase = distanceY > 0
                    val newValue = if (increase) brightness + 1 else brightness - 1
                    if (newValue in 0..30) brightness = newValue
                    binding.brightnessIcon.text = brightness.toString()
                    setScreenBrightness(brightness)
                } else {
                    // volume
                    binding.brightnessIcon.visibility = View.GONE
                    binding.volumeIcon.visibility = View.VISIBLE
                    val maxVolume = audioManager!!.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
                    val increase = distanceY > 0
                    val newValue = if (increase) volume + 1 else volume - 1
                    if (newValue in 0..maxVolume) volume = newValue
                    binding.volumeIcon.text = volume.toString()
                    audioManager!!.setStreamVolume(AudioManager.STREAM_MUSIC, volume, 0)
                }
                minSwipeY = 0f
            }
        }
        return true
    }
