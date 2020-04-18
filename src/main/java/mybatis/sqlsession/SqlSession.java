package mybatis.sqlsession;


/**
 * @auther:sabot
 * @date:2020/04/18
 * @description:用于访问数据库的核心类，创建Dao的代理对象
 */
public interface SqlSession {

    /**
     * @param:Class<T> daoInterfaceClass dao的接口字节码
     * @return: T
     * @description:根据参数创建一个代理对象
     */
    <T> T getMapper( Class<T> daoInterfaceClass);

    /**
     * 释放资源
     */
    void close();
}
