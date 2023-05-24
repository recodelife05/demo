package com.example.demo;

import java.util.stream.Stream;

public class LibraryMainScreen implements ILibraryMainScreen {

    public void DisplayMainScreen(){
        LibraryActions.stream().
                forEach(r -> System.out.println("Press <" + r.getIdentifier() + "> to " + r.description));
    }
    public void DisplayEndScreen() {
        System.out.println("Thank you for using our Library System.");
    }
    public void DisplayInvalidScreen(){
        System.out.println("Please enter correct choice.");
    }
    @Override
    public void DisplayErrorScreen() { System.out.println("Something went wrong."); }

    enum LibraryActions {
        ADDBOOK('A',"Add a Book"),
        BORROWBOOK('B',"Borrow a Book"),
        RETURNEDBOOK('C',"Return a Book"),
        REMOVEDBOOK('D',"Removed a Book"),
        LISTRETURNEDBOOKS('E',"List of Books Returned/Shelf"),
        LISTOFBORROWEDBOOKS('F',"List of Borrowed Books"),
        DISPLAYALLBOOKS('G',"List of All Books"),
        EXITPROGRAM('X',"Exit Program");
        LibraryActions(Character identifier,String description){
            this.identifier = identifier;
            this.description = description;
        };
        private Character identifier;
        private String description;
        public Character getIdentifier(){
            return  identifier;
        }

        public static Stream<LibraryActions> stream() {
            return Stream.of(LibraryActions.values());
        }

    }
}
