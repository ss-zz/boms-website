package cn.com.sinosoft.bomswebsite.model;

import java.util.Date;

/**
 * 意见反馈信息
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年5月3日
 */
public class FeedBackList {

	/**
	 * 数据id
	 */
	private Integer id;
	/**
	 * 反馈标题
	 */
	private String title;
	/**
	 * 反馈内容
	 */
	private String content;
	/**
	 * 创建用户
	 */
	private Integer userId;
	/**
	 * 创建用户姓名
	 */
	private String userRealName;
	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 回复内容
	 */
	private String replyContent;
	/**
	 * 回复人
	 */
	private Integer replyUserId;
	/**
	 * 回复用户姓名
	 */
	private String replyUserRealName;
	/**
	 * 回复时间
	 */
	private Date replyTime;

	/**
	 * 赞同数
	 */
	private Integer countUp;

	/**
	 * 反对数
	 */
	private Integer countDown;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public Integer getReplyUserId() {
		return replyUserId;
	}
	public void setReplyUserId(Integer replyUserId) {
		this.replyUserId = replyUserId;
	}
	public Date getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}
	public Integer getCountUp() {
		return countUp;
	}
	public void setCountUp(Integer countUp) {
		this.countUp = countUp;
	}
	public Integer getCountDown() {
		return countDown;
	}
	public void setCountDown(Integer countDown) {
		this.countDown = countDown;
	}
	public String getUserRealName() {
		return userRealName;
	}
	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}
	public String getReplyUserRealName() {
		return replyUserRealName;
	}
	public void setReplyUserRealName(String replyUserRealName) {
		this.replyUserRealName = replyUserRealName;
	}

}
