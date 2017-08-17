package com.cukierek;

import java.util.*;

public class BookCollections {

	// zwraca książki z kolekcji books które zostały napisane przez zadanego autora
	// NIE modyfikuje kolekcji books!
	public static Collection<Book> findByAuthor(Collection<Book> books, Person author) {
		Collection<Book> booksByAuthor = new HashSet<Book>();
		for (Book book: books) {
			if (book.getAuthor().equals(author)) booksByAuthor.add(book);
		}
		return booksByAuthor;
	}

	// zwraca książki z kolekcji books których tytuł zaczyna się od zadanej frazy,
	// wielkość liter nie ma znaczenia
	// NIE modyfikuje kolekcji books!
	public static Collection<Book> findByTitle(Collection<Book> books, String phrase) {
		Collection<Book> booksByTitle = new HashSet<>();
		for (Book book: books) {
			if (book.getTitle().toLowerCase().contains(phrase.toLowerCase())) booksByTitle.add(book);
		}
		return booksByTitle;
	}

	// zwraca książki z kolekcji books które należą do wszystkich zadanych gatunków
	// NIE modyfikuje kolekcji books!
	public static Collection<Book> findByGenres(Collection<Book> books, Set<Genre> genres) {
		Collection<Book> booksByGenres = new HashSet<>();
		for (Book book : books) {
			if (book.getGenres().containsAll(genres))booksByGenres.add(book);
		}
		return booksByGenres;
	}

	// zwraca posortowaną rosnąco po tytule listę książek stworzoną z kolekcji books
	// NIE modyfikuje kolekcji books!
	public static List<Book> sortByTitle(Collection<Book> books) {
		List<Book> sortedByTitle = new ArrayList<Book>(books);
		sortedByTitle.sort(new Comparator<Book>() {
			@Override
			public int compare(Book o1, Book o2) {
				return o1.getTitle().compareTo(o2.getTitle());
			}
		});
		return sortedByTitle;
	}

	// zwraca posortowaną rosnąco listę książek z kolekcji books po nazwisku, imieniu autora i
	// po tytule
	// NIE modyfikuje kolekcji books!
	public static List<Book> sortByAuthorAndTitle(Collection<Book> books) {
		List<Book> sortedByLastNameFirstNameTitle = new ArrayList<Book>(books);
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
		for (Genre genre : Genre.values()) {
			List<Book> booksByGenre = new ArrayList<Book>();
			for (Book book : books) {
				if (book.hasGenre(genre)) booksByGenre.add(book);
			}
			genresMap.put(genre, booksByGenre);
		}
		return genresMap;
	}

	public static List<Book> sortByAuthorFirstAndLastName(Collection<Book> books) {
		List<Book> sortedByLastNameFirstName = new ArrayList<Book>(books);
		sortedByLastNameFirstName.sort(new Comparator<Book>() {

			private static final int LAST_NAME_PRIORITY = 100;
			private static final int FIRST_NAME_PRIORITY = 10;

			@Override
			public int compare(Book o1, Book o2) {
				int lastNameTest = (int) Math.signum(o1.getAuthor().getLastName().compareTo(o2.getAuthor().getLastName()));
				int firstNameTest = (int) Math.signum(o1.getAuthor().getFirstName().compareTo(o2.getAuthor().getFirstName()));
				return LAST_NAME_PRIORITY * lastNameTest + FIRST_NAME_PRIORITY * firstNameTest;
			}
		});
		return sortedByLastNameFirstName;
	}

	//tworzy mapę książek napisanych przez poszczególnych autorów
	public static Map<Person, Collection<Book>> authorsMap(Collection<Book> books) {
		List<Book> booksSortedByAuthor = sortByAuthorFirstAndLastName(books);
		Map<Person, Collection<Book>> authorsMap = new HashMap<>();

		Person currentAuthor = booksSortedByAuthor.get(0).getAuthor();

		List<Book> tinyBookCollection = new ArrayList<>();

		for (Book book : booksSortedByAuthor) {
			if (currentAuthor.equals(book.getAuthor())) { tinyBookCollection.add(book); }
			else {
				authorsMap.put(book.getAuthor(), tinyBookCollection);
				currentAuthor = book.getAuthor();
				tinyBookCollection = new ArrayList<>();
			}
		}

		return authorsMap;
	}

	//tworzy mapę z ilością książek napisanych przez zadanego autora
	public static Map<Person, Integer> authorsBookCountMap(Collection<Book> books) {
		Map<Person, Integer> occurrencesMap = new HashMap<>();
		for (Book book : books) {
			Person author = book.getAuthor();
			if (occurrencesMap.containsKey(author)) {
				occurrencesMap.put(author, occurrencesMap.get(author) + 1);
			} else {
				occurrencesMap.put(author, 1);
			}
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
		Map<Person, Integer> occurrencesMap = new HashMap<>();
		for (Book book : books) {
			Person author = book.getAuthor();
			if (occurrencesMap.containsKey(author)) {
				occurrencesMap.put(author, occurrencesMap.get(author) + 1);
			} else {
				occurrencesMap.put(author, 1);
			}
		}
		return Collections.max(occurrencesMap.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getKey();
	}

	// zwraca gatunek który ma najwięcej książek
	public static Genre mostPopularGenre(Collection<Book> books) {
		Map<Genre, Integer> occurrences = new HashMap<>();
		for (Book book : books) {
			Set<Genre> keys = book.getGenres();
			for (Genre genre : keys) {
				if (occurrences.containsKey(genre)) {
					occurrences.put(genre, occurrences.get(genre) + 1);
				} else {
					occurrences.put(genre, 1);
				}
			}
		}

		for (Map.Entry<Genre, Integer> entry : occurrences.entrySet()) {
			System.out.print(entry.getKey().name() + ": " + entry.getValue() + "\n");
		}

		return Collections.max(occurrences.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getKey();
	}
}