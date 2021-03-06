package ru.job4j.carStoreSrpingBoot.config;


import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import ru.job4j.carStoreSrpingBoot.model.User;
import ru.job4j.carStoreSrpingBoot.repo.UserDetailsRepo;

import java.time.LocalDateTime;

@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
/**
 * This is web security config with google authorization
 */
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/login**", "/js/**", "/error**")
                .permitAll().anyRequest()
                .authenticated().and().logout().logoutSuccessUrl("/").permitAll()
                .and()
                .csrf().disable();
    }

  /**
   * This bean check  user from db and creates new if there's no one
   * @param userDetailsRepo
   * @return
   */
  @Bean
    public PrincipalExtractor principalExtractor(UserDetailsRepo userDetailsRepo) {
        return map -> {
            String googleId = (String) map.get("sub");
            User user = userDetailsRepo.findByGoogleId(googleId).orElseGet(() ->
            {
                User newUser = new User();
                newUser.setGoogleId(googleId);
                newUser.setName((String)map.get("name"));
                newUser.setEmail((String)map.get("email"));
                newUser.setGender((String)map.get("gender"));
                newUser.setLocale((String)map.get("locale"));
                newUser.setUserpic((String)map.get("picture"));
                return newUser;
            });

            user.setLastVisit(LocalDateTime.now());

            return userDetailsRepo.save(user);
        };
    }
}
