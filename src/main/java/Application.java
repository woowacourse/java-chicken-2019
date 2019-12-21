import controller.Pos;
import domain.MenuRepository;
import domain.TableRepository;

public class Application {

  public static void main(String[] args) {
    Pos pos = new Pos(TableRepository.tables(), MenuRepository.menus());

    pos.start();
  }
}
