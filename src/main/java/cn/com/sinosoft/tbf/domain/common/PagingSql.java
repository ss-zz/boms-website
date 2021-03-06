/**
 * Copyright www.sinosoft.com.cn
 */
package cn.com.sinosoft.tbf.domain.common;

/**
 *
 * 分页查询用sql.
 *
 * @author <a href="mailto:nytclizy@gmail.com">李志勇</a>
 * @since 2014-10-24
 */
public class PagingSql {

	/**
	 * 原始sql
	 */
	String srcSql;
	/**
	 * 分页sql-总数
	 */
	String countSql;
	/**
	 * 分页sql-数据集
	 */
	String listSql;
	/**
	 * 绑定参数
	 */
	Object[] values;

	public String getCountSql() {
		return countSql;
	}

	public void setCountSql(String countSql) {
		this.countSql = countSql;
	}

	public String getListSql() {
		return listSql;
	}

	public void setListSql(String listSql) {
		this.listSql = listSql;
	}

	public Object[] getValues() {
		return values;
	}

	public void setValues(Object[] values) {
		this.values = values;
	}

	public String getSrcSql() {
		return srcSql;
	}

	public void setSrcSql(String srcSql) {
		this.srcSql = srcSql;
	}

}
