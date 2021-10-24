package gridTraveler;

public class VanillaGridTraveler {
    public static void main(String args[]) {
        VanillaGridTraveler vanillaGridTraveler = new VanillaGridTraveler();
        System.out.println(vanillaGridTraveler.gridTraveler(7,8));;
    }

    long gridTraveler(int row, int col) {
        if(row == 0 || col == 0) return 0; //invalid grid
        if(row == 1 && col == 1) return 1; //positive base case
        return gridTraveler(row-1, col) + gridTraveler(row, col-1);
    }
}
