package ma.piko.customerfrontthymeleafap.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private ClientRegistrationRepository clientRegistrationRepository;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        return http
                .csrf(Customizer.withDefaults())
                .authorizeHttpRequests(req-> req.requestMatchers("/","/webjars/**","h2-console/**").permitAll())
                .authorizeHttpRequests(req->req.anyRequest().authenticated())
                .oauth2Login(Customizer.withDefaults())
//                .logout((logout) -> logout
//                       // .logoutSuccessHandler(oidcLogoutSuccessHandler())
//                        .logoutSuccessUrl("/").permitAll()
//                        .clearAuthentication(true)
//                        .deleteCookies("JSESSIONID"))
//                .exceptionHandling(eh->eh.accessDeniedPage("/notAutorized"))
                .build();

    }

//    private LogoutSuccessHandler oidcLogoutSuccessHandler() {
//        final OidcClientInitiatedLogoutSuccessHandler oidcLogoutSuccessHandler =
//                new OidcClientInitiatedLogoutSuccessHandler(this.clientRegistrationRepository);
//        oidcLogoutSuccessHandler.setPostLogoutRedirectUri("{baseUrl}?logoutsuccess=true");
//        return oidcLogoutSuccessHandler;
//    }


}
