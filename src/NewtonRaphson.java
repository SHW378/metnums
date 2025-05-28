public class NewtonRaphson {

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
        double x = x0;
        int iter = 0;

        while (Math.abs(f(x)) > tol && iter < maxIter) {
            double fx = f(x);
            double dfx = df(x);

            if (dfx == 0) {
                System.out.println("Error: derivada cero en x = " + x);
                break;
            }

            x = x - fx / dfx;
            iter++;
        }

        if (iter == maxIter) {
            System.out.println("No se alcanzó la tolerancia en " + maxIter + " iteraciones.");
        }

        return x;
    }

    // Método principal
    public static void main(String[] args) {
        System.out.println("Método de Newton-Raphson para encontrar raíces de f(x) = x^2 - 2");
        System.out.println("La derivada es f'(x) = 2x");

        double x0 = 1.0; // Valor inicial
        System.out.print("Valor inicial (x0): " + x0 + "\n");
        double tol = 1e-6; // Tolerancia deseada
        System.out.println("Tolerancia: " + tol);
        int maxIter = 100; // Máximo de iteraciones
        System.out.println("Número máximo de iteraciones: " + maxIter);

        double raiz = newtonRaphson(x0, tol, maxIter);
        System.out.printf("\nRaíz aproximada: %.6f%n", raiz);
    }
}
