package by.aleksandrov.api.homework6;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

/**
 * Класс описывает котиков и позволяет их сравнивать друг с другом*/
public class Cat {
    private String name;
    private double weight;
    private String coatColor;
    private String eyesColor;
    private String breed;

    /**
     * @param name Кличка котика
     * @param coatColor Цвет шерсти
     * @param eyesColor Цвет глаз
     * @param weight Вес
     * @param breed Порода. Записывается на английском языке в соответствии с таблицей пород (метод showAllBreeds())
     * @note Все строковые аргументы не чувствительны к регистру
     * */
    public Cat(String name, String coatColor, String eyesColor, double weight, String breed)
            throws IOException, CsvValidationException {
        this.name = name.toLowerCase();
        this.coatColor = coatColor.toLowerCase();
        this.eyesColor = eyesColor.toLowerCase();
        if (compare(breed)) this.breed = breed.toLowerCase();
        else throw new RuntimeException("Такой породы не существует");
        if (weight > 18) {
            throw new RuntimeException("Самый большой кот весил 18 кг. Этот рекорд не побить никому");
        } else if (weight <= 0) {
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

    /**
     * @param breed Порода. Записывается на английском языке в соответствии с таблицей пород (метод showAllBreeds())
     * */
    public void setBreed(String breed) throws IOException, CsvValidationException{
        if (compare(breed)) this.breed = breed.toLowerCase();
        else throw new RuntimeException("Такой породы не существует");
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

    private @NotNull String capitalize(@NotNull String str) {
        return str.substring(0,1).toUpperCase() + str.substring(1);
    }

    /**
     * Выводит перечень всех пород котиков с описанием*/
    public static void showAllBreeds() throws IOException, CsvValidationException {
        FileReader reader = new FileReader("cat_breeds.csv");
        CSVReader csvReader = new CSVReaderBuilder(reader)
                .withSkipLines(1)
                .build();

        String[] line;
        while ((line = csvReader.readNext()) != null) {
            System.out.println(Arrays.toString(line));
        }
        reader.close();
        csvReader.close();
    }

    private boolean compare(String breed) throws IOException, CsvValidationException {
        FileReader reader = new FileReader("cat_breeds.csv");
        CSVReader csvReader = new CSVReader(reader);

        String[] line;
        while ((line = csvReader.readNext()) != null) {
            String l = Arrays.toString(line);
            String res = l.substring(1, l.indexOf(","));
            if (res.equals(breed)) {
                return true;
            }
        }
        reader.close();
        csvReader.close();
        return false;
    }
}
