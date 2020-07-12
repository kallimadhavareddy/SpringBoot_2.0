package tk.madhavareddy.digitaldiary.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-security-oauth2-example
 * User: madhavareddy
 * Email: kalli.madhavareddy@gmail.com
 * Date: 05/08/2019
 * Time: 16.06
 * To change this template use File | Settings | File Templates.
 */

@Configuration
@EnableAuthorizationServer
@Slf4j
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Value("${user.oauth.clientId}")
    private String ClientId;
    @Value("${user.oauth.clientSecret}")
    private String ClientSecret;
    @Value("${user.oauth.gratType}")
    private String GrantType;
    @Value("${user.oauth.scopeRead}")
    private String ScopeRead;
    @Value("${user.oauth.scopeWrite}")
    private String ScopeWrite;
    @Value("${user.oauth.accessTokenValidity}")
    private int AccessTokenValiditySeconds;
    @Value("${user.oauth.refreshTokenValidity}")
    private int RefreshTokenValiditySeconds;

    private final TokenStore tokenStore;
    private final UserApprovalHandler userApprovalHandler;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthorizationServerConfig(TokenStore tokenStore, UserApprovalHandler userApprovalHandler, AuthenticationManager authenticationManager) {
        this.tokenStore = tokenStore;
        this.userApprovalHandler = userApprovalHandler;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
        configurer
                .inMemory()
                .withClient(ClientId)
                .secret(ClientSecret)
                .authorizedGrantTypes(GrantType)//it could be (Authorization Code,Implicit,Password,Client Credentials,Device Code,Refresh Token)
                .scopes(ScopeRead, ScopeWrite)
                .accessTokenValiditySeconds(AccessTokenValiditySeconds)
                .refreshTokenValiditySeconds(RefreshTokenValiditySeconds);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
         endpoints.tokenStore(tokenStore).userApprovalHandler(userApprovalHandler)
                .authenticationManager(authenticationManager);
    }
}