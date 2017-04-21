package cn.com.sinosoft.tbf.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 公共请求
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2016年11月29日
 */
@Controller
public class CommonController {
	
	/**
	 * 首页-系统会自动添加static/index.html为根目录
	 *
	 * @return
	 */
	/*@RequestMapping(value = {"/", "/index"})
	public String index() {
		return "index";
	}*/

	/**
	 * 登录页
	 *
	 * @return
	 */
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

}
