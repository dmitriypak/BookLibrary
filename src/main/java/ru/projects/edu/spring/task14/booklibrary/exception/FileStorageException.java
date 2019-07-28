package ru.projects.edu.spring.task14.booklibrary.exception;

public class FileStorageException extends RuntimeException{

    public FileStorageException(String msg) {
        super(msg);
    }

    public FileStorageException(String msg, Throwable t) {
        super(msg, t);
    }
}
