

import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

public class Menu {
    private ApiRequest request;
    private Map<Integer, String> options;
    private final String[] menuOptions;
    private ArrayList<Exchange> history;

    public Menu(ApiRequest request){
        this.request = request;
        this.options = new HashMap<>();

        options.put(1, "USD");
        options.put(2, "ARS");
        options.put(3, "BRL");
        options.put(4, "COP");
        options.put(5, "EUR");

        this.menuOptions = new String[]{"USD (Dólar Estadounidense)",
                "ARS (Peso Argentino)",
                "BRL (Real Brasileño)",
                "COP (Peso Colombiano)",
                "EUR (Euro)"};
        this.history = new ArrayList<>();

    }
    public void displayMenu(){
        Scanner scan = new Scanner(System.in);

        int userRequest = 0;
        float userValue = 0;

            while (true){
                try{
                    this.displayOptions();

                    userRequest = scan.nextInt();

                    if(options.containsKey(userRequest)){
                        Exchange coin = new Exchange();
                        coin.setBase_code(options.get(userRequest));
                        this.displayExchange(userRequest);
                        userRequest = scan.nextInt();

                        if(options.containsKey(userRequest)){
                            coin.setTarget_code(options.get(userRequest));
                            System.out.println("Introduce el valor de la moneda base: ");
                            userValue = scan.nextFloat();
                            coin.setBase_value(userValue);
                            try{
                                ExchangeRate exchange_rate = this.request.searchRate(coin.getBase_code(), coin.getTarget_code());
                                coin.obtainValue(exchange_rate.conversion_rate());
                                System.out.println("Conversión realizada con exito!");
                                System.out.println(coin);
                                this.history.add(coin);
                            } catch (RuntimeException e){
                                System.out.println("Error al obtener la tasa de conversión: "+ e.getMessage());
                            }
                        }else {
                            System.out.println("La opción digitada no existe...");
                        }

                    }
                    else if(userRequest == 0){
                        System.out.println("Saliendo...");
                        break;
                    }else{
                        System.out.println("La opción digitada no existe...");
                    }
                }catch (InputMismatchException e){
                    System.out.println("Por favor, ingrese un número valido...");
                    scan.nextLine();
                }


            }

    }

    public void displayOptions(){
        System.out.println("-----------------------");
        System.out.println("Conversor de Monedas : ");
        System.out.println("Seleccione la moneda base (1-5):");
        IntStream.range(0, menuOptions.length).forEach(i -> System.out.println((i+1)+". "+ menuOptions[i]));
        System.out.println("0. Salir...");
    }

    public void displayExchange(int option){
        System.out.println("-----------------------");
        System.out.println("Seleccione la moneda a cambiar (1-4):");
        IntStream.range(0, menuOptions.length).forEach(i -> {
                if(i != option-1) {
                     System.out.println((i + 1) + ". " + menuOptions[i]);
                }
            });
        System.out.println("0. Salir...");
        }

    public ArrayList<Exchange> getHistory() {
        return history;
    }

}

