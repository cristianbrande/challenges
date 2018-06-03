package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import solution.MorseCode;

public class Tests {

    @Test
    void testTextToMorseCode() {
        String output = "- .... .   .-- .. --.. .- .-. -..   --.- ..- .. -.-. -.- .-.. -.--   .--- .. -. -..- . -..   - .... .   --. -. --- -- . ...   -... . ..-. --- .-. .   - .... . -.--   ...- .- .--. --- .-. .. --.. . -.. .-.-.-";
        String textToTranslate = "The wizard quickly jinxed the gnomes before they vaporized.";

        MorseCode morseCode = new MorseCode();

        // assert statements
        Assertions.assertEquals(output, morseCode.run(false, textToTranslate));
    }

    @Test
    void testMorseToText() {
        String input = "- .... .   .-- .. --.. .- .-. -..   --.- ..- .. -.-. -.- .-.. -.--   .--- .. -. -..- . -..   - .... .   --. -. --- -- . ...   -... . ..-. --- .-. .   - .... . -.--   ...- .- .--. --- .-. .. --.. . -.. .-.-.-";
        String expectedOutput = "the wizard quickly jinxed the gnomes before they vaporized.";

        MorseCode morseCode = new MorseCode();

        // assert statements
        Assertions.assertEquals(expectedOutput, morseCode.run(true, input));
    }

    @Test
    void testInvalidTextInput() {
        String input = "";
        String expectedOutput = "Invalid Morse Code Or Spacing";

        MorseCode morseCode = new MorseCode();

        // assert statements
        Assertions.assertEquals(expectedOutput, morseCode.run(false, input));
    }

    @Test
    void testInvalidSpacing() {
        String input = "- .... .    .-- .. --.. .- .-. -..";
        String expectedOutput = "Invalid Morse Code Or Spacing";

        MorseCode morseCode = new MorseCode();

        // assert statements
        Assertions.assertEquals(expectedOutput, morseCode.run(false, input));
    }
}
