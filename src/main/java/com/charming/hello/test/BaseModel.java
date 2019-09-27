package com.charming.hello.test;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;


@Data
@Slf4j
public abstract class BaseModel<PK>  {

    /**
     * 数据主键
     */
    private PK id;

    /**
     * 数据创建人
     */
    private Object creator;

    /**
     * 数据创建时间
     */
    private LocalDateTime createTime;

    /**
     * 数据修改人
     */
    private Object modifier;

    /**
     * 数据修改时间
     */
    private LocalDateTime modifyTime;

    /**
     * 数据状态
     */


}
