package bookstore;
public  class LibraryItem{
    
        //data decleration
        //private members can only be accesses within the same class in which they are declared
        private String ISBN;
        private int id;
        private String Date;
        private String borrowed;
        private String subject;
        private String author;
        private String publisher;
        private String name;
        private String language;
        public String strDisplay=  "Text from LibraryItem class";
        private int month;
        private int due;

        //default constructor
        LibraryItem(){
                        System.out.println("Super calling parent constructor");
                }

        //overloaded constructor expecting 6 string values and an int
        //LibraryItem 2
        //called by super in
        LibraryItem(String name,String publisher,String author,String subject,String borrowed,String ISBN,int id){

                this.id = id;
                this.ISBN = ISBN;
                this.borrowed = borrowed;
                this.subject = subject;
                this.author = author;
                this.publisher = publisher;
                this.name = name;

                }

        public void display() {
                        System.out.println("\nItem name is :" + getName() + "\nof id : " + getID());
                }
        
        public void setName(String name){
                        this.name = name;
                }

        public String getName(){
                        return name;
                }

        
       public void setLanguage(String language){
                       this.language = language;
               }

       public String getLanguage(){
                       return language;
               }

        
        public void setISBN(String ISBN){
                        this.ISBN = ISBN;
                }

        public String getISBN(){
                        return ISBN;
                }

     
        public void setSubject(String subject){
                        this.subject = subject;
        }

        public  String getSubject(){
                        return subject;
        }

       
        public void setAuthor(String author){
                        this.author = author;
                }

        public String getAuthor(){
                        return author;
                }

        public void setPublisher(String publisher){
                        this.publisher = publisher;
                }

        public String getPublisher(){
                        return publisher;
                }

        public int getID(){
                return id;
        }

        @Override
        public String toString(){
                return"\nbarcode:"+ ISBN +"\nID :"+ id +"\nSubject :"+ subject +"\nAuthor :"+ author+"\nPublisher :"+publisher+"\nName :"+name;
}


}