package cn.com.sinosoft.tbf.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cn.com.sinosoft.tbf.common.util.security.UserUtil;

/**
 * 基础dao-wcm
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2016年8月12日
 */
@Component("baseDao")
public class BaseDao extends BaseDaoAbst{

	@Autowired
	@Qualifier("sqlSessionTemplate")
	protected SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	UserUtil userUtil;

	@Override
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	@Override
	public UserUtil getUserUtil() {
		return userUtil;
	}

}
