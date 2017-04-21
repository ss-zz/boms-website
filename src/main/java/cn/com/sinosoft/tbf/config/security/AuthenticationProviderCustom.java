package cn.com.sinosoft.tbf.config.security;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import cn.com.sinosoft.tbf.common.security.UserService;
import cn.com.sinosoft.tbf.common.util.security.UserUtil;
import cn.com.sinosoft.tbf.domain.common.security.UserInfo;

/**
 * 自定义认证
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2016年8月9日
 */
@Component
public class AuthenticationProviderCustom implements AuthenticationProvider {

	@Autowired
	private UserService userServcie;
	@Autowired
	HttpServletRequest request;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// 用户名
		String userName = authentication.getName();
		// 密码
		String passWord = String.valueOf(authentication.getCredentials());
		// 验证
		UserInfo userInfo = userServcie.getUserBaseInfo(userName, passWord);
		if (userInfo != null) {
			// 用户被锁定
			if(!UserUtil.USER_STATE_LOCKED.equals(userInfo.getState())){
				throw new BadCredentialsException("用户已禁用");
			}
			
			request.getSession().setAttribute(UserUtil.SESSION_NAME_USERINFO, userInfo);
			
			// 授权
			Collection<? extends GrantedAuthority> authorities = null;
			return new UsernamePasswordAuthenticationToken(userName, passWord, authorities);
		} else {
			throw new BadCredentialsException("用户名或者密码不存在");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
