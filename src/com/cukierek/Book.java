package com.cukierek;

import java.util.HashSet;
import java.util.Set;

public class Book {

	private String title;
	private Person author;
	private Set<Genre> genres = new HashSet<>();

	public Book(String title, Person author, Set<Genre> genres) {
		if (title == null || author == null || genres == null || genres.isEmpty())
			throw new IllegalArgumentException("All data required");
		this.title = title;
		this.author = author;
		this.genres.addAll(genres);
	}

	boolean hasGenre(Genre genre) {
		return genres.contains(genre);
	}

	String getTitle() {
		return title;
	}

	Person getAuthor() {
		return author;
	}

	Set<Genre> getGenres() {
		return genres;
	}

	boolean isAuthor(Person person) {
		return author.equals(person);
	}

	boolean titleStartsWithPhrase(String phrase) {
		return title.substring(0, phrase.length()).compareToIgnoreCase(phrase) == 0;
	}

	boolean containsAllGenres(Set<Genre> givenGenres) {
		return genres.containsAll(givenGenres);
	}

	int compareTitle(String givenTitle) {
		return title.compareTo(givenTitle);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Book)) return false;

		Book book = (Book) o;

		if (title != null ? !title.equals(book.title) : book.title != null) return false;
		return author.equals(book.author) && (genres != null ? genres.equals(book.genres) : book.genres == null);
	}

	@Override
	public int hashCode() {
		int result = title != null ? title.hashCode() : 0;
		result = 31 * result + author.hashCode();
		result = 31 * result + (genres != null ? genres.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Book{" +
				"title='" + title + '\'' +
				", author=" + author +
				", genres=" + genres +
				'}';
	}

	public String simpleToString() {
		return "BOOK = " + title + " | " + author.getFirstName() + " " + author.getLastName();
	}
}
