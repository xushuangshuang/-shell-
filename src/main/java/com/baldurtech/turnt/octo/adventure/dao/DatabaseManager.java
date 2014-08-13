package com.baldurtech.turnt.octo.adventure.dao;

public interface DatabaseManager {
    public int executeUpdate(String sql, Object... params);
}
