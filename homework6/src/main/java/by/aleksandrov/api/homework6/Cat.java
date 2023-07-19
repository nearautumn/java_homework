package by.aleksandrov.api.homework6;

import java.util.Objects;

public class Cat {
    private String name;
    private double weight;
    private String coatColor;
    private String eyesColor;
    private String breed;


    public Cat(String name, String coatColor, String eyesColor, double weight, String breed) {
        this.name = name.toLowerCase();
        this.coatColor = coatColor.toLowerCase();
        this.eyesColor = eyesColor.toLowerCase();
        this.breed = breed.toLowerCase();
        if (weight > 18) {
            throw new RuntimeException("Самый большой кот весил 18 кг. Этот рекорд не побить никому");
        } else if (weight < 0) {
            throw new RuntimeException("Антикотов не существует");
        }
        else this.weight = weight;
    }

    public Cat() {}

    public String getName() {
        return capitalize(name);
    }

    public void setName(String name) {
        this.name = name.toLowerCase();
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight > 18) {
            throw new RuntimeException("Самый большой кот весил 18 кг. Этот рекорд не побить никому");
        } else if (weight < 0) {
            throw new RuntimeException("Антикотов не существует");
        }
        else this.weight = weight;
    }

    public String getCoatColor() {
        return capitalize(coatColor);
    }

    public void setCoatColor(String coatColor) {
        this.coatColor = coatColor.toLowerCase();
    }

    public String getEyesColor() {
        return capitalize(eyesColor);
    }

    public void setEyesColor(String eyesColor) {
        this.eyesColor = eyesColor.toLowerCase();
    }

    public String getBreed() {
        return capitalize(breed);
    }

    public void setBreed(String breed) {
        this.breed = breed.toLowerCase();
    }

    @Override
    public String toString() {
        return String.format("Имя: %s | Цвет шерсти: %s | Цвет глаз: %s | Вес: %.2f кг | Порода: %s \n",
                capitalize(name), capitalize(coatColor), capitalize(eyesColor), weight, capitalize(breed));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Double.compare(cat.weight, weight) == 0 && Objects.equals(name, cat.name)
                && Objects.equals(coatColor, cat.coatColor) && Objects.equals(eyesColor, cat.eyesColor)
                && Objects.equals(breed, cat.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, coatColor, eyesColor, breed);
    }

    private String capitalize(String str) {
        return str.substring(0,1).toUpperCase() + str.substring(1);
    }
}
