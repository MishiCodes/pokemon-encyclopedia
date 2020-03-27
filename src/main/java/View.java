/**
 * This class represents an user interface.
 */
public class View {

    /**
     * Constructor of View class.
     */
    public View(){
    }

    /**
     * Print out a Welcome message to the user.
     */
    public void showWelcomeMessage() {
        System.out.println("Welcome to Pokemon encyclopedia\n");
    }

    /**
     * Print main menu.
     */
    public void showMainMenu(){
        System.out.println("Pick an option:");
        String[] actions = {"(1) Search a Pokemon (e.g vaporeon)", "(2) Search a Location (e.g saffron city)", "(3) Search a Pokemon type (e.g water)",
                "(4) Quit"};
        for (int i = 0; i < actions.length; i++) {
            System.out.println(actions[i]);
        }
    }

    /**
     * Print a message asking for any input to return to the main menu.
     */
    public void showReturnMessage() {
        System.out.println("Please, press Enter to return to the menu");
    }

    /**
     * Print a message for user to insert a pokemon name.
     */
    public void showSearchPokemonMessage() {
        System.out.println("Enter a pokemon name:");
    }

    /**
     * Print the searched pokemon.
     */
    public void showPokemonName(String pokemon) {
        System.out.println(pokemon);
    }

    /**
     * Print a message for user to insert a type name.
     */
    public void showSearchPokemonTypeMessage() {
        System.out.println("Enter a pokemon type:");
    }

    /**
     * Print the searched type.
     */
    public void showPokemonType(String type) {
        System.out.println(type);
    }

    /**
     * Print a message for user to insert a location name.
     */
    public void showSearchLocationMessage() {
        System.out.println("Enter a location name:");
    }

    /**
     * Print the searched location.
     */
    public void showLocation(String location) {
        System.out.println("Location Name = " + location);
    }

    /**
     * Print the location region.
     */
    public void showLocationRegion(String region) {
        System.out.println("Region = " + region);
    }

    /**
     * Print a message stating that the input was valid.
     */
    public void showInvalidInputMessage() {
        System.out.println("Invalid input.");
    }

    /**
     * Print a message saying that Type wasn't found.
     */
    public void shoeTypeNotFoundMessage() {
        System.out.println("Type not found. Did you enter a valid type?");
    }

    /**
     * Print a message saying that Location wasn't found.
     */
    public void printNoLocationFound() {
        System.out.println("Location not found. Did you enter the correct location name?");
    }

    /**
     * Print a message saying that Pokemon wasn't found.
     */
    public void showPokemonNotFoundMessage() {
        System.out.println("Pokemon not found. Did you enter the correct pokemon name?");
    }

    /**
     * Print a message saying what is the type of the Pokemon and its damage levels.
     */
    public void showPokemonTypeMessage(String type) {
        System.out.println("\'" + type + "\' type properties:");
    }
}