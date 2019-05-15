package ru.ifmo.cet.javabasics;


/**
 * Нужно реализовать констурктор и метод, возвращающий слова песни про бутылки на стене.
 * <p>
 * Слова следующие:
 * <p>
 * 99 bottles of beer on the wall, 99 bottles of beer
 * Take one down, pass it around, 98 bottles of beer
 * 98 bottles of beer on the wall, 98 bottles of beer
 * Take one down, pass it around, 97 bottles of beer
 * 97 bottles of beer on the wall, 97 bottles of beer
 * Take one down, pass it around, 96 bottles of beer
 * 96 bottles of beer on the wall, 96 bottles of beer
 * Take one down, pass it around, 95 bottles of beer
 * 95 bottles of beer on the wall, 95 bottles of beer
 * ...
 * <p>
 * 3 bottles of beer on the wall, 3 bottles of beer
 * Take one down, pass it around, 2 bottles of beer
 * 2 bottles of beer on the wall, 2 bottles of beer
 * Take one down, pass it around, 1 bottles of beer
 * 1 bottle of beer on the wall, 1 bottle of beer
 * Take one down, pass it around, no more bottles of beer on the wall
 * No more bottles of beer on the wall, no more bottles of beer
 * Go to the store and buy some more, 99 bottles of beer on the wall
 * <p>
 * Дело усложняется тем, что текст песни переменный:
 * За раз может быть взято несколько бутылок.
 * Значение передается в качестве параметра конструктора
 * Нужно ограничить возможность взятия бутылок натуральным число не более 99 бутылок за раз.
 */
class BottleSong
{
    private static final String[] tensNames = {
            "",
            "ten",
            "twenty",
            "thirty",
            "forty",
            "fifty",
            "sixty",
            "seventy",
            "eighty",
            "ninety"
    };
    private static final String[] numNames = {
            "",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen"
    };
    private final int bottleTakenAtOnce;

    public BottleSong(int bottleTakenAtOnce)
    {
        this.bottleTakenAtOnce = bottleTakenAtOnce;
    }

    public String getBottleSongLyrics()
    {
        if (bottleTakenAtOnce <= 0 || bottleTakenAtOnce > 99) {
            throw new IllegalArgumentException();
        }

        StringBuilder result = new StringBuilder();
        int bottleCounter;


        for (bottleCounter = 99; bottleCounter > bottleTakenAtOnce; bottleCounter -= bottleTakenAtOnce) {
            result.append(bottleCounter + " bottles of beer on the wall, " + bottleCounter + " bottles of beer.\n");
            result.append("Take " + getWordNumber(bottleTakenAtOnce) + " down and pass around, " + (bottleCounter - bottleTakenAtOnce) + (bottleCounter - bottleTakenAtOnce == 1 ? " bottle" : " bottles") + " of beer on the wall.\n");
        }

        result.append(bottleCounter + (bottleCounter == 1 ? " bottle" : " bottles") + " of beer on the wall, " + bottleCounter + (bottleCounter == 1 ? " bottle" : " bottles") + " of beer.\n");
        result.append("Take " + getWordNumber(bottleCounter) + " down and pass around, no more bottles of beer on the wall.\n");

        result.append("No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n");

        return result.toString();
    }

    private static String getWordNumber(int toStringNumber)
    {
        if (toStringNumber <= 19)
            return numNames[toStringNumber];
        else if (toStringNumber % 10 == 0)
            return tensNames[toStringNumber / 10];
        else
            return tensNames[toStringNumber / 10] + " " + numNames[toStringNumber % 10];
    }

}
