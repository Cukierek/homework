import com.cukierek.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertThat;

public class BookCollectionsTests {

	// Collection used in all tests

	@SuppressWarnings("Deprecated")
	public static Collection<Book> createBookCollection() {

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

	public static Collection<Book> createSortedByTitleBookCollection() {

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
		Collection<Book> inputCollection = createBookCollection();
		Person inputPerson = new Person("Joanne", "Rowling", 50, Gender.FEMALE);

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

		Assert.assertEquals(expectedOutputCollection, BookCollections.findByAuthor(inputCollection, inputPerson));
	}

	@Test
	public void findByTitleTest () {
		Collection<Book> inputCollection = createBookCollection();

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

		Assert.assertEquals(expectedOutputCollection, BookCollections.findByTitle(inputCollection, "HARRY"));
	}

	@Test
	public void findByGenresTest () {
		Collection<Book> inputCollection = createBookCollection();

		Collection<Book> expectedOutputCollection = new HashSet<>();

		Set<Genre> inputGenres = new HashSet<>();

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

		inputGenres.addAll(Arrays.asList(Genre.FANTASY));

		Assert.assertEquals(expectedOutputCollection, BookCollections.findByGenres(inputCollection, inputGenres));
	}

	@Test
	public void sortByTitleTest () {
		Collection<Book> inputCollection = createBookCollection();
		Collection<Book> expectedOutputCollection = createSortedByTitleBookCollection();
		Assert.assertEquals(expectedOutputCollection, BookCollections.sortByTitle(inputCollection));
	}

	@Test
	public void sortByAuthorAndTitleTest () {

	}

	@Test
	public void genresMapTest () {

	}

	@Test
	public void sortByAuthorFirstAndLastNameTest () {

	}

	@Test
	public void authorsMapTest () {

	}

	@Test
	public void authorsBookCountMapTest () {
		Collection<Book> inputCollection = createBookCollection();
		Map<Person, Integer> expectedOutputMap = new HashMap<>();
		expectedOutputMap.put(new Person("Joanne", "Rowling", 50, Gender.FEMALE), 7);
		expectedOutputMap.put(new Person("Robert", "Martin", 70, Gender.MALE), 2);
		expectedOutputMap.put(new Person("Andrzej", "Sapkowski", 55, Gender.MALE), 8);
		expectedOutputMap.put(new Person("Andrew", "Hunt", 67, Gender.MALE), 1);
		expectedOutputMap.put(new Person("Philip", "Zimbardo", 72, Gender.MALE), 1);
		Assert.assertEquals(expectedOutputMap, BookCollections.authorsBookCountMap(inputCollection));
	}

	@Test
	public void booksCountTest () {
		Collection<Book> inputCollection = createBookCollection();
		Person inputPerson = new Person("Joanne", "Rowling", 50, Gender.FEMALE);
		Assert.assertEquals(7, BookCollections.booksCount(inputCollection, inputPerson));
		Assert.assertEquals(15, BookCollections.booksCount(inputCollection, Genre.FANTASY));
		Assert.assertEquals(4, BookCollections.booksCount(inputCollection, Genre.NON_FICTION));
		Assert.assertEquals(7, BookCollections.booksCount(inputCollection, Genre.HORROR));
		Assert.assertEquals(8, BookCollections.booksCount(inputCollection, Genre.TRAGICOMEDY));
	}

	@Test
	public void bestAuthorTest () {
		Collection<Book> inputCollection = createBookCollection();
		Person expectedBestAuthor = new Person("Andrzej", "Sapkowski", 55, Gender.MALE);
		Assert.assertEquals(expectedBestAuthor, BookCollections.bestAuthor(inputCollection));
	}

	@Test
	public void mostPopularGenreTest() {
		Collection<Book> inputCollection = createBookCollection();
		Assert.assertEquals(Genre.ROMANTIC, BookCollections.mostPopularGenre(inputCollection));
	}
}
