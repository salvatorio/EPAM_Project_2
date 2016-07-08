package mvc;

import utilities.CompositeElement;
import utilities.Element;
import utilities.FlyWeightFactory;
import utilities.TextElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Evgeniy on 25.06.2016.
 */

public class Model {

    /**
     * It's composite of text's sentences
     */
    private CompositeElement sentences;

    /**
     * It's composite of sentence's words
     */
    private CompositeElement words;

    /**
     * It's flyweight sentenceFactory which prevents LectureElement object's duplication
     */
    private FlyWeightFactory<TextElement> sentenceFactory;

    /**
     * It's flyweight wordFactory which prevents LectureElement object's duplication
     */
    private FlyWeightFactory<TextElement> wordFactory;

    /**
     * Default constructor
     */
    public Model(){
        sentences = new CompositeElement();
        words = new CompositeElement();
        sentenceFactory = new FlyWeightFactory<TextElement>();
        wordFactory = new FlyWeightFactory<TextElement>();
    }

    /**
     * This method parses text for sentences
     * @param text is text which will be parsed
     */
    public void divideTextForSentences(String text){

        Matcher matcher = Pattern.compile(View.SENTENCE_PARSE).matcher(text);

        while (matcher.find()){
            String sentence = matcher.group();
            sentences.add(sentenceFactory.create(sentence, TextElement.Type.SENTENCE));
            divideTextForWords(sentence);
        }
    }

    /**
     * This method parses text for words
     * @param sentence is text which will be parsed
     */
    private void divideTextForWords(String sentence){

        Matcher matcher = Pattern.compile(View.WORDS_COMBINATIONS).matcher(sentence);

        while (matcher.find()){
            String word = matcher.group();
            Matcher matcherWord = Pattern.compile(View.WORD_PARSE).matcher(word);
            if (matcherWord.matches()){
                words.add(wordFactory.create(word, TextElement.Type.WORD));
            }
            else {
                words.add(wordFactory.create(word, TextElement.Type.SYMBOL));
            }
        }
    }

    /**
     * This method gets only words from sentences and sorts
     * @return sorted list
     */
    public List<Element> sortingWordsByVowels(){

        List<Element> list = new ArrayList<Element>();

        for (TextElement textElement : wordFactory.getMap().values()){
            if (((Element) textElement).getType().equals(TextElement.Type.WORD)){
                list.add((Element) textElement);
            }
        }
        Collections.sort(list);
        return list;
    }

    /**
     * This method replace consequences of spaces and tabulation with a single space
     * @param text is text to be modified
     * @return modified text
     */
    public String removeDoubleSpaces (String text){

        text = text.replaceAll("\\n", View.END_OF_LINE)
                .replaceAll("(\\s+)|\\t", " ")
                .replaceAll(View.END_OF_LINE, "\n")
                .replaceAll("\\n\\s", "\n")
                .replaceAll("\\n+", "\n");
        return text;
    }

    /**
     * @return getters and setters
     */
    public CompositeElement getSentences() {
        return sentences;
    }

    public void setSentences(CompositeElement sentences) {
        this.sentences = sentences;
    }

    public CompositeElement getWords() {
        return words;
    }

    public void setWords(CompositeElement words) {
        this.words = words;
    }

    public FlyWeightFactory<TextElement> getSentenceFactory() {
        return sentenceFactory;
    }

    public void setSentenceFactory(FlyWeightFactory<TextElement> sentenceFactory) {
        this.sentenceFactory = sentenceFactory;
    }

    public FlyWeightFactory<TextElement> getWordFactory() {
        return wordFactory;
    }

    public void setWordFactory(FlyWeightFactory<TextElement> wordFactory) {
        this.wordFactory = wordFactory;
    }
}
