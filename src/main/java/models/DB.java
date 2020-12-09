package models;

import org.sql2o.*;

public class DB {
    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_trackers", "moringa", "wangeci");

//static String connectionString = "jdbc:postgresql://ec2-18-233-207-22.compute-1.amazonaws.com:5432/df2ubtmuhc32s7";
//  public static   Sql2o sql2o = new Sql2o(connectionString, "moofzkehivkcht", "1a69ef9f9640d56386658105bbae0155395c98d1bbc5e049d045170f7759ee15");
}