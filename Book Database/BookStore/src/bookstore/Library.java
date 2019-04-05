
package bookstore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Library {

private String libName;
private ArrayList<Book> Books; // Links Book to Library
//creates aggregation relationship between library and book
//an aggregation relationship is like an association except its 1 directional


private int noOfBooks;  //this variable is used to store how many book objects are in the Library at a given time

	//library class  contains list of book objs
	//its associated with the book class through its objs
	public Library(String libName,ArrayList<Book> Books){

			this.libName = libName;
			this.Books = Books;
		}
	// returns

   

	public ArrayList<Book> getBooks(){
			return Books;
		}

        public  Library(){}

	//overloaded constructor is expecting an arraylist of type Book
	public Library(ArrayList<Book> b){

			Books = b;//copy the ArrayList parameter b to the Books ArrayList
			for(Book book : Books){//loop around the Books arrayList and keep store in the noOfBooks variable how many Book objects it contains
				noOfBooks++;
				}
		}



        public void addBook(Book b){ //check to this class to ensure that if the Library already contains the book that is being added it so it does not add a duplicate

            if(Books.contains(b)){
                   System.out.println("Book " + b.getName() + " is already in library");
                   }else{
                        Books.add(b);
                        noOfBooks++;
                    }
        }   

        public void removeBook(Book b){//put
            Books.remove(b);
            noOfBooks--;
        }



        public int showNoOfBooks(){//put
            return noOfBooks;
        }



        //accessors (get) & mutators (put) methods
        public void setLibname(String libName){
                        this.libName = libName;
        }

        public String getLibname(){
                return libName;
        }



      


     	public void displayBookAlphabetically(){
		 //calls the collections frame work and uses the sort method with
		 //Books array and an object of BookNameComparator that overrides the compare method

			Collections.sort(Books, new BookNameComparator());
			//for each book obj sotred under ref aBook in array Books
			for(Book aBook : Books){
					//print out this with data ref using .getName() method
					System.out.println("DisplayBooksAlpha method : " + aBook.getName());
				}

		 }

        @Override
        public String toString(){
                String returnString = "";
                for(Book book : Books){
                   returnString += book.toString() + "\n";
                }
                return returnString;

    }


}