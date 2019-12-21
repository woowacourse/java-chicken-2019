package service;

import domain.Table;

import java.util.List;

public class ProgramFinisher extends Service {

    public ProgramFinisher() {
        super(3, "프로그램 종료");
    }

    public void run(List<Table> tables) {
        System.exit(0);
    }

}
