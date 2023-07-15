package com.sgugo.skyserver;

import org.springframework.util.DigestUtils;

/**
 * @Author: Aaron Jinno
 * @Description: TODO
 * @Date: 2023/7/15 1:53
 * @Since 1.0
 * @Version: 1.0
 */
public class Encrypt {
    private static String salt = "shit";
    public static String getMd5Pass(String pass){
        String md5Pass = DigestUtils.md5DigestAsHex((pass+salt).getBytes());

        return md5Pass;
    }

    public boolean checkMd5Pass(String userPass,String checkPass){
        if(userPass.isEmpty()){
            return false;
        }

        String md5Pass = DigestUtils.md5DigestAsHex((userPass + salt).getBytes());
        return md5Pass.equals(checkPass);
    }
}
