package com.wk.warehouse.controller;

import com.google.code.kaptcha.Producer;
import com.wk.warehouse.entity.Result;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/*
    验证码
*/
@RestController
@RequestMapping("/captcha")
public class VerificationCodeController {

    @Resource(name="captchaProducer")
    private Producer captchaProducer;
    // Springboot提供的针对redis操作字符串的便捷工具对象
    private static StringRedisTemplate stringRedisTemplate;

    @Autowired
    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        VerificationCodeController.stringRedisTemplate = stringRedisTemplate;
    }
    /**
     * 验证码生成接口
     */
    @GetMapping("/captchaImage")
    public Result getCaptchaImage() {
        ByteArrayOutputStream baos = null;
        try {
            String code = captchaProducer.createText();    // 验证码4位字符
            BufferedImage bi = captchaProducer.createImage(code); // 验证码图片

            baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "jpg", baos);
            baos.flush();
            String imgEncode = Base64.encodeBase64String(baos.toByteArray()); // 验证码图片的Base64编码字符串

            String key = UUID.randomUUID().toString().replace("-", ""); // 存储验证码的key
            stringRedisTemplate.opsForValue().set(key, code); // 将验证码的key和value存入redis中

            Map<String, String> map = new HashMap<>();
            map.put("imgUrl", imgEncode);
            map.put("imgKey", key);
            return Result.ok(map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Result.err(Result.CODE_ERR_BUSINESS, "验证码生成失败！");
    }

    /**
     * 验证码后台验证
     */
    /*@GetMapping("/verify-code")
    public Result verifyCode(String verificationCode) {
        String serverCode = stringRedisTemplate.opsForValue().get("");
        if(verificationCode.equals(serverCode)){
            return Result.ok("验证码正确");
        }else{
            return Result.err(Result.CODE_ERR_BUSINESS, "验证码不正确！");
        }
    }*/

}
