public class Converter {

    double convertKm(int stepsPerMonth) {
        double distanceInKM = (stepsPerMonth * 75) / 10000;
        return distanceInKM;
    } //Конвертация количества пройденных шагов за месяц в километры
    double convertCalories(int stepsPerMonth) {
        double caloriesBurned = (stepsPerMonth * 50) / 1000;
        return caloriesBurned;
    } //Конвертация количества пройденных шагов за месяц в килокалории

}
