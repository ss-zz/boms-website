package cn.com.sinosoft.bomswebsite.model;

/**
 * 意见反馈信息-添加
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2017年5月3日
 */
public class FeedBackAdd {

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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

}
