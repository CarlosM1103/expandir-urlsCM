package ec.edu.utpl.carreras.computacion.proava.s6;

import ec.edu.utpl.carreras.computacion.proava.s6.util.URLExpanderTask;

import java.nio.file.Path;
import java.util.Optional;
import java.io.IOError;
import java.io.IOException;
import java.nio.file.Files;


/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        var path = Path.of(
                "C:/Users/SALASC/Downloads/urls.csv"
        );

        try (var lines = Files.lines(path)) {
            lines
                    .filter(line -> !line.isBlank()) // Eliminar urls vacías list<string>
                    .map(String::trim) //
                    .map(URLExpanderTask::expand) //
                    .filter(opt -> opt.isPresent()) //
                    .map(Optional::get) //
                    .forEach(System.out::println); //
        } catch (IOException _) {}

        /* URLExpanderTask urlExpanderTask = new URLExpanderTask();
        Optional<String> expandedUrl = urlExpanderTask.expand("https://t.co/TGqER33gn7");
        expandedUrl.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("No se puede leer la URL")

        ); */
    }
}
