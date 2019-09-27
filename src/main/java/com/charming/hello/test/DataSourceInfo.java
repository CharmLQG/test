package com.charming.hello.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.sql.DataSource;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataSourceInfo {

    private String id;

    private int hashCode;

    private DataSource dataSource;

    private LocalDateTime lastTime;
}
