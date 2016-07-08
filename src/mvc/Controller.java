package mvc;

import java.io.*;
import java.util.List;

/**
 * Created by Evgeniy on 25.06.2016.
 */

public class Controller {

    /**
     * Model
     */
    private Model model;

    /**
     * View
     */
    private View view;

    /**
     * Constructor
     * @param model
     * @param view
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * User's main method
     */
    public void processUser(){

        String text = initText(View.INPUT_TEXT_FILE);
        text = model.removeDoubleSpaces(text);
        model.divideTextForSentences(text);
        List listOfSortedWords = model.sortingWordsByVowels();
        view.printCollection(listOfSortedWords);
        writeText(text, View.OUTPUT_TEXT_FILE);
    }

    /**
     * This method create a String with text from .txt file
     * @param path is path to .txt file
     * @return a String variable with text of .txt file
     */
    public String initText(String path){

        StringBuilder text = new StringBuilder();
        String line;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            while ((line = bufferedReader.readLine()) != null){
                text = text.append(line).append('\n');
            }
            bufferedReader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    /**
     * This method write a text to file
     * @param text is text which will be written
     * @param path is path of new file
     */
    public void writeText(String text, String path){

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
            bufferedWriter.write(text);
            bufferedWriter.flush();
            bufferedWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
