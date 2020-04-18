package mybatis.sqlsession;

import mybatis.cfg.Configuration;
import mybatis.sqlsession.defaults.defaultSqlSessionFactory;
import mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * @auther:sabot
 * @date:2020/04/18
 * @description:用于创建SqlSessionFactory对象
 */
public class SqlSessionFactoryBuilder {

    /**
     * @param:InputStream in
     * @return: SqlSessionFactory
     * @description:根据配置文件的输入流生产一个SqlSessionFactory工厂
     */
    public SqlSessionFactory build(InputStream in) {

        //加载配置文件将信息封装进Configuration内
        Configuration cfg = XMLConfigBuilder.loadConfiguration(in);

        return new defaultSqlSessionFactory(cfg);
    }
}
