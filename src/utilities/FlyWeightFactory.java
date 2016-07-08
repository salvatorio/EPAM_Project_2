package utilities;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Evgeniy on 25.06.2016.
 */

public class FlyWeightFactory<E> {

    /**
     * Map of the elements
     */
    private Map<String, Element> map = new HashMap<String, Element>();

    /**
     * This method creates unique elements or returns already existed
     * @param text is value of element
     * @return element with txt value
     */
    public TextElement create(String text, Element.Type type){

        if (map.containsKey(text)){
            return map.get(text);
        }
        else {
            Element element = new Element(text, type);
            map.put(element.getValue(), element);
            return element;
        }
    }

    /**
     * @return getter and setter by map
     */
    public Map<String, Element> getMap() {
        return map;
    }

    public void setMap(Map<String, Element> map) {
        this.map = map;
    }
}
