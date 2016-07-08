package utilities;

/**
 * Created by Evgeniy on 25.06.2016.
 */

public interface TextElement {

    /**
     * This method prints inner value of list of words
     */
    void printToConsole();

    /**
     * enum of element's types
     */
    enum Type{
        SENTENCE,
        WORD,
        SYMBOL
    }
}
