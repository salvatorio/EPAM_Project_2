package main;

import mvc.Controller;
import mvc.Model;
import mvc.View;

/**
 * Created by Evgeniy on 25.06.2016.
 */

public class Main {

    public static void main(String[] args) {

        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        /**
         * main process of user
         */
        controller.processUser();
    }
}
