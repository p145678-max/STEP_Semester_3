class LibraryBook {
    String title;
    String isbn;

    LibraryBook(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    LibraryBook(String title) {
        this(title, "PENDING");
    }

    void printStatus() {
        if (isbn.equals("PENDING")) {
            System.out.println(title + " | ISBN: PENDING");
        } else {
            System.out.println(title + " | ISBN: " + isbn);
        }
    }
}

public class LibraryBookCataloguing {
    public static void main(String[] args) {
        String[] titles = {"Clean Code", "Untitled Draft", "1984", "Notes"};
        String[] isbns = {"9780132350884", "", "9780451524935", ""};

        for (int i = 0; i < titles.length; i++) {
            LibraryBook book;

            if (isbns[i].equals("")) {
                book = new LibraryBook(titles[i]);
            } else {
                book = new LibraryBook(titles[i], isbns[i]);
            }

            book.printStatus();
        }
    }
}
