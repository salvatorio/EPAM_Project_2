package utilities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evgeniy on 25.06.2016.
 */

public class CompositeElement implements TextElement {

    /**
     * List of elements
     */
    private List<TextElement> elements = new ArrayList<TextElement>();

    /**
     * @return getters and setters of elements
     */
    public List<TextElement> getElements() {
        return elements;
    }

    public void setElements(List<TextElement> elements) {
        this.elements = elements;
    }

    /**
     * This method adds an element for realising composite
     * @param textElement is element witch will be added
     */
    public void add(TextElement textElement){
        elements.add(textElement);
    }

    /**
     * This method removes an element from list
     * @param textElement is element witch will be removed
     */
    public void remove(TextElement textElement){
        elements.remove(textElement);
    }

    @Override
    public void printToConsole() {
        for (TextElement textElement : elements){
            System.out.println(textElement);
        }
    }
}
