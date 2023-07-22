package com.sgugo.sky.interceptors;

import com.sgugo.sky.constant.JwtClaimsConstant;
import com.sgugo.sky.context.BaseContext;
import com.sgugo.sky.properties.JwtProperties;
import com.sgugo.sky.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Log4j2
public class TokenAdminInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtProperties jwtProperties;

    public boolean preHandle(HttpServletRequest req, HttpServletResponse res,Object handler)throws Exception {

        //1. 判断当前拦截到的方法是否是Controller接口
        if(!(handler instanceof HandlerMethod)){
            return true; //不是Controller接口，就直接放行
        }

        //2. 从请求头中获取令牌 ：token名字是在配置文件中定义的
        String token = req.getHeader(jwtProperties.getAdminTokenName());

        //3. 使用工具类中的方法校验令牌
        try {
            // 3.1 解密Token
            Claims claims = JwtUtil.parseJWT(jwtProperties.getAdminSecret(), token);
            // 3.2 获取Token内自定义的员工ID
            Long empId = Long.valueOf(claims.get(JwtClaimsConstant.EMP_ID).toString());
            log.info("员工ID为："+empId);
            // 3.3 将员工id存入当前线程
            BaseContext.setId(empId);

            //3.4 对Token进行续签
            long expTime = claims.getExpiration().getTime();
            long iatTime = claims.getIssuedAt().getTime();
            long nowTime = new Date().getTime();
            if((nowTime-iatTime)>(expTime-iatTime)/2){
                Map<String, Object> payload = new HashMap<>();
                payload.put(JwtClaimsConstant.EMP_ID,empId);
                //未过期，且时间过半，满足续签条件
                String newToken = JwtUtil.createJWT(jwtProperties.getAdminTtl(), jwtProperties.getAdminSecret(), payload);
                //将新token加入响应头
                res.addHeader(jwtProperties.getAdminTokenName(),newToken);
            }
            return true;
        }catch(Exception e){
            // 3.4 产生异常，说明Token不合法或过期，此时响应401，不放行
            res.setStatus(401);
            return false;
        }
    }
}
