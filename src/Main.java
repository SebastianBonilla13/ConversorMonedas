import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Gson gson = new GsonBuilder().
                setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        Map<Integer,String> mapMonedas = new HashMap<>();
        mapMonedas.put(1, "ARS");
        mapMonedas.put(2, "BOB");
        mapMonedas.put(3, "BRL");
        mapMonedas.put(4, "CLP");
        mapMonedas.put(5, "COP");
        mapMonedas.put(6, "USD");

        ConsultarMoneda consulta = new ConsultarMoneda();

        String strMonedas = """
                1) ARS - Peso argentino
                2) BOB - Boliviano boliviano
                3) BRL - Real brasileño
                4) CLP - Peso chileno
                5) COP - Peso colombiano
                6) USD - Dólar estadounidense
                7) Salir.
                """;

        int opc = -1;

        Scanner input = new Scanner(System.in);

        System.out.println("------------------------------------- \n" +
                "Bienvenido al Conversor de Monedas \n");

        MonedaOmdb objmonedaOmdb;

        while(opc != 7){

            try{

                System.out.println("Seleccione entre las siguientes divisas: \n");
                System.out.println(strMonedas);

                System.out.println("Digite el número de la Divisa a Cambiar: ");
                opc =  Integer.valueOf(input.nextLine());


                String divisaActual = mapMonedas.get(opc);
                System.out.println("Divisa Actual: "+divisaActual);



                System.out.println("\nDigite el número de la Divisa a Cambiar: ");
                //System.out.println(strMonedas);
                opc =  Integer.valueOf(input.nextLine());

                String divisaCambiar = mapMonedas.get(opc);
                System.out.println("Divisa a Cambiar: "+divisaCambiar);

                System.out.println("Ingrese Monto en "+divisaActual+": ");
                double monto = Double.valueOf(input.nextLine());

                objmonedaOmdb = consulta.buscaMoneda(divisaActual);
                Double cambio = objmonedaOmdb.conversion_rates().get(divisaCambiar);

                System.out.println("\nMonto es: "+monto);

                System.out.println("Tasa de cambio: "+cambio);

                Double conversion = monto * cambio;

                // Crear el formato con separación de miles
                DecimalFormat formato = new DecimalFormat("#,###.00");

                String conversionFormato = formato.format(conversion);

                System.out.println("De "+divisaActual+" a "+divisaCambiar);

                System.out.println("Conversión: "+conversionFormato+" "+divisaCambiar);

                System.out.println("\n Ingrese cualquier tecla para contiunar con otra conversión.");

                // Crear un objeto Scanner para leer la entrada del usuario
                Scanner scanner = new Scanner(System.in);

                // Esperar a que el usuario presione tecla
                scanner.nextLine();

            }catch(NumberFormatException e){
                System.out.println("Formato de dato incorrecto. Ingrese nuevamente.");

                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
            }

        }







    }
}