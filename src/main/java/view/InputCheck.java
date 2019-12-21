package view;

import domain.Main;
import domain.MainRepository;

public class InputCheck {

    public boolean numberCheck(String number){
        try{
            Integer.parseInt(number);
        }catch(Exception e){
            System.out.println("숫자를 입력해주세요.");
            return true;
        }

        return false;
    }

    public boolean mainInputCheck(String number){
        if(this.numberCheck(number)){
            return true;
        }
        int checkNumber = Integer.parseInt(number);

        for (Main main : MainRepository.mains()){
             if(main.mainInputCheck(checkNumber)){
                return false;
             }
        }
        System.out.println("1, 2, 3 중에 입력해주세요.");
        return true;
    }
}
