package mybatis.io;


import java.io.InputStream;

/**
 * @auther:sabot
 * @date:2020/04/18
 * @description:用于读取配置文件的类
 */
public class Resources {

    /**
     * @param:String file Path
     * @return: InputStream
     * @description: 读取配置文件返回输入流
     */
    public static InputStream getResourceAsStream(String filePath){
        //使用类加载器读取
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
