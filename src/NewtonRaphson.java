public class NewtonRaphson {

    // Función f(x) = x^2 - 2
    public static double f(double x) {
        return x * x - 2;
    }

    // Derivada f'(x) = 2x
    public static double df(double x) {
        return 2 * x;
    }

    // Método de Newton-Raphson
    public static double newtonRaphson(double x0, double tol, int maxIter) {
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
        double x0 = 1.0; // Valor inicial
        double tol = 1e-6; // Tolerancia deseada
        int maxIter = 100; // Máximo de iteraciones

        double raiz = newtonRaphson(x0, tol, maxIter);
        System.out.printf("Raíz aproximada: %.6f%n", raiz);
    }
}
