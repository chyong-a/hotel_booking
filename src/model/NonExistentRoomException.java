package model;

public class NonExistentRoomException extends Exception{
    public NonExistentRoomException(String errorMessage){
        super(errorMessage);
    }
}
