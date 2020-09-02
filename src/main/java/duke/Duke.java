package duke;

import duke.command.Command;
import duke.exception.DukeException;
import javafx.scene.Scene;
import java.util.Scanner;

/**
 * Represents the task manager program.
 */
public class Duke {

    protected TaskList taskList = new TaskList();
    protected Ui ui = new Ui(taskList);
    /**
     * Runs Duke, a task manager program.
     * Duke takes in console input as a command and will execute
     * and return the appropriate output.
     */
    public void run() {
        Scanner sc = new Scanner(System.in);
        ui.greeting();

        String input = "";
        while (!input.equals("bye") && sc.hasNextLine()) {
            try {
                input = sc.nextLine();
                Command c = Parser.parse(input);
                c.execute(taskList, ui, input);
            } catch (DukeException e) {
                System.out.println(e + "\n");
            }
        }
    }

    public static void main(String[] args) {
        Duke duke = new Duke();
        duke.run();
    }
}

