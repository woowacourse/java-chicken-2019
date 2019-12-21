import Service.PosService;

public class Application {
    public static void main(String[] args) {
        PosService posService = new PosService();
        posService.run();
    }
}
