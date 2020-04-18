package mybatis.sqlsession.defaults;

import mybatis.cfg.Configuration;
import mybatis.sqlsession.SqlSession;
import mybatis.sqlsession.SqlSessionFactory;

/**
 * @auther:sabot
 * @date:2020/04/18
 * @description:SqlSessionFactiry的实现类
 */
public class defaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration cfg;

    public defaultSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }

    public SqlSession openSession() {
        return new defaultSqlSession(cfg);
    }
}
