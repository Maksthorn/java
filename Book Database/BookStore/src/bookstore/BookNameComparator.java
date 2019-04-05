package bookstore;
import java.util.*;

 class BookNameComparator implements Comparator<Book>{

	@Override
	public int compare(Book b1 , Book b2){
		return b1.getName().compareTo(b2.getName());// compares 2 book objs by name


		}


}