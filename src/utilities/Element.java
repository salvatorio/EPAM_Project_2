package utilities;

import mvc.View;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Evgeniy on 25.06.2016.
 */

public class Element implements TextElement, Comparable{

    /**
     * Text of element
     */
    private String value;

    /**
     * Type of element
     */
    private Type type;

    /**
     * Constructor
     * @param element
     */
    public Element(String element, Type type) {
        value = element;
        this.type = type;
    }

    /**
     * This method returns ratio of vowels symbols to general quantity symbols in raining word
     * @param element
     * @return ratio
     */
    private static double ratioVowels(Element element){

        int vowelsCount = 0;
        Matcher matcher = Pattern.compile(View.VOWELS_LETTERS).matcher(element.value);
        while (matcher.find()){
            ++vowelsCount;
        }
        return (double)vowelsCount/element.value.length();
    }

    /**
     * @return getters and setters of value and type
     */
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public int compareTo(Object o) {
        Element element = (Element) o;
        return (int) Math.signum(ratioVowels(element) - ratioVowels(this));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Element element = (Element) o;

        if (type != element.type) return false;
        if (value != null ? !value.equals(element.value) : element.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public void printToConsole() {
        System.out.println(value);
    }
}
