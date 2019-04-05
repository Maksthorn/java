package bookstore;

/**
 *
 * @author Grim
 */
public class Book extends LibraryItem{
									
            Book(){}

            public Book(String name,String publisher,String author,String subject,String borrowed,String ISBN,int ID,String language){
                            super(name,publisher, author,subject,borrowed,ISBN,ID);
                    }

            //name override  method
             public void display() {
                                    super.display();
                            }


            public int compareTo(Book b){
                            return (b.getName().compareTo(this.getName()));
				}

}