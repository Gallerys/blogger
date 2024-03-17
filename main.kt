findViewById<ImageButton>(R.id.repeatBtn).setOnClickListener {
            if(repeat){
                repeat = false
                player.repeatMode = Player.REPEAT_MODE_OFF
                findViewById<ImageButton>(R.id.repeatBtn).setImageResource(com.github.vkay94.dtpv.R.drawable.exo_controls_repeat_off)
            }
            else{
                repeat = true
                player.repeatMode = Player.REPEAT_MODE_ONE
                findViewById<ImageButton>(R.id.repeatBtn).setImageResource(com.github.vkay94.dtpv.R.drawable.exo_controls_repeat_all)
            }
        }
