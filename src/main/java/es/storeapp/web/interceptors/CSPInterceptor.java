package es.storeapp.web.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CSPInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
        response.setHeader("Content-Security-Policy",
            "default-src * 'self'; " +
            "img-src * 'self' data:; " +
            "script-src  * 'self' 'unsafe-eval' 'unsafe-inline'; " +
            "style-src   * 'self' 'unsafe-inline';");
        return true;
    }

}
