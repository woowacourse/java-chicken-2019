package controller;

import domain.OrderedTable;

import java.util.ArrayList;
import java.util.List;

public class PaymentController {
    public List<OrderedTable> orderedTables = new ArrayList<>();


    public void paymentController(List<OrderedTable> inputOrderedTables) {
        orderedTables = inputOrderedTables;


    }
}
