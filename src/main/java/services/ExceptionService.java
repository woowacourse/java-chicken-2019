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

    public static Integer handleExceptionOfMenuQuantity() {
        final Integer MAX_QUANTITY = 99;

        try {
            input = scanner.nextInt();
            if (input > MAX_QUANTITY) {
                throw new OutOfNumberException();
            }
        } catch (OutOfNumberException e) {
            System.out.println("99개 이하로만 주문 가능합니다");
        }
        return input;
    }

    public static Integer handExceptionOfMainFeature() {
        final Integer MIN_FEATURE = 1;
        final Integer MAX_FEATURE = 3;

        try {
            input = scanner.nextInt();
            if (input < MIN_FEATURE || input > MAX_FEATURE) {
                throw new OutOfNumberException();
            }
        } catch (OutOfNumberException e) {
            System.out.println("메뉴는 1-3번만 입력가능합니다다");        }
        return input;

    }
}
