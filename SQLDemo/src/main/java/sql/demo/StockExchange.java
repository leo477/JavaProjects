package sql.demo;

import sql.demo.repository.ShareRates;
import sql.demo.repository.SharesRepository;
import sql.demo.repository.Traiders;
import sql.demo.repository.TraidersActions;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StockExchange {
    public static final String DB_URL = "jdbc:h2:\\Users\\zahar\\IdeaProjects\\SQLDemo\\db";
    public static final String DB_Driver = "org.h2.Driver";

    private SharesRepository sharesRepository;
    private ShareRates shareRates;
    private Traiders traiders;
    private TraidersActions traidersActions;

    public StockExchange() throws ClassNotFoundException, SQLException {
        Class.forName(DB_Driver);
        this.sharesRepository = new SharesRepository();
        this.shareRates= new ShareRates();
        this.traiders=new Traiders();
        this.traidersActions=new TraidersActions();
    }

    public static void main(String[] args) {
        try {
            StockExchange stockExchange = new StockExchange();
            stockExchange.createTables();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("JDBC драйвер для СУБД не найден!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Ошибка SQL !");
        }
    }

    public static Connection getConnection() throws SQLException {
        String user="testUser";
        String pass="12345qwerty12345";
        String conn="jdbc:mysql://localhost:3306/university";
        //Connection connection = DriverManager.getConnection(DB_URL);
        Connection connection= DriverManager.getConnection(conn,user,pass);
        System.out.println("Connect to DB Success");
        return connection;
    }

    private void createTables() throws SQLException {
        sharesRepository.createTable();
        shareRates.createTable();
        shareRates.createForeignKeys();
        traiders.createTable();
        traidersActions.createTable();
        traidersActions.createForeignKeys();
    }
}
