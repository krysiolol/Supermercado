import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= 5; i++) {
            System.out.print("Ingrese el nombre del cliente " + i + ": ");
            String nombre = scanner.nextLine();

            double precioTotalSinIVA = 0;

            for (int j = 1; j <= 3; j++) {
                System.out.print("Ingrese el artículo que ha comprado " + nombre + ": ");
                String articulo = scanner.nextLine();
                double precio = obtenerPrecioArticulo(articulo);
                if (precio != -1) {
                    precioTotalSinIVA += precio;
                } else {
                    System.out.println("Artículo no encontrado: " + articulo);
                }
            }

            double precioTotalConIVA = calcularPrecioConIVA(precioTotalSinIVA);

            mostrarBolsaDeCompra(nombre, precioTotalSinIVA, precioTotalConIVA);
        }
    }

    // Función para obtener el precio de un artículo
    public static double obtenerPrecioArticulo(String articulo) {
        switch (articulo.toLowerCase()) {
            case "pan":
                return 1.25;
            case "aceite":
                return 8.0;
            case "patatas":
                return 2.30;
            case "aceitunas":
                return 3.50;
            case "nestea":
                return 1.80;
            case "whiskey":
                return 14.90;
            case "hielo":
                return 3.50;
            default:
                return -1; // Devuelve -1 si el artículo no se encuentra en la lista
        }
    }

    // Función para calcular el precio con IVA
    public static double calcularPrecioConIVA(double precioSinIVA) {
        double iva = 0.21;
        return precioSinIVA + (precioSinIVA * iva);
    }

    // Función para mostrar la bolsa de compra de un cliente
    public static void mostrarBolsaDeCompra(String nombre, double precioSinIVA, double precioConIVA) {
        System.out.println("Bolsa de compra de " + nombre + ":");
        System.out.println("Precio total sin IVA: " + precioSinIVA + "€");
        System.out.println("Precio total con IVA (21%): " + precioConIVA + "€");
        System.out.println();
    }
}