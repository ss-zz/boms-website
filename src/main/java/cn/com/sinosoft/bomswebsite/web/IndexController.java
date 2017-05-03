package cn.com.sinosoft.bomswebsite.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页控制器
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年4月21日
 */
@Controller
public class IndexController {

	/**
	 * 进入首页
	 *
	 * @return
	 */
	@RequestMapping(value = {"/", "/index", "/index.html"})
	public String toIndex() {
		return "index";
	}

}
