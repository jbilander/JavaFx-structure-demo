package com.example.mediator;

import com.example.command.InitDbCommand;

public class RootMediator implements IRootMediator {

    InitDbCommand initDbCommand = new InitDbCommand();

    @Override
    public void initDb() {
        initDbCommand.initDb();
    }
}
