package com.example.command;

import com.example.service.InitDbService;

public class InitDbCommand {

    InitDbService initDbService = new InitDbService();

    public void initDb() {
        initDbService.initDb();
    }
}
