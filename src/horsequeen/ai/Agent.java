package horsequeen.ai;

public class Agent {

    private Search search;

    public Agent(Search search) {
        this.search = search;
    }

    public void getNextAction(Enviroment enviroment) {
        search.nextAction(enviroment).execute();
    }

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }
}
