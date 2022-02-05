package sql.demo.repository;

import java.sql.SQLException;

public class Traiders extends BaseTable implements TableOperations{

    public Traiders() throws SQLException {
        super("traiders");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS traiders(" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                "name VarCHAR(255) NOT NULL," +
                "sfreqTick  INTEGER NOT NULL," +
                "cash DECIMAL(8,2) NOT NULL DEFAULT 1000," +
                "tradingMethod INTEGER NOT NULL," +
                "changeProbability INTEGER NOT NULL DEFAULT 50," +
                "about VARCHAR(255) NOT NULL)","Созданная таблица " + getTableName());

        super.executeSqlStatement("ALTER TABLE traiders ADD CONSTRAINT check_traiders_traidingMethod " +
                "CHECK(tradingMethod IN (1,2,3));","Созданная таблица " + getTableName());
        super.executeSqlStatement("ALTER TABLE traiders ADD CONSTRAINT check_traiders_changeProbability " +
                "CHECK(changeProbability<=100 and changeProbability>0);","Созданная таблица " + getTableName());

    }

    @Override
    public void createForeignKeys() throws SQLException {

    }
}
