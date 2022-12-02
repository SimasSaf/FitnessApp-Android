package fitnessapp.android.entities;

public class Food {

    private String name;
    private int kcal, protein, carbs, fat, day, month, year;

    public Food() {
    }

    public Food(String name, int kcal, int protein, int carbs, int fat) {
        this.name = name;
        this.kcal = kcal;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
        this.day = 0;
        this.month = 0;
        this.year = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getCarbs() {
        return carbs;
    }

    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
