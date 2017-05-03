package cn.com.sinosoft.bomswebsite.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 意见反馈控制器
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年4月21日
 */
@Controller
public class FeedbackController {

	/**
	 * 意见反馈首页
	 *
	 * @return
	 */
	@RequestMapping("feedback.html")
	public String toFeedbacks() {
		return "feedback/index";
	}

}
