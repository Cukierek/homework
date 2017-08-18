package com.cukierek;

import java.util.*;

public class BookCollections {

	// zwraca książki z kolekcji books które zostały napisane przez zadanego autora
	// NIE modyfikuje kolekcji books!
	public static Collection<Book> findByAuthor(Collection<Book> books, Person author) {
		Collection<Book> booksByAuthor = new HashSet<>();
		for (Book book : books) {
			if (book.isAuthor(author)) booksByAuthor.add(book);
		}
		return booksByAuthor;
	}

	// zwraca książki z kolekcji books których tytuł zaczyna się od zadanej frazy,
	// wielkość liter nie ma znaczenia
	// NIE modyfikuje kolekcji books!
	public static Collection<Book> findByTitle(Collection<Book> books, String phrase) {
		Collection<Book> booksByTitle = new HashSet<>();
		for (Book book : books) {
			if (book.titleStartsWithPhrase(phrase)) booksByTitle.add(book);
		}
		return booksByTitle;
	}

	// zwraca książki z kolekcji books które należą do wszystkich zadanych gatunków
	// NIE modyfikuje kolekcji books!
	public static Collection<Book> findByGenres(Collection<Book> books, Set<Genre> genres) {
		Collection<Book> booksByGenres = new HashSet<>();
		for (Book book : books) {
			if (book.containsAllGenres(genres))booksByGenres.add(book);
		}
		return booksByGenres;
	}

	// zwraca posortowaną rosnąco po tytule listę książek stworzoną z kolekcji books
	// NIE modyfikuje kolekcji books!
	public static List<Book> sortByTitle(Collection<Book> books) {
		List<Book> sortedByTitle = new ArrayList<>(books);
		sortedByTitle.sort(new Comparator<Book>() {
			@Override
			public int compare(Book o1, Book o2) {
				return o1.compareTitle(o2.getTitle());
			}
		});
		return sortedByTitle;
	}

	// zwraca posortowaną rosnąco listę książek z kolekcji books po nazwisku, imieniu autora i
	// po tytule
	// NIE modyfikuje kolekcji books!
	public static List<Book> sortByAuthorAndTitle(Collection<Book> books) {
		List<Book> sortedByLastNameFirstNameTitle = new ArrayList<>(books);
		sortedByLastNameFirstNameTitle.sort(new Comparator<Book>() {

			private static final int LAST_NAME_PRIORITY = 100;
			private static final int FIRST_NAME_PRIORITY = 10;
			private static final int TITLE_PRIORITY = 1;

			@Override
			public int compare(Book o1, Book o2) {
				int lastNameTest = (int) Math.signum(o1.getAuthor().getLastName().compareTo(o2.getAuthor().getLastName()));
				int firstNameTest = (int) Math.signum(o1.getAuthor().getFirstName().compareTo(o2.getAuthor().getFirstName()));
				int titleTest = (int) Math.signum(o1.getTitle().compareTo(o2.getTitle()));
				return LAST_NAME_PRIORITY * lastNameTest + FIRST_NAME_PRIORITY * firstNameTest + TITLE_PRIORITY * titleTest;
			}
		});
		return sortedByLastNameFirstNameTitle;
	}

	//tworzy mapę książek należących do poszczególnych gatunków, jeśli książka należy
	//do wielu gatunków, powinna wiele razy występować na mapie
	public static Map<Genre, Collection<Book>> genresMap(Collection<Book> books) {
		Map<Genre, Collection<Book>> genresMap = new HashMap<>();
		for (Book book : books) {
			for (Genre genre : book.getGenres()) {
				if (genresMap.containsKey(genre)) {
					genresMap.get(genre).add(book);
				} else {
					Collection<Book> internalCollection = new HashSet<>();
					internalCollection.add(book);
					genresMap.put(genre, internalCollection);
				}
			}
		}
		return genresMap;
	}

	//tworzy mapę książek napisanych przez poszczególnych autorów
	public static Map<Person, Collection<Book>> authorsMap(Collection<Book> books) {
		Map<Person, Collection<Book>> authorsMap = new HashMap<>();
		for (Book book : books) {
			Person author = book.getAuthor();
			if (authorsMap.containsKey(author)) {
				authorsMap.get(author).add(book);
			} else {
				Collection<Book> internalCollection = new HashSet<>();
				internalCollection.add(book);
				authorsMap.put(author, internalCollection);
			}
		}
		return authorsMap;
	}

	// tworzy mapę z ilością książek napisanych przez zadanego autora
	public static Map<Person, Integer> authorsBookCountMap(Collection<Book> books) {
		Map<Person, Integer> occurrencesMap = new HashMap<>();
		// można też zastosować metodę powyżej
		for (Book book : books) {
			Person author = book.getAuthor();
			Integer currentValue = occurrencesMap.getOrDefault(author, 0);
			occurrencesMap.put(author, currentValue + 1);
		}
		return occurrencesMap;
	}

	// zwraca liczbę książek których autorem jest auhtor
	public static int booksCount(Collection<Book> books, Person author) {
		int counter = 0;
		for (Book book : books) {
			if (book.getAuthor().equals(author)) counter++;
		}
		return counter;
	}

	// zwraca liczbę książek z danego gatunku
	public static int booksCount(Collection<Book> books, Genre genre) {
		int counter = 0;
		for (Book book : books) {
			if (book.hasGenre(genre)) counter++;
		}
		return counter;
	}

	// zwraca autora który napisał najwięcej książek
	public static Person bestAuthor(Collection<Book> books) {
		Map<Person, Integer> occurrencesMap = authorsBookCountMap(books);
		Integer currentBestAmount = -1;
		Person currentBestAuthor = new Person("", "" , -1, Gender.MALE);
		for (Map.Entry<Person, Integer> entry : occurrencesMap.entrySet()) {
			if (entry.getValue() > currentBestAmount) {
				currentBestAmount = entry.getValue();
				currentBestAuthor = entry.getKey();
			}
		}
		return currentBestAuthor;
	}

	// zwraca gatunek który ma najwięcej książek
	public static Genre mostPopularGenre(Collection<Book> books) {
		Map<Genre, Collection<Book>> occurrences = genresMap(books);
		int currentMax = -1;
		Genre currentMaxGenre = Genre.SATIRE;
		for (Map.Entry<Genre, Collection<Book>> entry : occurrences.entrySet()) {
			int booksCount = booksCount(entry.getValue(), entry.getKey());
			if (currentMax < booksCount) {
				currentMax = booksCount;
				currentMaxGenre = entry.getKey();
			}
		}
		return currentMaxGenre;
	}
}