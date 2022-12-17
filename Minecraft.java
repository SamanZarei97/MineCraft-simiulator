/**
 * Name : Saman Zarei
 * This program is Minecraft simulations with new rules. What we need to do
 * in this game, is rotating our home which is created from group numbers
 * of rows and columns 90 degree. Also we need to search if there is any
 * infected Mob in the village, and based on that we need to identify which
 * Mobs need to be tested if they were in contact with the infected Mob.
 */

import java.util.ArrayList;

/**
 * This class has designed to rotate the group numbers of rows and
 * culomns 90 degree and also to identify the mobs that were in contact with
 * infected mob and need to be tested.
 * @author Saman Zarei
 */

public class Minecraft{

  /**
   * This method has designed to rotate the group numbers of rows and culomns
   * 90 degree and return the rotated group.
   * @param originalFloorPlan the 2D array contains group of numbers to rotate
   * @return returns the rotated group of numbers in terms of 2D array
   */
  public static int[][] rotateFloorPlan(int[][] originalFloorPlan){

    // The method returns null if originalFloorPlan is null.
    if(originalFloorPlan == null){
      return null;
    }

    // The rotated 2D array which is group of number that we need to return.
    int [][] rotatedArray = new int [originalFloorPlan[0].length]
    [originalFloorPlan.length];

    // Toward the nested loop to rotate the group of numbers 90 degree
    for(int i = 0; i < originalFloorPlan[0].length; i++){

      for(int j = 0; j < originalFloorPlan.length; j++ ){

        // Getting the rotated group of numbers 90 degree.
        rotatedArray[i][j] = originalFloorPlan[originalFloorPlan.length-1-j]
        [i];
      }
    }

    return rotatedArray;
  }

  /**
   * This method has designed to identify the infected mob, and based on that,
   * it identifies the mobs that were in contact with the infected mob to
   * be tested. Then, it returns the mobs that need to be tested since they
   * were in contact with the infected mob.
   * @param groups The 2D array that contains the groups of mobs.
   * @param infected The String that shows the infected mob.
   * @return returns the ArrayList that contains the mobs that were in
   * contact with the infected mob and need to be tested.
   */
  public static ArrayList<String> getMobsToTest(String[][] groups,
  String infected){

    // If any parameter is null, we have to return null.
    if(groups == null || infected == null ){
      return null;
    }
    // List of mobs were in contact with the infected one and need to test
    ArrayList<String> mobs = new ArrayList<String>();

    // Toward the nested loop to determine the mobs that need to be tested
    for(int i = 0; i < groups.length; i++){

      if(groups[i] == null){
        continue;
      }
      for(int j = 0; j < groups[i].length; j++){

        // Skipping any element of the array that is null.
        if(groups[i][j] == null){
          continue;
        }

        /*
         * Here the if statement checks to find the infected mob and after
         * it checks any row that the infected mob exists in it to identify
         * the mobs that need to be tested. So if the mobs are not the
         * infected mob and are not null, they will add in the Mobs list that
         * need to be tested.
         */
        if(groups[i][j].equals(infected) ){

          // Checking the row that conitans infected mob.
          for(int k = 0; k < groups[i].length; k++){

            // Checking to make sure founded mobs are not null or infcted one
            if(groups[i][k] != null && !groups[i][k].equals(infected) ){

              // Adding the mobs that are in the same row with infected mob.
              mobs.add(groups[i][k]);
            }
          }
        }
      }
    }

    // Toward the nested loop to remove any duplicate mob.
    for(int i = 0; i < mobs.size(); i++ ){

      for(int j = i + 1; j < mobs.size(); j++){

        // Comparing Mobs to remove one of them if they are same.
        if(mobs.get(i).equals(mobs.get(j) ) ){

          // Removing the duplicate Mob.
          mobs.remove(j);
          j--;
        }
      }
    }

    return mobs;
  }
}
