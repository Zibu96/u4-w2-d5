package giovannighirardelli;

import com.github.javafaker.Faker;
import giovannighirardelli.entities.Archivio;
import giovannighirardelli.entities.Libri;
import giovannighirardelli.entities.Riviste;
import giovannighirardelli.enums.Periodicità;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Application {

    public static void main(String[] args) {

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
        archivio.aggElemento("Libro", libro1);
        archivio.cercaPerISBN("Libro", libro1.getCodiceISBN());
        archivio.cercaPerAnno("Libro", libro1.getAnnoPubbl());
        archivio.cercaPerAutore("Libro", libro1.getAutore());


        archivio.elElemento("Libro", libro1.getCodiceISBN());

        System.out.println(archivio);
    }
}
