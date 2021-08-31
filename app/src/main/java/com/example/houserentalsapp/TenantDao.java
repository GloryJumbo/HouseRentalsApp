package com.example.houserentalsapp;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface TenantDao {

    @Insert
    void registerTenant(TenantEntity tenantEntity);
}
