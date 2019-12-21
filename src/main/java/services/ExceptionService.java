package services;

import domain.MenuRepository;
import domain.TableRepository;
import exceptions.OutOfNumberException;

import java.util.Scanner;

public class ExceptionService {
    private static Scanner scanner = new Scanner(System.in);
    private static Integer input;

    public static Integer handleExceptionOfMenuNumber() {
        try {
            input = scanner.nextInt();
            MenuRepository.isIntInMenus(input);
        } catch (OutOfNumberException e) {
            System.out.println("없는 메뉴입니다");
        }
        return input;
    }

    public static Integer handleExceptionOfTableNumber() {
        try {
            input = scanner.nextInt();
            TableRepository.isIntInTables(input);
        } catch (OutOfNumberException e) {
            System.out.println("없는 테이블입니다");
        }
        return input;
    }
}
