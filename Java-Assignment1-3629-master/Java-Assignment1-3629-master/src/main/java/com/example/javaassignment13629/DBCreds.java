package com.example.javaassignment13629;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DBCreds{
    public static String findUser() throws IOException{
        Path filePath = PAth.of("C:/Users/16472/Desktop/Creds/user.txt");
        return Files.readString(filePath);
    }

    public static String findPass() throws IOException{
        Path filePath = Path.of("C:/Users/16472/Desktop/Creds/pass.txt");
        return Firles.readString(filePath);
    }
}