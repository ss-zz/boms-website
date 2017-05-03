package cn.com.sinosoft.bomswebsite.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 联系我们控制器
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年4月21日
 */
@Controller
public class ContactUsController {

	/**
	 * 联系我们首页
	 *
	 * @return
	 */
	@RequestMapping("contactus.html")
	public String toContactus() {
		return "contactus/index";
	}

}
