package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Films;

import static org.junit.jupiter.api.Assertions.*;

class PosterManagerTest {

    PosterManager poster = new PosterManager();

    Films first = new Films(1, "Бладшот", "Боевик", false);
    Films second = new Films(2, "Вперед", "Мультфильм", false);
    Films third = new Films(3, "Отель Белград", "Комедия", false);
    Films fourth = new Films(4, "Джентельмены", "Боевик", false);
    Films fifth = new Films(5, "Человек-невидимка", "Ужасы", false);
    Films sixth = new Films(6, "Тролли. Мировой тур", "Мультфильм", true);
    Films seventh = new Films(7, "Номер Один", "Комедия", true);
    Films eighth = new Films(8, "Наемник", "Боевик", false);
    Films ninth = new Films(9, "Хочу замуж", "Комедия", false);
    Films tenth = new Films(10, "Лулу и Бриггс", "Комедия", false);
    Films eleventh = new Films(11, "Парни под прикрытием", "Боевик", false);
    Films twelve = new Films(12, "Мистер Нокаут", "Спорт", false);

    @Test
    void shouldShowTenMovies() {

        poster.addon(first);
        poster.addon(second);
        poster.addon(third);
        poster.addon(fourth);
        poster.addon(fifth);
        poster.addon(sixth);
        poster.addon(seventh);
        poster.addon(eighth);
        poster.addon(ninth);
        poster.addon(tenth);
        poster.addon(eleventh);
        poster.addon(twelve);

        Films[] expected = new Films[]{
                twelve, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third};

        assertArrayEquals(expected, poster.findLast());
    }

    @Test
    void shouldShowAllMovies() {

        poster.addon(first);
        poster.addon(second);
        poster.addon(third);
        poster.addon(fourth);
        poster.addon(fifth);
        poster.addon(sixth);
        poster.addon(seventh);
        poster.addon(eighth);
        poster.addon(ninth);
        poster.addon(tenth);

        Films[] expected = new Films[]{
                tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, poster.findLast());
    }

    @Test
    void shouldShowMoviesUnderTen() {

        poster.addon(first);
        poster.addon(second);
        poster.addon(third);
        poster.addon(fourth);
        poster.addon(fifth);
        poster.addon(sixth);

        Films[] expected = new Films[]{
                sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, poster.findLast());
    }

    @Test
    void shouldShowMoviesBelowTenCurrentMoviesLenght() {

        PosterManager poster = new PosterManager(6);

        poster.addon(first);
        poster.addon(second);
        poster.addon(third);
        poster.addon(fourth);
        poster.addon(fifth);
        poster.addon(sixth);
        poster.addon(seventh);
        poster.addon(eighth);
        poster.addon(ninth);
        poster.addon(tenth);

        Films[] expected = new Films[]{
                tenth, ninth, eighth, seventh, sixth, fifth};

        assertArrayEquals(expected, poster.findLast());
    }

    @Test
    void findLast() {
        PosterManager poster = new PosterManager(4);

        for (int i = 1; i <= 10; i++) {
            poster.addon(new Films(i, "test" + i, "комедия", true));
        }

        Films[] actual = poster.findLast();

        assertEquals(4, actual.length);
    }

}