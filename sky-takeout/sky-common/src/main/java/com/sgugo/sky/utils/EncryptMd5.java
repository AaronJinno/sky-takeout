package com.sgugo.sky.utils;

import org.springframework.util.DigestUtils;

/**
 * 进行md5加密和解密的工具类
 */
public class EncryptMd5 {
    //加密的盐应该写在配置文件中的，这里直接写死了
    private final static String salt = "shit";


    /**
     * 获取md5加密后的密码
     * @param pass 用户的明文密码
     * @return md5加密后的密码
     */
    public static String getMd5Pass(String pass){
        return DigestUtils.md5DigestAsHex((pass+salt).getBytes());
    }


    /**
     * 检测用户的明文密码
     * @param userPass 用户的明文密码
     * @param checkPass 服务器查询到的加密后的密码
     * @return 校验是否成功
     */
    public static boolean checkMd5Pass(String userPass,String checkPass){
        if(userPass.isEmpty()){
            return false;
        }
        String md5Pass = DigestUtils.md5DigestAsHex((userPass + salt).getBytes());
        return md5Pass.equals(checkPass);
    }
}
