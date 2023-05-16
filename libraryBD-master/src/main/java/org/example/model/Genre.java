package org.example.model;

public enum Genre {
    DRAMA("Драма"),
    HORROR("Ужасы"),
    THRILLER("Триллер");

    private String title;
    Genre(String title){this.title = title;}

    public String getTitleGenre() {
        return title;
    }

    public static Genre fromTitle(String title){
        for (Genre genre:Genre.values()){
            if (genre.title.equals(title)){
                return genre;
            }
        }
        return null;
    }
}
