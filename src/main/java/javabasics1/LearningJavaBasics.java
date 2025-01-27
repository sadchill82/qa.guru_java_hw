package javabasics1;

public class LearningJavaBasics {

    public static void main(String[] args) {

        // Задание 0. Применить несколько арифметических операций ( + , - , * , / ) над двумя примитивами типа int

        int firstNumber = 7;
        int secondNumber = 3;

        System.out.println(firstNumber + secondNumber);
        System.out.println(firstNumber - secondNumber);
        System.out.println(firstNumber * secondNumber);
        System.out.println(firstNumber / secondNumber);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");


        // Задание 1. Применить несколько арифметических операций над int и double в одном выражении

        double thirdNumber = 2.5;

        System.out.println(firstNumber + thirdNumber - secondNumber / thirdNumber);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");

        // Задание 2. Применить несколько логических операций ( < , > , >= , <= )

        System.out.println(firstNumber > secondNumber);
        System.out.println(firstNumber < thirdNumber);
        System.out.println(secondNumber + firstNumber <= thirdNumber);
        System.out.println(firstNumber >= thirdNumber + secondNumber);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");

        // Задание 3. Прочитать про диапазоны типов данных для вещественных / чисел с плавающей точкой (какие максимальные и минимальные значения есть, как их получить) и переполнение

        float maxFloatValue = Float.MAX_VALUE;
        System.out.println(maxFloatValue);
        float minFloatValue = Float.MIN_VALUE;
        System.out.println(minFloatValue);

        double maxDoubleValue = Double.MAX_VALUE;
        System.out.println(maxDoubleValue);
        double minDoubleValue = Double.MIN_VALUE;
        System.out.println(minDoubleValue);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");

        // Задание 4. Получить переполнение при арифметической операции

        System.out.println(maxFloatValue + 1);
        System.out.println(minFloatValue - 1);

        System.out.println(maxDoubleValue + 1);
        System.out.println(minDoubleValue - 1);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");

    }
}
