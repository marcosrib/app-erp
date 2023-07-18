package br.com.somar.app.common.config;

import br.com.somar.app.adapters.outbound.jwt.JwtAdapter;
import br.com.somar.app.application.ports.out.users.FindUserAdapterPort;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    private FindUserAdapterPort findUserAdapterPort;
    @Autowired
    private JwtAdapter jwtAdapter;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoverToken(request);
        if (token != null) {
            var login = jwtAdapter.validateToken(token);
            System.out.println(login);
            // UserDetails userDetails = findUserAdapterPort.findByEmail(login);
        }
        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null) return null;
        return authHeader.replace("Bearer", "");
    }


}
