package solution;

import java.util.HashMap;
import java.util.Map;

public class MorseCode {

    private static final String MORSE_SPACE = "   ";
    private static final String TEXT_SPACE = " ";

    private Map<String, String> textToMorseMap;
    private Map<String, String> morseToTextMap;

    public MorseCode() {
        initDictionaries();
    }

    public String run(boolean morseToEnglish, String textToTranslate) {
        initDictionaries();
        String[] words;
        String translatedText;

        try {
            validateInput(textToTranslate);

            if (morseToEnglish) {
                words = getWordsFromMorse(textToTranslate);
                translatedText = translateTextWords(morseToEnglish, words);
            } else {
                words = getWordsFromText(textToTranslate);
                translatedText = translateTextWords(morseToEnglish, words);
            }
        } catch (InvalidInputException e) {
            translatedText = e.getMessage();
        }
        return translatedText;
    }

    /**
     * The method populates the textToMorseMap and morseToTextMap dictionaries with the english and morse alphabets mapping.
     */
    private void initDictionaries() {
        textToMorseMap = new HashMap<>();
        morseToTextMap = new HashMap<>();

        // populate the text to morse character mapping
        textToMorseMap.put("a", ".-");
        textToMorseMap.put("b", "-...");
        textToMorseMap.put("c", "-.-.");
        textToMorseMap.put("d", "-..");
        textToMorseMap.put("e", ".");
        textToMorseMap.put("f", "..-.");
        textToMorseMap.put("g", "--.");
        textToMorseMap.put("h", "....");
        textToMorseMap.put("i", "..");
        textToMorseMap.put("j", ".---");
        textToMorseMap.put("k", "-.-");
        textToMorseMap.put("l", ".-..");
        textToMorseMap.put("m", "--");
        textToMorseMap.put("n", "-.");
        textToMorseMap.put("o", "---");
        textToMorseMap.put("p", ".--.");
        textToMorseMap.put("q", "--.-");
        textToMorseMap.put("r", ".-.");
        textToMorseMap.put("s", "...");
        textToMorseMap.put("t", "-");
        textToMorseMap.put("u", "..-");
        textToMorseMap.put("v", "...-");
        textToMorseMap.put("w", ".--");
        textToMorseMap.put("x", "-..-");
        textToMorseMap.put("y", "-.--");
        textToMorseMap.put("z", "--..");
        textToMorseMap.put("0", "-----");
        textToMorseMap.put("1", ".----");
        textToMorseMap.put("2", "..---");
        textToMorseMap.put("3", "...--");
        textToMorseMap.put("4", "....-");
        textToMorseMap.put("5", ".....");
        textToMorseMap.put("6", "-....");
        textToMorseMap.put("7", "--...");
        textToMorseMap.put("8", "---..");
        textToMorseMap.put("9", "----.");
        textToMorseMap.put(".", ".-.-.-");

        // iterate over the textToMorseMap dictionary in order to populate the reverse mapping.
        for (Map.Entry<String, String> entry : textToMorseMap.entrySet()) {
            morseToTextMap.put(entry.getValue(), entry.getKey());
        }

        textToMorseMap.put("", "");
    }

    /**
     * Extracts the words from the given text using @TEXT_SPACE as a delimiter.
     *
     * @param text
     * @return the words
     */
    private String[] getWordsFromText(String text) {
        if (text == null) {
            throw new InvalidInputException();
        }
        return text.toLowerCase().split(TEXT_SPACE);
    }

    /**
     * Extracts the words from the given text using @MORSE_SPACE as a delimiter.
     *
     * @param text
     * @return the words
     */
    private String[] getWordsFromMorse(String text) {
        if (text == null) {
            throw new InvalidInputException();
        }
        return text.split(MORSE_SPACE);
    }

    /**
     * Extracts the letters from the given word.
     *
     * @param morseToEnglish
     * @param word
     * @return
     */
    private String[] getLetters(boolean morseToEnglish, String word) {
        if (morseToEnglish) {
            return word.split(" ");
        }
        return word.split("");
    }

    /**
     * Convert the given @letter to the english alphabet equivalent.
     *
     * @param letter
     * @return
     */
    private String getTextEquivalentOfMorseLetter(String letter) {
        String result = morseToTextMap.get(letter);
        if (result == null) {
            throw new InvalidInputException();
        }
        return result;
    }

    /**
     * Convert the given letter to the morse alphabet equivalent.
     *
     * @param letter
     * @return
     */
    private String getMorseEquivalentOfTextLetter(String letter) {
        String result = textToMorseMap.get(letter);
        if (result == null) {
            throw new InvalidInputException();
        }
        return result;
    }

    /**
     * Translates a given word into the other alphabet.
     *
     * @param morseToEnglish
     * @param word
     * @return
     */
    private String translateWord(boolean morseToEnglish, String word) {
        String[] letters = getLetters(morseToEnglish, word);
        StringBuilder translation = new StringBuilder();

        // append the translation separated by a space
        for (int index = 0; index < letters.length - 1; index++) {
            if (morseToEnglish) {
                translation.append(getTextEquivalentOfMorseLetter(letters[index]));
            } else {
                translation.append(getMorseEquivalentOfTextLetter(letters[index]));
                translation.append(" ");
            }
        }

        // append the last letter
        if (morseToEnglish) {
            translation.append(morseToTextMap.get(letters[letters.length - 1]));
        } else {
            translation.append(textToMorseMap.get(letters[letters.length - 1]));
        }
        return translation.toString();
    }

    /**
     * Translate the given words to the other alphabet.
     *
     * @param morseToEnglish
     * @param words
     * @return
     */
    private String translateTextWords(boolean morseToEnglish, String[] words) {
        StringBuilder stringBuilder = new StringBuilder();

        if (words.length == 0) {
            throw new InvalidInputException();
        }

        for (int index = 0; index < words.length - 1; index++) {
            stringBuilder.append(translateWord(morseToEnglish, words[index]));
            if (morseToEnglish) {
                stringBuilder.append(TEXT_SPACE);
            } else {
                stringBuilder.append(MORSE_SPACE);
            }
        }
        stringBuilder.append(translateWord(morseToEnglish, words[words.length - 1]));
        return stringBuilder.toString();
    }

    private void validateInput(String textToTranslate) {
        if (textToTranslate == null || textToTranslate.isEmpty()) {
            throw new InvalidInputException();
        }
    }
}
