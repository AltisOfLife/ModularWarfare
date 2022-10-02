package com.modularwarfare.melee.client.animation;

import com.modularwarfare.melee.client.configs.AnimationMeleeType;
import com.modularwarfare.melee.client.configs.MeleeRenderConfig;
import com.modularwarfare.utility.maths.Interpolation;

public class ActionPlaybackMelee {

    public AnimationMeleeType action;

    public double time;

    public boolean hasPlayed;

    private MeleeRenderConfig config;

    public ActionPlaybackMelee(MeleeRenderConfig config){
        this.config = config;
    }

    public void updateTime(double alpha){
        if(config.animations.get(action)==null) {
            return;
        }
        double startTime = config.animations.get(action).getStartTime(config.FPS);
        double endTime = config.animations.get(action).getEndTime(config.FPS);
        this.time = Interpolation.LINEAR.interpolate(startTime, endTime, alpha);
        checkPlayed();
    }
    
    public boolean checkPlayed() {
        double endTime = config.animations.get(action).getEndTime(config.FPS);
        if(this.time >= endTime){
            this.hasPlayed = true;
        } else {
            this.hasPlayed = false;
        }
        return hasPlayed;
    }
}
