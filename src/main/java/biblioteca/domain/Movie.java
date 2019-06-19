package biblioteca.domain;

import java.util.Objects;

public class Movie {
    private String name;
    private String year;
    private String director;
    private Integer rates;
    private Boolean available;

    public Movie(String name, String year, String director, Integer rates, Boolean available) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rates = rates;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getRates() {
        return rates;
    }

    public void setRates(Integer rates) {
        this.rates = rates;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(name, movie.name) &&
                Objects.equals(year, movie.year) &&
                Objects.equals(director, movie.director) &&
                Objects.equals(rates, movie.rates) &&
                Objects.equals(available, movie.available);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, director, rates, available);
    }
}
