import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



public class BookAuthorDemo {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CAP-DB");
		EntityManager entityManager = factory.createEntityManager();
		Author author=new Author();
		author.setId(101);
		author.setName("Stephen King");
		
		Book book1=new Book();
		book1.setISBN(1001);
		book1.setTitle("The Stand");
		book1.setPrice(1000);
		;
		
		Book book2=new Book();
		book2.setISBN(1002);
		book2.setTitle("The Shining");
		book2.setPrice(2000);
		
		
		Book book3=new Book();
		book3.setISBN(1003);
		book3.setTitle("The Outsider");
		book3.setPrice(800);
		
		
		Book book4=new Book();
		book4.setISBN(1004);
		book4.setTitle("Doctor Sleep");
		book4.setPrice(1500);
		
		
		Set<Book> books = new HashSet<>();
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		author.setBook(books);
		
		EntityTransaction txn = entityManager.getTransaction();
		txn.begin();
		entityManager.persist(author);
		txn.commit();
		entityManager.close();		
		factory.close();

	}

}