package com.sgugo.skyserver.interceptors;

import com.sgugo.skycommon.constant.JwtClaimsConstant;
import com.sgugo.skycommon.context.BaseContext;
import com.sgugo.skycommon.properties.JwtProperties;
import com.sgugo.skycommon.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Component
@Log4j2
public class TokenAdminInterceptor implements HandlerInterceptor {
//    @Resource
//    private JwtProperties jwtProperties;

    public boolean preHandle(HttpServletRequest req, HttpServletResponse res,Object handler)throws Exception {

        //1. 判断当前拦截到的方法是否是Controller接口
        if(!(handler instanceof HandlerMethod)){
            return true; //不是Controller接口，就直接放行
        }

        //2. 从请求头中获取令牌 ：token名字是在配置文件中定义的
//        String token = req.getHeader(jwtProperties.getAdminTokenName());

        //3. 使用工具类中的方法校验令牌
//        try {
//            Claims claims = JwtUtil.parseJWT(jwtProperties.getAdminSecret(), token);
//            Long empId = Long.valueOf(claims.get(JwtClaimsConstant.EMP_ID).toString());
//            log.info("员工ID为："+empId);
//            BaseContext.setId(empId);
//            return true;
//        }catch(Exception e){
//            res.setStatus(401);
//            return false;
//        }
        return false;
    }
}
