import java.util.Scanner;

public class NewtonRaphsonScanner {

    // Función f(x) = x^2 - 2
    private static double f(double x) {
        return x * x - 2;
    }

    // Derivada f'(x) = 2x
    private static double df(double x) {
        return 2 * x;
    }

    
    // Método de Newton-Raphson
    private static double newtonRaphson(double x0, double tol, int maxIter) {
        // Validación de parámetros
        double x = x0;
        int iter = 0;

        while (Math.abs(f(x)) > tol && iter < maxIter) {
            double fx = f(x);
            double dfx = df(x);
            
            if (dfx == 0) {
                System.out.println("Error: la derivada es cero en x = " + x);
                break;
            }

            x = x - fx / dfx;
            iter++;
        }

        if (iter == maxIter) {
            System.out.println("No se alcanzó la tolerancia en " + maxIter + " iteraciones.");
        } else {
            System.out.println("Iteraciones realizadas: " + iter);
        }

        return x;
    }

    // Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nMétodo de Newton-Raphson para encontrar raíces de f(x) = x^2 - 2");
        System.out.println("\nLa derivada es f'(x) = 2x");

        System.out.print("Ingrese el valor inicial (x0): ");
        double x0 = scanner.nextDouble();

        System.out.print("Ingrese la tolerancia (ej. 1e-6): ");
        double tol = scanner.nextDouble();

        System.out.print("Ingrese el número máximo de iteraciones: ");
        int maxIter = scanner.nextInt();

        double raiz = newtonRaphson(x0, tol, maxIter);
        System.out.printf("Raíz aproximada: %.6f%n", raiz);
        
        scanner.close();
    }
}

/*
Inicio

Solicitar al usuario:

El valor inicial x₀

La tolerancia deseada tol

El número máximo de iteraciones maxIter

Asignar x ← x₀

Inicializar iter ← 0

Repetir mientras:

|f(x)| > tol y

iter < maxIter

Hacer:

Calcular f(x)

Calcular f′(x)

Si f′(x) == 0, mostrar error y terminar

Calcular nueva aproximación:
x ← x − f(x)/f′(x)

Incrementar iter ← iter + 1

Si iter == maxIter, mostrar mensaje de que no se alcanzó la tolerancia

Mostrar la raíz aproximada y el número de iteraciones realizadas

Fin
 */
