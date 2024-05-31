package giovannighirardelli;

import com.github.javafaker.Faker;
import giovannighirardelli.entities.Archivio;
import giovannighirardelli.entities.Libri;
import giovannighirardelli.entities.Riviste;
import giovannighirardelli.enums.Periodicità;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Application {

    public static void main(String[] args) throws IOException {

        Archivio archivio = new Archivio();
//        Creazione Catalogo

        Supplier<String> randomTitolo = () -> {
            Faker faker = new Faker();
            return faker.book().title();
        };

        Supplier<Integer> randomYear = () -> {
            Random random = new Random();
            return random.nextInt(2000, 2024);
        };
        Supplier<Integer> randomPage = () -> {
            Random random = new Random();
            return random.nextInt(50, 650);
        };

//        Creazione Libri

        Supplier<String> randomAuthor = () -> {
            Faker faker = new Faker();
            return faker.book().author();
        };
        Supplier<String> randomGenre = () -> {
            Faker faker = new Faker();
            return faker.book().genre();
        };

        Supplier<Libri> libriSupplier = () -> new Libri(randomTitolo.get(), randomYear.get(), randomPage.get(), randomAuthor.get(), randomGenre.get());

        List<Libri> libriList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            libriList.add(libriSupplier.get());
            archivio.aggElemento("Libro", libriSupplier.get());
        }
        System.out.println(libriList);

//        Creazione riviste

        Supplier<Periodicità> randomPeriod = () -> {
            Random random = new Random();
            Periodicità[] period = Periodicità.values();
            int index = random.nextInt(period.length);
            return period[index];

        };

        Supplier<Riviste> rivisteSupplier = () -> new Riviste(randomTitolo.get(), randomYear.get(), randomPage.get(), randomPeriod.get());
        List<Riviste> rivisteList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            rivisteList.add(rivisteSupplier.get());
            archivio.aggElemento("Rivista", rivisteSupplier.get());

        }

        System.out.println(rivisteList);
        Libri libro1 = new Libri("Prova", 1996, 764, "Gianni", "Horror");
        Libri libro2 = new Libri("Che bello Java", 2014, 1, "Nessuno", "Thriller");
        Libri libro3 = new Libri("Ciao ciao", 2014, 3, "Gianni", "Thriller");
        Riviste rivista1 = new Riviste("Da leggere sul wc", 2024, 233, randomPeriod.get());
        Riviste rivista2 = new Riviste("Bricolage", 2023, 143, randomPeriod.get());
        Riviste rivista3 = new Riviste("Agricolutura", 2013, 354, randomPeriod.get());


        archivio.aggElemento("Libro", libro1);
        archivio.cercaPerISBN("Libro", libro1.getCodiceISBN());
        archivio.cercaPerAnno("Libro", libro2.getAnnoPubbl());
        archivio.cercaPerAutore("Libro", libro3.getAutore());

        archivio.aggElemento("Rivista", rivista1);
        archivio.cercaPerISBN("Rivista", rivista1.getCodiceISBN());
        archivio.cercaPerAnno("Rivista", rivista3.getAnnoPubbl());


        archivio.elElemento("Libro", libro1.getCodiceISBN());
        archivio.elElemento("Rivista", rivista1.getCodiceISBN());

        System.out.println(archivio);


        File file = new File("src/stampafile.txt");

        try {
            FileUtils.writeStringToFile(file, archivio.toString() + System.lineSeparator(), StandardCharsets.UTF_8);
            System.out.println("file scritto correttamente");
            Object contenuto = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            System.out.println(contenuto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

