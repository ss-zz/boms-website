package cn.com.sinosoft.bomswebsite.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.sinosoft.bomswebsite.model.FeedBackAdd;
import cn.com.sinosoft.bomswebsite.model.FeedBackList;
import cn.com.sinosoft.bomswebsite.service.FeedBackService;
import cn.com.sinosoft.tbf.domain.common.APIResult;
import cn.com.sinosoft.tbf.domain.common.PageParam;
import cn.com.sinosoft.tbf.domain.common.PagingResult;
import cn.com.sinosoft.tbf.domain.common.ResultCode;

/**
 * 意见反馈控制器
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年4月21日
 */
@Controller
public class FeedbackController {

	@Resource
	FeedBackService feedBackService;

	/**
	 * 意见反馈每页显示数据量
	 */
	public static final Integer PER_PAGE_COUNT = 20;

	/**
	 * 意见反馈首页
	 *
	 * @return
	 */
	@RequestMapping("feedback.html")
	public ModelAndView toFeedback() {
		return toFeedbackPage(1);
	}

	/**
	 * 意见反馈首页-列表分页
	 *
	 * @return
	 */
	@RequestMapping("feedback-{page}.html")
	public ModelAndView toFeedbackPage(@PathVariable Integer page) {
		ModelAndView mav = new ModelAndView("feedback/index");
		PageParam pageParam = new PageParam(page, PER_PAGE_COUNT);
		PagingResult<FeedBackList> listData = feedBackService.getFeedbackList(null, pageParam);
		int total = listData.getTotal();
		mav.addObject("feedbackData", listData);
		mav.addObject("currentPage", page);
		mav.addObject("totalPage", total % PER_PAGE_COUNT > 0 ? total / PER_PAGE_COUNT + 1 : total / PER_PAGE_COUNT);
		mav.addObject("perPageCount", PER_PAGE_COUNT);
		return mav;
	}

	/**
	 * 意见反馈列表
	 *
	 * @param searchParams
	 *            查询参数
	 * @param pageParam
	 *            分页参数
	 * @return
	 */
	@GetMapping("feedback/list")
	@ResponseBody
	public APIResult<PagingResult<FeedBackList>> getList(Map<String, Object> searchParams, PageParam pageParam,int page) {
		System.out.println(page);
		PagingResult<FeedBackList> result = feedBackService.getFeedbackList(searchParams, pageParam);
		return new APIResult<PagingResult<FeedBackList>>(result);
	}

	/**
	 * 意见反馈-添加
	 *
	 * @param feedback
	 *            意见反馈信息
	 * @return 新增数据id
	 */
	@PostMapping("feedback/add")
	@ResponseBody
	public APIResult<Integer> addFeedback(@Valid FeedBackAdd feedback, BindingResult errors) {
		if (errors.hasErrors()) {
			return new APIResult<Integer>(ResultCode.FAILURE.getCode(), errors);
		}
		return new APIResult<Integer>(feedBackService.addFeedback(feedback), "意见反馈添加成功", true);
	}
	
	/**
	 * 意见反馈-跳转Dialog页
	 * @return
	 */
	@RequestMapping("feedbackDialog.html")
	public String openDialogFeedback(){
		return "feedback/feedbackDialog";
	}
	/**
	 * 意见反馈-跳转Dialog页
	 * @return
	 */
	@RequestMapping("addFeedback2")
	public ModelAndView addFeedback2(){
		
		System.out.println(222);
		return toFeedback();
	}

}
