package com.project.configure

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.server.SecurityWebFilterChain
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import java.lang.Exception
import javax.sql.DataSource

@Configuration
@EnableWebSecurity
class Configuration : WebSecurityConfigurerAdapter(), WebMvcConfigurer {
    @Autowired
    @Qualifier("customUserDetailsService")
    private val userDetailsService: UserDetailsService? = null

    @Bean
    fun jdbcTemplate(@Qualifier("dataSource") dataSource: DataSource): JdbcTemplate {
        return JdbcTemplate(dataSource)
    }

    @Bean
    fun authenticationProvider(): AuthenticationProvider {
        val provider = DaoAuthenticationProvider()
        provider.setUserDetailsService(userDetailsService)
        provider.setPasswordEncoder(BCryptPasswordEncoder())
        return provider
    }


    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/users", "/users/**").hasAuthority("ADMIN")
            .antMatchers("/posts", "/posts/**").hasAnyAuthority("USER", "ADMIN")
            .and()
            .formLogin().permitAll()
            .and()
            .logout().permitAll();
    }
}