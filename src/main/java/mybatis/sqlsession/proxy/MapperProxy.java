package mybatis.sqlsession.proxy;

import mybatis.cfg.Mapper;
import mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;
import java.util.concurrent.Exchanger;

/**
 * @auther:sabot
 * @date:2020/04/18
 * @description:自定义代理方式
 */
public class MapperProxy implements InvocationHandler {

    private Map<String, Mapper> mappers;
    private Connection coon;

    public MapperProxy(Map<String, Mapper> mappers, Connection coon) {
        this.mappers = mappers;
        this.coon = coon;
    }


    /**
     * @param:Object proxy, Method method, Object[] args
     * @return:
     * @description:用于对方法进行增强
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //获取方法名
        String methodName = method.getName();
        //获取方法所在类名
        String className = method.getDeclaringClass().getName();
        //组合成key从Map中取出对应的Mapper
        String key = className+"."+methodName;
        Mapper mapper = mappers.get(key);
        if (mapper == null){
            throw new IllegalArgumentException("参数有误");
        }
        //调用工具类执行增删改查方法
        return new Executor().selectList(mapper,coon);

    }


}
