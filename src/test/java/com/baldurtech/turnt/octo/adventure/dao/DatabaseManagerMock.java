package com.baldurtech.turnt.octo.adventure.dao;

public class DatabaseManagerMock implements DatabaseManager {
    public String executeUpdateParam;
    public Object[] executeUpdateParam2;
    public int executeUpdateShouldReturn = 0;

    public int executeUpdate(String sql, Object... params) {
        executeUpdateParam = sql;
        executeUpdateParam2 = params;
        return executeUpdateShouldReturn;
    }
}
