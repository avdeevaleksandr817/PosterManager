package ru.netology.manager;

import ru.netology.domain.Films;

public class PosterManager {
    private Films[] films = new Films[0];
    private int currentMoviesLenght = 10;

    public PosterManager() {
    }

    public PosterManager(int currentMoviesLenght) {

        this.currentMoviesLenght = currentMoviesLenght;
    }

    public void addon(Films movie) {
        Films[] tmp = new Films[films.length + 1];
        System.arraycopy(films, 0, tmp, 0, films.length);
        tmp[tmp.length - 1] = movie;
        this.films = tmp;

    }

    public Films[] findAll() {
        return this.films;

    }

    public Films[] findLast() {
        int resultLenght;
        if (films.length < currentMoviesLenght) {
            resultLenght = films.length;
        } else {
            resultLenght = currentMoviesLenght;
        }
        Films[] result = new Films[resultLenght];
        for (int i = 0; i < resultLenght; i++) {
            result[i] = films[films.length - 1 - i];
        }
        return result;
    }
}