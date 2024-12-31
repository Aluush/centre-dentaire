package com.projet1.demo.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.projet1.demo.services.UserService;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public SecurityConfiguration(UserService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and() // Permet les requêtes cross-origin
                .csrf().disable() // Désactive la protection CSRF (utile si vous utilisez JWT ou API REST uniquement)
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL).permitAll() // Permet l'accès public à SIGN_UP_URL
                .antMatchers("/users/login", "/register", "/css/**", "/js/**").permitAll() // Permet l'accès aux ressources publiques
                .anyRequest().authenticated() // Toutes les autres requêtes nécessitent une authentification
                .and()
                .formLogin()
                .loginPage("/users/login") // URL de la page de connexion personnalisée
                .loginProcessingUrl("/users/login") // URL qui traite la soumission du formulaire
                .defaultSuccessUrl("/users/list", true) // Redirection après une connexion réussie
                .failureUrl("/users/login?error=true") // Redirection après un échec de la connexion
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout") // URL pour déconnecter l'utilisateur
                .logoutSuccessUrl("/users/login?logout=true") // Redirection après déconnexion
                .permitAll()
                .and()
                .addFilter(getAuthenticationFilter()) // Filtre personnalisé d'authentification
                .addFilter(new AuthorizationFilter(authenticationManager())) // Filtre d'autorisation
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS); // Sessions sans état (utile pour JWT)
    }

    protected AuthenticationFilter getAuthenticationFilter() throws Exception {
        final AuthenticationFilter filter = new AuthenticationFilter(authenticationManager());
        filter.setFilterProcessesUrl("/users/login"); // Assurez-vous que l'URL est cohérente
        return filter;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {//la classe li kat3ti ana t cree une instane men wa7ed la personne authentifier
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }
    
}