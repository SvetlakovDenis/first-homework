public class StepTracker {
    MonthData[] stepsNumber, stepsGoal;

    StepTracker(int initialValue, int initialGoal) {
        stepsNumber = new MonthData[12];
        stepsGoal = new MonthData[12];
        for (int i = 0; i < stepsNumber.length; i++) {
            stepsNumber[i] = new MonthData();
            stepsGoal[i] = new MonthData();
        }
        for (int i = 0; i < stepsNumber.length; i++) {
            stepsNumber[i].initiateStartValue(initialValue);
            stepsGoal[i].initiateStartValue(initialGoal);
        } // Задаем начальное значение для массивов (0 для шагов и 10000 для целей)
    }

    void inputSteps(int month, int day, int steps) {
        stepsNumber[month].changeStepsNumber(day, steps);
    } // В нужной ячейке месяца в массиве счетчика шагов используем метод по изменению значения шагов в нужной ячейке дня

    void outputStatistics(int month) {
        System.out.println("Статистика за " + month + " месяц:");
        System.out.println(stepsNumber[month].stepsList());
        System.out.println("Общее количество шагов за месяц: " + stepsNumber[month].stepsCounter());
        System.out.println("Максимальное пройденое количество шагов в месяце: " + stepsNumber[month].maxSteps());
        System.out.println("Среднее количество шагов за месяц: " + stepsNumber[month].averageSteps());
        Converter convert = new Converter();
        System.out.println("Пройденная дистанция (в км): " + convert.convertKm(stepsNumber[month].stepsCounter()));
        System.out.println("Сожжённые калории за месяц: " + convert.convertCalories(stepsNumber[month].stepsCounter()));
        System.out.println("Самая длинная серия: " + maxSeries(month));
    } //Вывод статистики

    int maxSeries(int month) {
        int maxSeries = 0;
        int series = 0;
        for (int i = 0; i < 30; i++) {
            if (stepsNumber[month].outputValue(i) > stepsGoal[month].outputValue(i)) {
                series++;
            } else {
                if (maxSeries < series) {
                    maxSeries = series;
                }
                series = 0;
            }
        }
        if (maxSeries < series) {
            maxSeries = series;
        }
        return maxSeries;
    } //Поиск максимальной серии
    void changeYearGoal(int steps) {
        for (int i = 0; i < stepsGoal.length; i++) {
            stepsGoal[i].initiateStartValue(steps);
        }
    } // Данный метод позволяет менять цель по количеству шагов за весь период

    void changeMonthGoal(int month, int steps) {
        stepsGoal[month].initiateStartValue(steps);
    } // Данный метод позволяет менять цель по количеству шагов за месяц

    void changeDayGoal(int month, int day, int steps) {
        stepsGoal[month].changeStepsNumber(day, steps);
    } // Данный метод позволяет менять цель по количеству шагов за определенный день
}
