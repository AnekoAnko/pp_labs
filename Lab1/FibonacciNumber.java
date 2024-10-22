import java.util.Scanner;

/**
 * Клас для обробки та обчислення чисел Фібоначчі.
 * Цей клас зберігає номер та значення числа Фібоначчі і містить методи для
 * їхнього обчислення та сумування.
 */
public class FibonacciNumber {
    private int index;  // Номер числа Фібоначчі
    private int value;  // Значення числа Фібоначчі

    /**
     * Конструктор класу FibonacciNumber.
     * Ініціалізує об'єкт з номером і значенням числа Фібоначчі.
     *
     * @param index Номер числа Фібоначчі.
     * @param value Значення числа Фібоначчі.
     */
    public FibonacciNumber(int index, int value) {
        this.index = index;
        this.value = value;
    }

    /**
     * Отримати номер числа Фібоначчі.
     *
     * @return Номер числа Фібоначчі.
     */
    public int getIndex() {
        return index;
    }

    /**
     * Отримати значення числа Фібоначчі.
     *
     * @return Значення числа Фібоначчі.
     */
    public int getValue() {
        return value;
    }

    /**
     * Метод для обчислення перших N чисел Фібоначчі і збереження їх у масиві.
     *
     * @param n Кількість чисел Фібоначчі.
     * @return Масив значень чисел Фібоначчі.
     */
    public static int[] calculateFibonacci(int n) {
        int[] fibonacciNumbers = new int[n];
        if (n > 0) fibonacciNumbers[0] = 1;
        if (n > 1) fibonacciNumbers[1] = 1;

        for (int i = 2; i < n; i++) {
            fibonacciNumbers[i] = fibonacciNumbers[i - 1] + fibonacciNumbers[i - 2];
        }
        return fibonacciNumbers;
    }

    /**
     * Метод для обчислення суми масиву чисел Фібоначчі.
     *
     * @param fibonacciNumbers Масив чисел Фібоначчі.
     * @return Сума перших N чисел Фібоначчі.
     */
    public static long sumOfFibonacci(int[] fibonacciNumbers) {
        long sum = 0;
        for (int num : fibonacciNumbers) {
            sum += num;
        }
        return sum;
    }

    /**
     * Головна функція програми, яка зчитує кількість чисел Фібоначчі від користувача,
     * обчислює їх та виводить результат.
     *
     * @param args Аргументи командного рядка.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a count of numbers: ");
        int n = scanner.nextInt();

        // Обчислюємо серію чисел Фібоначчі
        int[] fibonacciSeries = calculateFibonacci(n);

        // Створюємо масив об'єктів FibonacciNumber
        FibonacciNumber[] fibonacciNumbers = new FibonacciNumber[n];
        for (int i = 0; i < n; i++) {
            fibonacciNumbers[i] = new FibonacciNumber(i, fibonacciSeries[i]);
        }

        // Виводимо числа Фібоначчі
        System.out.println("Fibonacci Numbers:");
        for (FibonacciNumber fibNumber : fibonacciNumbers) {
            System.out.printf("F(%d) = %d\n", fibNumber.getIndex(), fibNumber.getValue());
        }

        // Підраховуємо і виводимо суму
        long sum = sumOfFibonacci(fibonacciSeries);
        System.out.printf("Sum of %d Fibonacci numbers = %d\n", n, sum);
    }
}
