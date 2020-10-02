package com.squareup.tape;

import java.io.File;
import java.io.IOException;

public class FileException extends RuntimeException {
    public FileException(String str, IOException iOException, File file) {
        super(str, iOException);
    }
}
