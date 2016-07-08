package mvc;

import java.util.Collection;

/**
 * Created by Evgeniy on 25.06.2016.
 */

public class View {

    public static final String INPUT_TEXT_FILE = "/Users/admina/IdeaProjects/RatioByVowels_final/src/text/Input_text.txt";
    public static final String OUTPUT_TEXT_FILE = "/Users/admina/IdeaProjects/RatioByVowels_final/src/text/Output_text.txt";

    public static final String END_OF_LINE = "END_OF_LINE";
    public static final String VOWELS_LETTERS = "[АЕЁИОУЫЭЮЯІЇЄаеёиоуыэюяіїєAEIOUYaeiouy]";
    public static final String SENTENCE = "(((?<=\n)\\d.)?[А-Я](([^\\.])+?(([A-Za-z()]*\\.[A-Za-z()]+)|([0-9]+\\.[0-9]*))*)+((\\.|!|\\?)(?!\\S[А-Я])))";
    public static final String AFTER_SENTENCE_WITHOUT_DOTS = "(?<=(\\s))([А-Я]([^\\.])+(?=(\n[А-Я])))";
    public static final String WORD_PARSE = "(([А-Яа-яA-Za-zЁёэЭєЄ]+)([-][А-Яа-яA-Za-z]+)*)";
    public static final String NO_WORD_PARSE = "[\\W_0-9]";
    public static final String WORDS_COMBINATIONS = WORD_PARSE + "|" + NO_WORD_PARSE;
    public static final String SENTENCE_PARSE = SENTENCE + "|" + AFTER_SENTENCE_WITHOUT_DOTS;

    /**
     * This method prints collection
     * @param collection is collection  witch will be printed
     */
    public void printCollection(Collection collection){
        for (Object listElement : collection){
            System.out.println(listElement);
        }
    }
}
