package chn.scalar.api.security.config;
import chn.scalar.api.security.aop.SecurityFilter;
import chn.scalar.api.security.domain.SecurityProvider;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
public class SecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>{
    private SecurityProvider provider;
    public SecurityConfig(SecurityProvider provider) {
        this.provider = provider;
    }

    @Override
    public void configure(HttpSecurity builder) throws Exception {
        SecurityFilter filter = new SecurityFilter(provider);
        builder.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
    }
}