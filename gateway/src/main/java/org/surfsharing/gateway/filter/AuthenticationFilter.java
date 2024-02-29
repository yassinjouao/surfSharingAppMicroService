package org.surfsharing.gateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.surfsharing.gateway.models.DataUserFromToken;
import org.surfsharing.gateway.util.JwtUtil;


@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    @Autowired
    private RouteValidator validator;
    @Autowired
    private JwtUtil jwtUtil;

    public AuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            System.out.println(exchange.getRequest().getHeaders());
            if (validator.isSecured.test(exchange.getRequest())) {
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    throw new RuntimeException("missing authorization header");
                }
                String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                if (authHeader != null && authHeader.startsWith("Bearer ")) {
                    authHeader = authHeader.substring(7);
                }
                try {
                    System.out.println(authHeader);
                    jwtUtil.validateToken(authHeader);
                    DataUserFromToken dataUserFromToken = jwtUtil.getDataFromToken(authHeader);
                    return chain.filter(
                            exchange.mutate().request(
                                            exchange.getRequest().mutate()
                                                    .header("hid", dataUserFromToken.getId())
                                                    .header("hrole", dataUserFromToken.getRole())
                                                    .header("husername", dataUserFromToken.getUsername())
                                                    .build())
                                    .build()
                    );
                } catch (Exception e) {
                    throw new RuntimeException("unauthorized access to application");
                }
            } else {
                throw new RuntimeException("unauthorized access to application");
            }
        };
    }
    public static class Config {

    }
}
