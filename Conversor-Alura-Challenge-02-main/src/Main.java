
public class Main {
    public static void main(String[] args) {
        ApiRequest request = new ApiRequest();
        Menu menu = new Menu(request);
        menu.displayMenu();
        System.out.println("--- Historial de Intercambios ---");
        menu.getHistory().forEach(System.out::println);

    }
}