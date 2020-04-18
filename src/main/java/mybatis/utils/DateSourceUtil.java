package mybatis.utils;

import mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @auther:sabot
 * @date:2020/04/18
 * @description:用于创建数据源的工具类
 */
public class DateSourceUtil {

    public static Connection getConnection(Configuration cfg){
        try {
            Class.forName(cfg.getDriver());
            return DriverManager.getConnection(cfg.getUrl(),cfg.getUsername(),cfg.getPassword());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
