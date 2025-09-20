import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

class Food {
    String cuisine;
    int rating;

    public Food(String cuisine, int rating) {
        this.cuisine = cuisine;
        this.rating = rating;
    }

    public String getCuisine() {
        return cuisine;
    }

    public int getRating() {
        return rating;
    }

    public void updateRating(int rating) {
        this.rating = rating;
    }
}

class FoodRatings {

    HashMap<String, PriorityQueue<String>> cuisineMap = new HashMap<>();
    HashMap<String, Food> foodMap = new HashMap<>();

    Comparator<String> cmp = (a, b) -> {
        int diff = foodMap.get(b).getRating() - foodMap.get(a).getRating();
        if (diff == 0) {
            return a.compareTo(b);
        }
        return diff;
    };

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            foodMap.put(foods[i], new Food(cuisines[i], ratings[i]));
            if (cuisineMap.containsKey(cuisines[i])) {
                cuisineMap.get(cuisines[i]).offer(foods[i]);
            } else {
                PriorityQueue<String> queue = new PriorityQueue<>(cmp);
                queue.offer(foods[i]);
                cuisineMap.put(cuisines[i], queue);
            }
        }
    }

    public void changeRating(String food, int newRating) {
        foodMap.get(food).updateRating(newRating);
        PriorityQueue<String> current = cuisineMap.get(foodMap.get(food).cuisine);
        current.remove(food);
        current.offer(food);
    }

    public String highestRated(String cuisine) {
        return cuisineMap.get(cuisine).peek();
    }
}

public class lc_2353 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String[] foods = new String[n];
        String[] cuisines = new String[n];
        int[] ratings = new int[n];

        FoodRatings foodsAndRatings = new FoodRatings(foods, cuisines, ratings);
        System.out.println(foodsAndRatings.highestRated("sushi"));
        input.close();
    }
}
