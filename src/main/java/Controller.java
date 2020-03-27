import pokemon.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the main class of the application.
 */
public class Controller {
    private View view;
    private JsonParser jsonParser;
    private Scanner scan;

    /**
     * Constructor of the Controller class.
     */
    public Controller() {
        view = new View();
        jsonParser= new JsonParser();
        scan = new Scanner(System.in);
    }

    /**
     * Method with the main routine that will keep program running
     * until user wants to quit.
     */
    public void start() {
        view.showWelcomeMessage();
        while (true) {
            view.showMainMenu();
            switch (userInput()) {
                case "1":
                    //Search a Pokemon
                    view.showSearchPokemonMessage();
                    searchPokemon(userInput());
                    break;
                case "2":
                    //Search a location
                    view.showSearchLocationMessage();
                    searchLocation(userInput());
                    break;
                case "3":
                    // Search a type
                    view.showSearchPokemonTypeMessage();
                    searchType(userInput());
                    break;
                case "4":
                    //quit
                    return;
                default:
                    view.showInvalidInputMessage();
            }
            view.showReturnMessage();
            userInput();
        }
    }

    /**
     * Method that allows user to search for Pokemons.
     * @param pokemon to be searched.
     */
    private void searchPokemon(String pokemon) {
        String response = RequestHandler.makeHTTPRequest("pokemon",
                pokemon.trim().replace(".","").replace(" ","-").toLowerCase());

        Pokemon pokemonFromApi = jsonParser.readJsonPokemon(response);

        if (pokemonFromApi != null){
            view.showPokemonName(pokemonFromApi.toString());
            //Print the type properties
            String type = pokemonFromApi.getPokemonType();
            view.showPokemonTypeMessage(type);
            searchType(type);
        }
        else{
            view.showPokemonNotFoundMessage();
        }
    }

    /**
     * Method that allows user to search for Locations.
     * @param location to be searched.
     */
    private void searchLocation(String location) {
        String response = RequestHandler.makeHTTPRequest("location",
                location.trim().replace(".","").replace(" ","-").toLowerCase());

        Location locationFromApi = jsonParser.readJsonLocations(response);

        if (locationFromApi != null){
            view.showLocationRegion(locationFromApi.getRegionOfLocation());
            locationFromApi.getLocationName().stream()
                    .forEach(locationFinal -> view.showLocation(locationFinal));
        }
        else{
            view.printNoLocationFound();
        }
    }

    /**
     * Method that allows user to search for pokemon types.
     * @param type to be searched.
     */
    private void searchType(String type) {
        String response = RequestHandler.makeHTTPRequest("type",
                type.trim().replace(".","").replace(" ","-").toLowerCase());

        ArrayList<Type> typeFromApi = jsonParser.readJsonPokemonType(response);

        if (typeFromApi != null){
            typeFromApi.stream()
                        .forEach(typeFinal -> view.showPokemonType(typeFinal.toString()));
        }
        else{
            view.shoeTypeNotFoundMessage();
        }
    }

    /**
     * Collect user input.
     * @return user input as a String.
     */
    public String userInput() {
        return scan.nextLine();
    }

}