public class MonthData {
    int[] data;

    public MonthData() {
        data = new int[30];
    } //Создаем массив дней

    void initiateStartValue(int initialValue) {
        for (int i = 0; i < data.length; i++) {
            data[i] = initialValue;
        }
    } //Задается начальное значение для всех дней

    void changeStepsNumber(int day, int newStepsNumber) {
        data[day - 1] = newStepsNumber;
    } //В нужной ячейке дня меняем значение шагов

    String stepsList() {
        String stepsList = "";
        for (int i = 1; i <= data.length; i++) {
            stepsList = stepsList + i + " день: " + data[i-1] + ", ";
        }
        return stepsList;
    } //Формирует строку с данными по шагам за месяц

    int stepsCounter() {
        int stepsCounter = 0;
        for (int i = 0; i < data.length; i++) {
            stepsCounter = stepsCounter + data[i];
        }
        return stepsCounter;
    } //Метод считает общее количество шагов за месяц

    int maxSteps() {
        int maxSteps = 0;
        for (int i = 0; i < data.length; i++) {
            if (maxSteps < data[i]) {
                maxSteps = data[i];
            }
        }
        return maxSteps;
    } //Метод ищет максимальное количество шагов в месяце

    int averageSteps() {
        int averageSteps = stepsCounter() / data.length;
        return averageSteps;
    } //Метод ищет среднее количество шагов за месяц

    int outputValue(int day) {
        return data[day];
    } //Возвращение значения количества шагов за определенный день




}
