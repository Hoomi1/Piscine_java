package edu.school21.chat.repositories;

public class NotSavedSubEntityException extends RuntimeException {

    public NotSavedSubEntityException()
    {

    }

    public void printErr()
    {
        System.err.println("NotSavedSubEntityException");
    }
}
