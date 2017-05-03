package cn.com.sinosoft.bomswebsite.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 产品控制器
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年4月21日
 */
@Controller
public class ProductController {

	/**
	 * 产品介绍首页
	 *
	 * @return
	 */
	@RequestMapping("product.html")
	public String toProduct() {
		return "product/index";
	}

}
