package mybatis.sqlsession.defaults;

import mybatis.cfg.Configuration;
import mybatis.sqlsession.SqlSession;
import mybatis.sqlsession.proxy.MapperProxy;
import mybatis.utils.DateSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @auther:sabot
 * @date:2020/04/18
 * @description:SqlSeesion的实现类
 */
public class defaultSqlSession implements SqlSession {

    private Configuration cfg;
    private Connection coon;

    public defaultSqlSession(Configuration cfg) {
        this.cfg = cfg;
        coon = DateSourceUtil.getConnection(cfg);
    }

    /**
     * @param:Class<T> daoInterfaceClass
     * @return: T
     * @description:用于创建代理对象
     */
    public <T> T getMapper(Class<T> daoInterfaceClass) {

        //创建代理
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(), new Class[]{daoInterfaceClass},new MapperProxy(cfg.getMappers(),coon));

    }


    /**
     * 释放资源
     *
     * */
     public void close()  {
         try {
             coon.close();
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
}
