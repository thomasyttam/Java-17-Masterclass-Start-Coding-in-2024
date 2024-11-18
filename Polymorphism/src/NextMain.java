public class NextMain {

    public static void main(String[] args) {

        Movie movie = Movie.getMovie("A", "Jaws");
        movie.watchMovie();

        // Below cannot work as cannot cast class Comedy to class Adventure
        // Adventure jaws = (Adventure) Movie.getMovie("C", "Jaws");
        Adventure jaws = (Adventure) Movie.getMovie("A", "Jaws");
        movie.watchMovie();

        Object comedy = Movie.getMovie("C", "Airplane");
        // Movie comedyMovie = (Movie)comedy;
        Comedy comedyMovie = (Comedy)comedy;
        comedyMovie.watchComedy();

        var airplane = Movie.getMovie("C", "Aeroplane");
        airplane.watchMovie();

        var plane = new Comedy("New Airplane");
        plane.watchComedy();


        // check the class before casting
        Object unknownObject = Movie.getMovie("S", "Airplane");
        if(unknownObject.getClass().getSimpleName() == "Comedy") {
            Comedy c = (Comedy)unknownObject;
            c.watchComedy();
        } else if (unknownObject instanceof Adventure){
            ((Adventure)unknownObject).watchAdventure();
        } else if (unknownObject instanceof ScienceFiction syfy) {
            syfy.watchScienceFiction();
        }
    }
}
