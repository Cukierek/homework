import com.cukierek.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertThat;

public class BookCollectionsTests {

	// Collection used in all tests

	private static Collection<Book> createBookCollection() {

		Collection<Book> booksCollection = new ArrayList<>();
		Set<Genre> genreSet = new HashSet<>();

		genreSet.addAll(Arrays.asList(Genre.FANTASY, Genre.COMEDY, Genre.ROMANTIC, Genre.HORROR, Genre.FICTION));

		booksCollection.add(new Book("Harry Potter & The philosophers stone", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		booksCollection.add(new Book("Harry Potter & The chamber of secrets", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		booksCollection.add(new Book("Harry Potter & The prisoner of Azkaban", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		booksCollection.add(new Book("Harry Potter & The goblet of fire", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		booksCollection.add(new Book("Harry Potter & The order of phoenix", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		booksCollection.add(new Book("Harry Potter & The half-blood prince", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		booksCollection.add(new Book("Harry Potter & The deathly hallows", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));

		genreSet.clear();
		genreSet.addAll(Arrays.asList(Genre.FANTASY, Genre.ROMANTIC, Genre.TRAGICOMEDY, Genre.FICTION));

		booksCollection.add(new Book("Witcher : The Last Wish", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));
		booksCollection.add(new Book("Witcher : The Sword of Destiny", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));
		booksCollection.add(new Book("Witcher : The Blood of the Elves", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));
		booksCollection.add(new Book("Witcher : The Time of Pogarda", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));
		booksCollection.add(new Book("Witcher : The Baptism of Frajer", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));
		booksCollection.add(new Book("Witcher : The Swallow Tower", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));
		booksCollection.add(new Book("Witcher : The Lady of the Lake", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));
		booksCollection.add(new Book("Witcher : The Storm Season", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));

		genreSet.clear();
		genreSet.addAll(Arrays.asList(Genre.REALISTIC, Genre.NON_FICTION));

		booksCollection.add(new Book("Clean code", new Person("Robert", "Martin", 70, Gender.MALE), genreSet));
		booksCollection.add(new Book("Master of the clean code", new Person("Robert", "Martin", 70, Gender.MALE), genreSet));
		booksCollection.add(new Book("Time paradox", new Person("Philip", "Zimbardo", 72, Gender.MALE), genreSet));
		booksCollection.add(new Book("Pragmatic programmer", new Person("Andrew", "Hunt", 67, Gender.MALE), genreSet));

		return booksCollection;
	}

	private static Collection<Book> createSortedByTitleBookCollection() {

		// posortuj zamiast się powtarzać

		Collection<Book> sortedBooksCollection = new ArrayList<>();
		Set<Genre> genreSet = new HashSet<>();

		genreSet.addAll(Arrays.asList(Genre.REALISTIC, Genre.NON_FICTION));

		sortedBooksCollection.add(new Book("Clean code", new Person("Robert", "Martin", 70, Gender.MALE), genreSet));

		genreSet.clear();
		genreSet.addAll(Arrays.asList(Genre.FANTASY, Genre.COMEDY, Genre.ROMANTIC, Genre.HORROR, Genre.FICTION));

		sortedBooksCollection.add(new Book("Harry Potter & The chamber of secrets", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		sortedBooksCollection.add(new Book("Harry Potter & The deathly hallows", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		sortedBooksCollection.add(new Book("Harry Potter & The goblet of fire", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		sortedBooksCollection.add(new Book("Harry Potter & The half-blood prince", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		sortedBooksCollection.add(new Book("Harry Potter & The order of phoenix", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		sortedBooksCollection.add(new Book("Harry Potter & The philosophers stone", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		sortedBooksCollection.add(new Book("Harry Potter & The prisoner of Azkaban", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));

		genreSet.clear();
		genreSet.addAll(Arrays.asList(Genre.REALISTIC, Genre.NON_FICTION));

		sortedBooksCollection.add(new Book("Master of the clean code", new Person("Robert", "Martin", 70, Gender.MALE), genreSet));
		sortedBooksCollection.add(new Book("Pragmatic programmer", new Person("Andrew", "Hunt", 67, Gender.MALE), genreSet));
		sortedBooksCollection.add(new Book("Time paradox", new Person("Philip", "Zimbardo", 72, Gender.MALE), genreSet));

		genreSet.clear();
		genreSet.addAll(Arrays.asList(Genre.FANTASY, Genre.ROMANTIC, Genre.TRAGICOMEDY, Genre.FICTION));

		sortedBooksCollection.add(new Book("Witcher : The Baptism of Frajer", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));
		sortedBooksCollection.add(new Book("Witcher : The Blood of the Elves", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));
		sortedBooksCollection.add(new Book("Witcher : The Lady of the Lake", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));
		sortedBooksCollection.add(new Book("Witcher : The Last Wish", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));
		sortedBooksCollection.add(new Book("Witcher : The Storm Season", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));
		sortedBooksCollection.add(new Book("Witcher : The Swallow Tower", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));
		sortedBooksCollection.add(new Book("Witcher : The Sword of Destiny", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));
		sortedBooksCollection.add(new Book("Witcher : The Time of Pogarda", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));

		return sortedBooksCollection;
	}

	@Test
	public void findByAuthorTest () {

		// GIVEN

		Collection<Book> inputCollection = createBookCollection();
		Person inputPerson = new Person("Joanne", "Rowling", 50, Gender.FEMALE);

		// WHEN

		Collection<Book> actualCollection = BookCollections.findByAuthor(inputCollection, inputPerson);

		// THEN

		Collection<Book> expectedOutputCollection = new HashSet<>();
		Set<Genre> genreSet = new HashSet<>();

		genreSet.addAll(Arrays.asList(Genre.FANTASY, Genre.COMEDY, Genre.ROMANTIC, Genre.HORROR, Genre.FICTION));

		expectedOutputCollection.add(new Book("Harry Potter & The chamber of secrets", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		expectedOutputCollection.add(new Book("Harry Potter & The philosophers stone", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		expectedOutputCollection.add(new Book("Harry Potter & The prisoner of Azkaban", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		expectedOutputCollection.add(new Book("Harry Potter & The goblet of fire", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		expectedOutputCollection.add(new Book("Harry Potter & The order of phoenix", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		expectedOutputCollection.add(new Book("Harry Potter & The half-blood prince", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		expectedOutputCollection.add(new Book("Harry Potter & The deathly hallows", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));

		Assert.assertEquals(expectedOutputCollection, actualCollection);

	}

	@Test
	public void findByTitleTest () {

		// GIVEN

		Collection<Book> inputCollection = createBookCollection();
		String inputPhrase = "harry";

		// WHEN

		Collection<Book> actualOutputCollection = BookCollections.findByTitle(inputCollection, inputPhrase);

		// THEN

		Collection<Book> expectedOutputCollection = new HashSet<>();

		Set<Genre> genreSet = new HashSet<>();

		genreSet.addAll(Arrays.asList(Genre.FANTASY, Genre.COMEDY, Genre.ROMANTIC, Genre.HORROR, Genre.FICTION));

		expectedOutputCollection.add(new Book("Harry Potter & The philosophers stone", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		expectedOutputCollection.add(new Book("Harry Potter & The chamber of secrets", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		expectedOutputCollection.add(new Book("Harry Potter & The prisoner of Azkaban", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		expectedOutputCollection.add(new Book("Harry Potter & The goblet of fire", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		expectedOutputCollection.add(new Book("Harry Potter & The order of phoenix", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		expectedOutputCollection.add(new Book("Harry Potter & The half-blood prince", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		expectedOutputCollection.add(new Book("Harry Potter & The deathly hallows", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));

		Assert.assertEquals(expectedOutputCollection, actualOutputCollection);

	}

	@Test
	public void findByGenresTest () {

		// GIVEN

		Collection<Book> inputCollection = createBookCollection();
		Set<Genre> inputGenres = new HashSet<>();
		inputGenres.add(Genre.FANTASY);

		// WHEN

		Collection<Book> actualOutputCollection = BookCollections.findByGenres(inputCollection, inputGenres);

		// THEN

		Collection<Book> expectedOutputCollection = new HashSet<>();
		Set<Genre> genreSet = new HashSet<>();

		genreSet.addAll(Arrays.asList(Genre.FANTASY, Genre.COMEDY, Genre.ROMANTIC, Genre.HORROR, Genre.FICTION));

		expectedOutputCollection.add(new Book("Harry Potter & The philosophers stone", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		expectedOutputCollection.add(new Book("Harry Potter & The chamber of secrets", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		expectedOutputCollection.add(new Book("Harry Potter & The prisoner of Azkaban", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		expectedOutputCollection.add(new Book("Harry Potter & The goblet of fire", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		expectedOutputCollection.add(new Book("Harry Potter & The order of phoenix", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		expectedOutputCollection.add(new Book("Harry Potter & The half-blood prince", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		expectedOutputCollection.add(new Book("Harry Potter & The deathly hallows", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));

		genreSet.clear();
		genreSet.addAll(Arrays.asList(Genre.FANTASY, Genre.ROMANTIC, Genre.TRAGICOMEDY, Genre.FICTION));

		expectedOutputCollection.add(new Book("Witcher : The Last Wish", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));
		expectedOutputCollection.add(new Book("Witcher : The Sword of Destiny", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));
		expectedOutputCollection.add(new Book("Witcher : The Blood of the Elves", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));
		expectedOutputCollection.add(new Book("Witcher : The Time of Pogarda", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));
		expectedOutputCollection.add(new Book("Witcher : The Baptism of Frajer", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));
		expectedOutputCollection.add(new Book("Witcher : The Swallow Tower", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));
		expectedOutputCollection.add(new Book("Witcher : The Lady of the Lake", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));
		expectedOutputCollection.add(new Book("Witcher : The Storm Season", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));

		Assert.assertEquals(expectedOutputCollection, actualOutputCollection);

	}

	@Test
	public void sortByTitleTest () {

		// GIVEN

		Collection<Book> inputCollection = createBookCollection();

		// WHEN

		Collection<Book> actualOutputCollection = BookCollections.sortByTitle(inputCollection);

		// THEN

		Collection<Book> expectedOutputCollection = createSortedByTitleBookCollection();
		Assert.assertEquals(expectedOutputCollection, actualOutputCollection);

	}

	@Test
	public void sortByAuthorAndTitleTest () {
		// TODO write test
	}

	@Test
	public void genresMapTest () {

		// GIVEN

		Collection<Book> inputCollection = createBookCollection();

		// WHEN

		Map<Genre, Collection<Book>> actualOutputMap = BookCollections.genresMap(inputCollection);

		// THEN

		Map<Genre, Collection<Book>> expectedOutputMap = new HashMap<>();

		Collection<Book> internalSet = new HashSet<>();

		Set<Genre> genreSet = new HashSet<>();
		genreSet.addAll(Arrays.asList(Genre.FANTASY, Genre.COMEDY, Genre.ROMANTIC, Genre.HORROR, Genre.FICTION));

		internalSet.add(new Book("Harry Potter & The philosophers stone", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		internalSet.add(new Book("Harry Potter & The chamber of secrets", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		internalSet.add(new Book("Harry Potter & The prisoner of Azkaban", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		internalSet.add(new Book("Harry Potter & The goblet of fire", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		internalSet.add(new Book("Harry Potter & The order of phoenix", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		internalSet.add(new Book("Harry Potter & The half-blood prince", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		internalSet.add(new Book("Harry Potter & The deathly hallows", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));

		expectedOutputMap.put(Genre.COMEDY, internalSet);
		expectedOutputMap.put(Genre.HORROR, internalSet);

		internalSet = new HashSet<>();

		internalSet.add(new Book("Harry Potter & The philosophers stone", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		internalSet.add(new Book("Harry Potter & The chamber of secrets", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		internalSet.add(new Book("Harry Potter & The prisoner of Azkaban", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		internalSet.add(new Book("Harry Potter & The goblet of fire", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		internalSet.add(new Book("Harry Potter & The order of phoenix", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		internalSet.add(new Book("Harry Potter & The half-blood prince", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));
		internalSet.add(new Book("Harry Potter & The deathly hallows", new Person("Joanne", "Rowling", 50, Gender.FEMALE), genreSet));

		genreSet.clear();
		genreSet.addAll(Arrays.asList(Genre.FANTASY, Genre.ROMANTIC, Genre.TRAGICOMEDY, Genre.FICTION));

		internalSet.add(new Book("Witcher : The Last Wish", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));
		internalSet.add(new Book("Witcher : The Sword of Destiny", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));
		internalSet.add(new Book("Witcher : The Blood of the Elves", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));
		internalSet.add(new Book("Witcher : The Time of Pogarda", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));
		internalSet.add(new Book("Witcher : The Baptism of Frajer", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));
		internalSet.add(new Book("Witcher : The Swallow Tower", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));
		internalSet.add(new Book("Witcher : The Lady of the Lake", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));
		internalSet.add(new Book("Witcher : The Storm Season", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));

		expectedOutputMap.put(Genre.FANTASY, internalSet);
		expectedOutputMap.put(Genre.ROMANTIC, internalSet);
		expectedOutputMap.put(Genre.FICTION, internalSet);

		internalSet = new HashSet<>();
		genreSet.clear();
		genreSet.addAll(Arrays.asList(Genre.FANTASY, Genre.ROMANTIC, Genre.TRAGICOMEDY, Genre.FICTION));

		internalSet.add(new Book("Witcher : The Last Wish", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));
		internalSet.add(new Book("Witcher : The Sword of Destiny", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));
		internalSet.add(new Book("Witcher : The Blood of the Elves", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));
		internalSet.add(new Book("Witcher : The Time of Pogarda", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));
		internalSet.add(new Book("Witcher : The Baptism of Frajer", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));
		internalSet.add(new Book("Witcher : The Swallow Tower", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));
		internalSet.add(new Book("Witcher : The Lady of the Lake", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));
		internalSet.add(new Book("Witcher : The Storm Season", new Person("Andrzej", "Sapkowski", 55, Gender.MALE), genreSet));

		expectedOutputMap.put(Genre.TRAGICOMEDY, internalSet);

		internalSet = new HashSet<>();
		genreSet.clear();
		genreSet.addAll(Arrays.asList(Genre.REALISTIC, Genre.NON_FICTION));

		internalSet.add(new Book("Clean code", new Person("Robert", "Martin", 70, Gender.MALE), genreSet));
		internalSet.add(new Book("Master of the clean code", new Person("Robert", "Martin", 70, Gender.MALE), genreSet));
		internalSet.add(new Book("Time paradox", new Person("Philip", "Zimbardo", 72, Gender.MALE), genreSet));
		internalSet.add(new Book("Pragmatic programmer", new Person("Andrew", "Hunt", 67, Gender.MALE), genreSet));

		expectedOutputMap.put(Genre.REALISTIC, internalSet);
		expectedOutputMap.put(Genre.NON_FICTION, internalSet);

		System.out.println("==== Actual Output ====");

		for (Map.Entry<Genre, Collection<Book>> entry : actualOutputMap.entrySet()) {
			System.out.println(entry.getKey() + ": ");
			for (Book book : entry.getValue()) {
				System.out.println("    " + book.simpleToString());
			}
			System.out.print("\n");
		}

		System.out.println("=== Expected Output ===");

		for (Map.Entry<Genre, Collection<Book>> entry : expectedOutputMap.entrySet()) {
			System.out.println(entry.getKey() + ": ");
			for (Book book : entry.getValue()) {
				System.out.println("    " + book.simpleToString());
			}
			System.out.print("\n");
		}

		Assert.assertEquals(expectedOutputMap, actualOutputMap);
	}

	@Test
	public void authorsMapTest () {
		// TODO write test
	}

	@Test
	public void authorsBookCountMapTest () {

		// GIVEN

		Collection<Book> inputCollection = createBookCollection();

		// WHEN

		Map<Person, Integer> actualOutputCollection = BookCollections.authorsBookCountMap(inputCollection);

		// THEN

		Map<Person, Integer> expectedOutputMap = new HashMap<>();

		expectedOutputMap.put(new Person("Joanne", "Rowling", 50, Gender.FEMALE), 7);
		expectedOutputMap.put(new Person("Robert", "Martin", 70, Gender.MALE), 2);
		expectedOutputMap.put(new Person("Andrzej", "Sapkowski", 55, Gender.MALE), 8);
		expectedOutputMap.put(new Person("Andrew", "Hunt", 67, Gender.MALE), 1);
		expectedOutputMap.put(new Person("Philip", "Zimbardo", 72, Gender.MALE), 1);

		Assert.assertEquals(expectedOutputMap, actualOutputCollection);

	}

	@Test
	public void booksCountTest () {

		// GIVEN

		Collection<Book> inputCollection = createBookCollection();
		Person inputPerson = new Person("Joanne", "Rowling", 50, Gender.FEMALE);
		Genre inputGenre = Genre.FANTASY;

		// WHEN

		int actualOutputFromPerson = BookCollections.booksCount(inputCollection, inputPerson);
		int actualOutputFromGenre = BookCollections.booksCount(inputCollection, inputGenre);

		// THEN

		int expectedOutputFromPerson = 7;
		int expectedOutputFromGenre = 15;

		Assert.assertEquals(expectedOutputFromPerson, actualOutputFromPerson);
		Assert.assertEquals(expectedOutputFromGenre, actualOutputFromGenre);

	}

	@Test
	public void bestAuthorTest () {

		// GIVEN

		Collection<Book> inputCollection = createBookCollection();

		// WHEN

		Person actualBestAuthor = BookCollections.bestAuthor(inputCollection);

		// THEN

		Person expectedBestAuthor = new Person("Andrzej", "Sapkowski", 55, Gender.MALE);

		Assert.assertEquals(expectedBestAuthor, BookCollections.bestAuthor(inputCollection));

	}

	@Test
	public void mostPopularGenreTest() {

		// GIVEN

		Collection<Book> inputCollection = createBookCollection();

		// WHEN

		Genre actualOutputGenre = BookCollections.mostPopularGenre(inputCollection);

		// THEN

		Genre expectedOutputGenre = Genre.ROMANTIC;

		Assert.assertEquals(expectedOutputGenre, actualOutputGenre);

	}
}
