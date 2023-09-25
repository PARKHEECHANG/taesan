package com.taesan.mydata.global.interceptor;

import com.taesan.mydata.global.util.JwtUtils;
import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationFilter extends GenericFilterBean {

    private final JwtUtils jwtUtils;

//    @Override
//    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//        log.warn("1: {}", request);
//        String token = resolveToken(request);
//        log.warn("4: {}", token);
//        try {
//            if (token != null) {
//                Authentication authentication = jwtUtils.getAuthentication(token);
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//            chain.doFilter(request, response);
//        } catch (JwtException e) {
//            setErrorResponse(response);
//        }
//    }

    private String resolveToken(HttpServletRequest request) {
        String accessToken = request.getHeader("Authorization");
        log.warn("2: {}", accessToken);
        if (accessToken != null && jwtUtils.validateToken(accessToken)) {
            return accessToken;
        }
        log.warn("3: {}", accessToken);
        return null;
    }

    public void setErrorResponse(HttpServletResponse response) throws IOException {
        response.setStatus(401);
        response.setHeader("msg", "Check the tokens.");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.warn("1: {}", request);
        String token = resolveToken((HttpServletRequest) request);
        log.warn("4: {}", token);
        try {
            if(token!=null){
                Authentication authentication = jwtUtils.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            chain.doFilter(request, response);
        } catch (JwtException e) {
            setErrorResponse((HttpServletResponse) response);
        }
    }
}
