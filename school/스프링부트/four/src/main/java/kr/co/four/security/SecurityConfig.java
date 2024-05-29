package kr.co.four.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import kr.co.four.TestService;

@Configuration
//시큐리티 필터 등록
@EnableWebSecurity 
//특정 페이지에 특정 권한이 있는 유저만 접근을 허용할 경우 권한 및 인증을 미리 체크하겠다는 설정을 활성화 함.
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter { 

	@Autowired
	TestService service;
	

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public static NoOpPasswordEncoder noPasswordEncoder() {
      return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }    
    

    @Override
    public void configure(WebSecurity web) throws Exception {
    	//인증을 받지 않아도 되는 url제외 목록
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**", "/index", "/newMember", "/loginForm");  
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	//인증을 받아야하는 url목록
        http.authorizeRequests()  
                .antMatchers("/member").authenticated()	//.authenticated() : 인증이 된 유저만 접근 가능
                .antMatchers("/super").hasAuthority("super")	//.hasAuthority("super") : 권한(auth)이 'super'인 사용자만 접근 가능
                .antMatchers("/normal").hasAnyAuthority("super","normal")	//.hasAuthority("super") : 권한(auth)이 'normal','super'인 사용자만 접근 가능
                .antMatchers("/**").permitAll(); // .permitAll() : 해당 경로들은 접근을 허용

        
        //로그인 성공 시, 실패 시 , 인증 실패 시 보여지는 페이지 설정
        http.formLogin()  
        		.loginProcessingUrl("/login")     //브라우저에서 login으로 요청하면 동작 합니다. 이때 username, password 키 값으로 보내야 합니다.   
                .loginPage("/loginForm")  // 해당 주소로 로그인 페이지를 호출한다.
                .defaultSuccessUrl("/member").failureUrl("/deny")
                .permitAll().and().csrf().disable();
      
        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/index")
                .invalidateHttpSession(true)  // 인증정보를 지우하고 세션을 무효화
                .deleteCookies("JSESSIONID"); // JSESSIONID 쿠키 삭제;

        http.exceptionHandling()
                .accessDeniedPage("/deny");
    }

    
    // 시큐리티가 로그인 과정에서 password를 가로챌때 해당 해쉬로 암호화해서 비교한다.
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//    	auth.userDetailsService(service).passwordEncoder(noPasswordEncoder());  //비밀번호 암호화하지 않았을때의 로그인 매칭 로직
    	auth.userDetailsService(service).passwordEncoder(passwordEncoder());  //비밀번호 암호화했을때의 로그인 매칭 로직
    }

    
}