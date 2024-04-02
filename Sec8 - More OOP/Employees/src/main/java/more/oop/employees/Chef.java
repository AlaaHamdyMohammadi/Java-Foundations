package more.oop.employees;

public interface Chef {

    String favoriteFood = "hamburger";
    default void cook(String food){
        System.out.println("cooking " + food);
    }
    default String cleanUp(){
        return "cleaning Up";
    }

    default String getFavoriteFood(){
        return favoriteFood;
    }


}
