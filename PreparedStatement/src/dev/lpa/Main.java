package dev.lpa;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        var dataSource = new MysqlDataSource();

        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("music");

        try {
            dataSource.setContinueBatchOnError(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
