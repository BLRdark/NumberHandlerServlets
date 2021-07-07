package com.web.handler;

import com.sun.xml.internal.ws.handler.HandlerException;
import exception.CharException;
import exception.DoubleException;
import exception.EmptyStringException;
import exception.StringException;

import java.util.Scanner;

public class TextFormatter implements Handler {
    @Override
    public void handle(String string) throws Exception{

        if (string.length() == 1) {
            try {
                Integer.parseInt(string);
            } catch (Exception e) {
                throw new CharException();
            }
        } else{
            try{
                Integer.parseInt(string);
            }catch (Exception e){
                if (string.length() == 0) {
                    throw new EmptyStringException();
                } else if (new Scanner(string).hasNextDouble()) {
                    throw new DoubleException();
                } else if (new Scanner(string).hasNextLine()) {
                    throw new StringException();
                }
            }
        }
    }
}
