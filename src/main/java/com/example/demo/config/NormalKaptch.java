package com.example.demo.config;

import com.google.code.kaptcha.GimpyEngine;
import com.google.code.kaptcha.util.Configurable;

import java.awt.image.BufferedImage;

/**
 * @author yang
 * @create_at 17-12-7
 **/
public class NormalKaptch  extends Configurable implements GimpyEngine {
    @Override
    public BufferedImage getDistortedImage(BufferedImage bufferedImage) {
        return bufferedImage;
    }
}
