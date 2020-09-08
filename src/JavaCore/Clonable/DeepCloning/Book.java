package JavaCore.Clonable.DeepCloning;

class Book implements Cloneable{  // 1)нужно реализовать интрефейс Cloneable

    private String name;
    private Author author;

    public void setName(String n){
        name=n;
    }

    public String getName(){
        return name;
    }

    public void setAuthor(String n){
        author.setName(n);
    }

    public String getAuthor(){
        return author.getName();
    }

    Book(String name, String author){
        this.name = name;
        this.author = new Author(author);
    }

    public String toString(){
        return "Книга '" + name + "' (автор " +  author + ")";
    }

    //-----------------Method Clone---------------------------
    public Book clone() throws CloneNotSupportedException{  // 3)переопределить метод clone()
        Book newBook = (Book) super.clone();                // 4)новый обьект типа Book
        newBook.author = this.author.clone();               // 5)нужно клонированть каждую сслочную переменную (каждое поле)
        return newBook;
    }


    public static void main(String[] args) {
        try{
            Book book = new Book("War and Peace", "Leo Tolstoy");
            Book book2 = book.clone();
            book2.setAuthor("Ivan Turgenev");
            book2.setName("Mu-Mu");
            System.out.println("Автор изначальной книги: " + book.getAuthor() + " название произведения: " + book.getName());
            System.out.println("Автор клонированной книги: " + book2.getAuthor() + " название произведения: " + book2.getName());
        }
        catch(CloneNotSupportedException ex){

            System.out.println("Cloneable not implemented");
        }
    }

}



class Author implements Cloneable{  // 3)нужно реализовать интрефейс Cloneable

    private String name;

    public void setName(String n){
        name=n;
    }

    public String getName(){
        return name;
    }

    public Author(String name){
        this.name=name;
    }

    public Author clone() throws CloneNotSupportedException{
        return (Author) super.clone();
    }

}