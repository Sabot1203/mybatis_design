package mybatis.sqlsession;


/**
 * @auther:sabot
 * @date:2020/04/18
 * @description:SqlSession工厂，用于生产SqlSession
 */
public interface SqlSessionFactory {

    SqlSession openSession();
}
