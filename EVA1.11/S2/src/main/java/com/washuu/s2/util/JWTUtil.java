package com.washuu.s2.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.washuu.s2.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Map;

@Slf4j
@Component
public class JWTUtil {
    @Value("${com.washuu.jwt.signature}")
    private String signature;


    /**
     * 生成token
     */
    public String getToken(Map<String, String> payLoad){
        Calendar instance = Calendar.getInstance();
        //默认7天过期
        instance.add(Calendar.MINUTE,30);
        //创建jwt builder
        JWTCreator.Builder builder = JWT.create();
        payLoad.forEach(builder::withClaim);
        String token = builder.withExpiresAt(instance.getTime())//有效期
                .sign(Algorithm.HMAC256(signature));//密钥
        return token;
    }

    public String getToken(User user){
        Calendar instance = Calendar.getInstance();
        //默认7天过期
        instance.add(Calendar.MINUTE,30);
        //创建jwt builder
        JWTCreator.Builder builder = JWT.create();
        builder.withClaim(user.getUserName(), user.getPassword());
        String token = builder.withExpiresAt(instance.getTime())//有效期
                .sign(Algorithm.HMAC256(signature));//密钥
        return token;
    }
    /**
     * 验证token合法性
     */
    public DecodedJWT verify(String token){
        //返回验证结果（结果是内置的）
        return JWT.require(Algorithm.HMAC256(signature)).build().verify(token);
    }

    /**
     * 拿到token中的负载
     * @param token
     * @return
     */
    public String getPayload(String token) {
        return verify(token).getPayload();
    }



















//
//
//    public static String getToken(User user) {
//        JwtBuilder jwtBuilder = Jwts.builder()
//                .setId(user.getUserName())
////                .setSubject(user.getUserName())
//                .setSubject(user.getPassword())
//                .setIssuedAt(new Date())
//                .signWith(SignatureAlgorithm.HS256, signature)
//                .setExpiration(new Date(new Date().getTime() + 3600000));
//        System.out.println(jwtBuilder.compact());
//        return jwtBuilder.compact();
//    }
//
//    public static Map<String, Object> resolveTokenPayLoad(String token) {
//        Claims claims = Jwts.parser()
//                .setSigningKey("test")
//                .parseClaimsJws(token)
//                .getBody();
//        log.debug(claims.getId());
//        log.debug(claims.getSubject());
//        log.debug("用户时间" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getIssuedAt()));
//        log.debug("用户时间" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getExpiration()));
//        Map<String, Object> tokenPayLoad = new HashMap<>();
//        tokenPayLoad.put(TokenEnum.PASSWORD.toString(), claims.getSubject());
//        tokenPayLoad.put(TokenEnum.USER_NAME.toString(), claims.getId());
//        return tokenPayLoad;
//    }




}
