package cn.com.sinosoft.bomswebsite.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 公司简介控制器
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年4月21日
 */
@Controller
public class SummaryController {

	/**
	 * 公司简介首页
	 *
	 * @return
	 */
	@RequestMapping("summary.html")
	public String toSummary() {
		return "summary/index";
	}

}
