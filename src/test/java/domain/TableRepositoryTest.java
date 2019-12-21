package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class TableRepositoryTest {

    @Test
    public void createTest(){
        List<Table> tables = TableRepository.tables();
        assertThat(tables).hasSize(6);
        for(Table table : tables){
            System.out.println(table.toString());
        }
    }
}