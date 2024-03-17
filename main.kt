findViewById<ImageButton>(R.id.repeatBtn).setOnClickListener {
    if (repeat) {
        repeat = false
        player.repeatMode = Player.REPEAT_MODE_OFF
        findViewById<ImageButton>(R.id.repeatBtn).setImageResource(com.github.vkay94.dtpv.R.drawable.exo_controls_repeat_off)
        findViewById<ImageButton>(R.id.repeatBtn).setColorFilter(ContextCompat.getColor(this, R.color.your_color_off), PorterDuff.Mode.SRC_IN)
    } else {
        repeat = true
        player.repeatMode = Player.REPEAT_MODE_ONE
        findViewById<ImageButton>(R.id.repeatBtn).setImageResource(com.github.vkay94.dtpv.R.drawable.exo_controls_repeat_all)
        findViewById<ImageButton>(R.id.repeatBtn).setColorFilter(ContextCompat.getColor(this, R.color.your_color_on), PorterDuff.Mode.SRC_IN)
    }
}
