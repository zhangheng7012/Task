package com.jnshu.util;

import io.jsonwebtoken.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    // 指定秘钥
    private static String key = "bzisucgsidbgpsg";
    // 指定des密钥
    private static String desKey = "adhapsoxhasgodmcisdhc";

    // 创建JWT，expTime 为过期时间
    public static String createJwt(String id,long expTime){

        // 生成JWT的时间，也是登录时间
        long nowTime = System.currentTimeMillis();
        Date now = new Date(nowTime);

        // des 加密id
        String userId = DesUtil.encryptor(id,desKey);
        // des 加密登录时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy‐MM‐dd hh:mm:ss");
        String loginTime = DesUtil.encryptor(sdf.format(now),desKey);

        // 创建payload的私有声明
        Map<String,Object> claims = new HashMap<>();
        // 用户id、登录时间
        claims.put("userId",userId);
        claims.put("loginTime",loginTime);

        // 为payload添加声明
        JwtBuilder jwtBuilder = Jwts.builder()
                // 设置私有声明
                .setClaims(claims)
                // JWT 的唯一标识
                .setId(id)
                // JWT 的签发时间
                .setIssuedAt(now)
                // 设置签名所用的算法和秘钥
                .signWith(SignatureAlgorithm.HS256, key);
        //设置过期时间
        if(expTime>=0){
            long expMills = nowTime + expTime;
            Date exp = new Date(expMills);
            jwtBuilder.setExpiration(exp);
        }
        // 生成JWT
        return jwtBuilder.compact();
    }

    // 解析token，判断有效性来检验是否登录
    public static Boolean parseJWT(String token){
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token)
                    .getBody();
            // 获取用户id
            String id = String.valueOf(claims.get("userId"));
            // des 解密id
            String userId = DesUtil.decryptor(id,desKey);
            // 字符串用户id非空判断
            if(userId != null && !"".equals(userId)){
                return true;
            }else {
                return false;
            }
        // 会自动判断token是否已经过期，过期则抛出该异常
        }catch(ExpiredJwtException e){
            // 表示 token 已过期
            return false;
        }
    }


}
