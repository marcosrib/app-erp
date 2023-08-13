package br.com.somar.app.common.config;

import br.com.somar.app.adapters.outbound.jwt.JwtAdapter;
import br.com.somar.app.application.ports.out.auth.AuthenticationAdapterPort;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private AuthenticationAdapterPort authenticationAdapterPort;

    @Autowired
    private JwtAdapter jwtAdapter;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

            var token = this.recoverToken(request);
            if (token != null) {
                var login = jwtAdapter.validateToken(token);
                if (StringUtils.isNotEmpty(login)) {
                    UserDetails userDetails = authenticationAdapterPort.loadUserByUsername(login);
                    UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(userDetails,
                            null, userDetails.getAuthorities());
                    user.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(user);
                }
            }
            filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null) return null;
        return authHeader.replace("Bearer", "").trim();
    }


}
