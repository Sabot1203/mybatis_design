package dao;

import domain.User;

import java.util.List;

/**
 * @auther:sabot
 * @date:2020/04/17
 * @description:访问User持久层的接口
 */
public interface IUserDao {

    /**
     * @param:null
     * @return: List<User>
     * @description:获取所有用户
     */
    List<User> findAll();
}
