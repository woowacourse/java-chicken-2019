import domain.Pos;

public class Application {
    public static void main(String[] args) {
        final int EXIT_CODE = 3;
        Pos pos = new Pos();
        int exitCode = EXIT_CODE;

        do {
            exitCode = pos.pos();
        } while (exitCode != EXIT_CODE);
    }
}
