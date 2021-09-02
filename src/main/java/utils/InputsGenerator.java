package utils;

import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class InputsGenerator {

    private static final SecureRandom random = new SecureRandom();
    private static final String ruChars = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String latChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String space = " ";
    private static final String specChars = "♣☺♂»,«»‘~!@#$%^&*()?>,./\\][/*!—«»,«${}»;—";
    private static final int defaultLenght = 77;
    private static final int shortStringLenght = 8;

    @Step("Получить отметку времени")
    public static String getTimestamp(){
        return (new SimpleDateFormat("YYMMddHHmmss")).format(new Date());
    }

    @Step("Преобразовать число в строку")
    public static String getNumAsStr(int From, int To){
        return Integer.toString(random.nextInt((To - From) + 1) + From);
    }

    public static <T extends Enum<?>> T getRandomFromEnum(Class<T> clazz){
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

    public static <T> T getRandomFromList(List<T> givenList){
        return givenList.get(random.nextInt(givenList.size()));
    }

    public static boolean getRandomBool(){
        return random.nextBoolean();
    }
    @Step("Получить строку из латинских букв без пробелов выбранной длины")
    public static String getLatinStrWithoutSpaces(int count){
        return RandomStringUtils.random(count, latChars);
    }

    @Step("Получить строку из латинских букв без пробелов короткой длины")
    public static String getShortLatinStr(){
        return getLatinStrWithoutSpaces(shortStringLenght);
    }

    @Step("Получить строку из латинских букв без пробелов c длиной по-умлчанию")
    public static String getLatinStrWithoutSpaces(){
        return RandomStringUtils.random(defaultLenght);
    }

    @Step("Получить строку из латинских букв с пробелами выбранной длины")
    public static String getLatinStrWithSpaces(int count){
        return RandomStringUtils.random(count, latChars + space).replace(" ", " ").trim();
    }

    @Step("Получить строку из русских букв без пробелов выбранной длин")
    public static String getCyrillicStrWithoutSpaces(int count){
        return RandomStringUtils.random(count, ruChars);
    }

    @Step("Получить строку из русских букв без пробелов короткой длины")
    public static String getShortCyrillicStr(){
        return getCyrillicStrWithoutSpaces(shortStringLenght);
    }

    @Step("Получить строку из русских букв без пробелов c длиной по-умлчанию")
    public static String getCyrillicStrWithoutSpaces(){
        return getCyrillicStrWithoutSpaces(defaultLenght);
    }

    @Step("Получить строку из русских букв с пробелами выбранной длины")
    public static String getCyrillicStrWithSpaces(int count){
        return RandomStringUtils.random(count, ruChars + space).replace(" ", " ").trim();
    }

    @Step("Получить строку из латинских букв с пробелами выбранной длины с фиксированным текстом")
    public static String getLatinStrWithSpacesAndTestName(int count, String testName){
        return (testName.replace(" ", " ").trim() + " " + RandomStringUtils.random(count, latChars).replace(" ", "").trim());
    }

    @Step("Получить строку из спецсимволов без пробелов выбранной длины")
    public static String  getSpecCharStrWithSpaces(int count){
        return RandomStringUtils.random(count, specChars);
    }

    @Step("Получить рандомный майл")
    public static String getRandomEmail(){
        return getShortLatinStr() + "@" + getShortLatinStr() + ".ru";
    }
}
