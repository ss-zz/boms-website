package cn.com.sinosoft.bomswebsite.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.sinosoft.bomswebsite.model.FeedBackAdd;
import cn.com.sinosoft.bomswebsite.model.FeedBackList;
import cn.com.sinosoft.tbf.common.util.security.UserUtil;
import cn.com.sinosoft.tbf.dao.BaseDao;
import cn.com.sinosoft.tbf.domain.common.PageParam;
import cn.com.sinosoft.tbf.domain.common.PagingResult;

/**
 * 意见反馈
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年5月3日
 */
@Service
public class FeedBackService {

	private static final String NAMESPACE_BASE = "cn.com.sinosoft.boms.feekback.";

	@Resource
	BaseDao baseDao;
	@Resource
	UserUtil userUtil;

	/**
	 * 意见反馈信息列表
	 *
	 * @param searchParams
	 *            查询参数
	 * @param pageParam
	 *            分页参数
	 * @return
	 */
	public PagingResult<FeedBackList> getFeedbackList(Map<String, Object> searchParams, PageParam pageParam) {
		PagingResult<FeedBackList> result = baseDao.pagingSearch(NAMESPACE_BASE + "feekback-list", searchParams,
				pageParam);
		return result;
	}

	/**
	 * 添加意见反馈
	 *
	 * @param feedback
	 *            意见反馈信息
	 * @return 新增记录id
	 */
	public Integer addFeedback(FeedBackAdd feedback) {
		if (feedback == null) {
			return null;
		}
		feedback.setUserId(userUtil.getRequestUserId());
		baseDao.insert(NAMESPACE_BASE + "feekback-add", feedback);
		return feedback.getId();
	}

}
