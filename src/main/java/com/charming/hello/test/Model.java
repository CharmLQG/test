package com.charming.hello.test;

import java.io.Serializable;

/**
 * 所有实体类型的基类
 *
 * <p>所有的实体类型都是这个接口的实现类</p>
 *
 * @param <PK> 主键类型
 * @author zhouxinke
 * @date 2017年9月6日 下午1:37:52
 * @see Serializable
 */
public interface Model<PK> extends Serializable {

    /**
     * 获取主键
     *
     * @return 主键
     */
    PK getId();

    /**
     * 设置主键
     *
     * @param pk
     */
    void setId(PK pk);

}
