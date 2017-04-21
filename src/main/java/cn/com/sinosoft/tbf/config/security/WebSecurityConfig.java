package cn.com.sinosoft.tbf.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 应用安全配置
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2016年8月9日
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * 自定义web认证
	 */
	@Autowired
	private AuthenticationProviderCustom authProvider;

	/**
	 * 安全配置
	 *
	 * 
	 * @param http
	 * @throws Exception
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			// 禁用csrf
			.csrf().disable()
			// 安全认证
			.authorizeRequests()
				// 公共静态资源文件
				.antMatchers("/static/**").permitAll()
				.antMatchers("/website_pub/**").permitAll()
				// 对外公共api
				.antMatchers("/pubapi/**").permitAll()
				.anyRequest().authenticated()
			.and()
				.formLogin()
				.loginPage("/login").permitAll()
			.and().logout()
				.permitAll();
	}

	/**
	 * 认证配置
	 *
	 * 
	 * @param auth
	 * @throws Exception
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
	 */
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 自定义认证
		auth.authenticationProvider(authProvider);
		// 简单内存认证
		// auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
	}

}
