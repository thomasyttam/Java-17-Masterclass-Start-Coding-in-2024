package dev.lpa;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Properties props = new Properties();
        try {
            props.load(Files.newInputStream(Path.of("music.properties"),
                    StandardOpenOption.READ));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        String query = "SELECT * FROM music.artists";

        var dataSource = new MysqlDataSource();
        dataSource.setServerName(props.getProperty("serverName"));
        dataSource.setPort(Integer.parseInt(props.getProperty("port")));
        dataSource.setDatabaseName(props.getProperty("databaseName"));

        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter an Album Name: ");
//        String albumName = "Tapestry";
//        String albumName = scanner.nextLine();
//        String query = "SELECT * FROM music.albumview WHERE album_name='%s'"
//                .formatted(albumName);
        System.out.println("Enter an Artist Id: ");
        String artistId = scanner.nextLine();
        String query = "SELECT * FROM music.artists WHERE artist_id=%s"
                .formatted(artistId);

        try (var connection = dataSource.getConnection(
                props.getProperty("user"),
                System.getenv("MYSQL_PASS"));
             Statement statement = connection.createStatement();
        ) {
//            System.out.println("Success!");
            ResultSet resultSet = statement.executeQuery(query);

            var meta = resultSet.getMetaData();
//            for (int i = 1; i <= meta.getColumnCount(); i++) {
//                System.out.printf("%d %s %s%n",
//                        i,
//                        meta.getColumnName(i),
//                        meta.getColumnTypeName(i)
//                );
//            }
            System.out.println("===================");

            for (int i = 1; i <= meta.getColumnCount(); i++) {
                System.out.printf("%-15s", meta.getColumnName(i).toUpperCase());
            }
            System.out.println();

            while (resultSet.next()) {
//                System.out.printf("%d %s %n", resultSet.getInt(1),
//                        resultSet.getString("artist_name")
//                System.out.printf("%d %s %s %n",
//                        resultSet.getInt("track_number"),
//                        resultSet.getString("artist_name"),
//                        resultSet.getString("song_title")
//                );
                for (int i = 1; i <= meta.getColumnCount(); i++) {
                    System.out.printf("%-15s", resultSet.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
