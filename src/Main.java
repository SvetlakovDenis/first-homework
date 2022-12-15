import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вас приветствует счётчик калорий версии 1.0! :)");
        outputOptionList();
        int initialSteps = 0;
        int initialGoal = 10000;
        StepTracker stepTracker = new StepTracker(initialSteps, initialGoal);
        int userInput = scanner.nextInt();
        while (userInput != 0) {
            if (userInput == 1) {
                inputNewSteps(scanner, stepTracker);
            }
            if (userInput == 2) {
                System.out.println("За какой месяц вывести статистику?");
                stepTracker.outputStatistics(outputMonthData(scanner));
            }
            if (userInput == 3) {
                changeGoal(scanner, stepTracker);
            }
            if (userInput < 0 || userInput > 3) {
                System.out.println("Данная опция недоступна. Повторите выбор.");
            }
            outputOptionList();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    } //Основной блок

    static void outputOptionList() {
        System.out.println("Выберите действие:");
        System.out.println("1 - Ввести количество шагов за день.");
        System.out.println("2 - Вывести статистику за месяц.");
        System.out.println("3 - Установка целевого количества шагов.");
        System.out.println("0 - Выход из приложения.");
    } //Метод выводит меню приложения

    static void inputNewSteps(Scanner scanner, StepTracker stepTracker) {
        int month = outputMonthData(scanner);
        int day = outputDayData(scanner);
        System.out.println("Введите количество шагов, пройденных за день.");
        stepTracker.inputSteps(month, day, objectivityTest(scanner));
        System.out.println("Данные сохранены!");
    } //Метод запрашивает у пользователя данные о вводимом количестве шагов (дату, количество шагов)

    static int objectivityTest(Scanner scanner) {
        while (true) {
            int steps = scanner.nextInt();
            if (steps >= 0) {
                return steps;
            } else {
                System.out.println("Введено некорректное значение.");
            }
        }
    } //Метод проверяет вводимые данные полязователя

    static int outputMonthData(Scanner scanner) {
        while (true) {
            System.out.println("Введите номер месяца от 0 до 11, где 0 - январь, а 11 - декабрь");
            int month = scanner.nextInt();
            if (month >=0 && month <= 11) {
                return month;
            } else {
                System.out.println("Введено некорректное значение месяца. Повторите ввод.");
            }
        }
    } // Метод проверяет корректность данных о месяце

    static int outputDayData (Scanner scanner) {
        while (true) {
            System.out.println("Введите день (от 1 до 30)");
            int day = scanner.nextInt();
            if (day >= 1 && day <= 30) {
                return day;
            } else {
                System.out.println("Введено некорректное значение дня. Повторите ввод.");
            }
        }
    } //Метод проверяет корректность данных о дне

    static void changeGoal(Scanner scanner, StepTracker stepTracker) {
        System.out.println("В каком периоде задать цель для количества шагов?");
        System.out.println("1 - За год.");
        System.out.println("2 - За месяц.");
        System.out.println("3 - За определенный день.");
        int newUserInput = scanner.nextInt();
        int month, day;
        if (newUserInput == 1) {
            System.out.println("Введите новое целевое значение шагов.");
            stepTracker.changeYearGoal(objectivityTest(scanner));
        } else if (newUserInput == 2) {
            System.out.println("В каком месяце изменить цель по количеству шагов?");
            month = outputMonthData(scanner);
            System.out.println("Введите новое целевое значение шагов.");
            stepTracker.changeMonthGoal(month, objectivityTest(scanner));
        } else if (newUserInput == 3) {
            System.out.println("В каком месяце изменить цель по количеству шагов?");
            month = outputMonthData(scanner);
            System.out.println("За какой день изменить цель для количества шагов?");
            day = outputDayData(scanner);
            System.out.println("Введите новое целевое значение шагов.");
            stepTracker.changeDayGoal(month, day, objectivityTest(scanner));
        }
    } //Метод собирает данные о смене цели количества шагов и отправляет их в обработку
}