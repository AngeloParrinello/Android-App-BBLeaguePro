package DataBase;

public enum EventType {
    TOUCHDOWN ("TD"),
    CASUALITY ("CS"),
    PASS ("PS");

    private String abbr;

    EventType(String td) {
        this.abbr = td;
    }

    @Override
    public String toString() {
        return this.abbr;
    }

    public boolean checkString(String string){
        boolean check = false;
        for (EventType enumino : EventType.values()) {
            if (string.toUpperCase() == enumino.toString()) {
                check = true;
                break;
            }
        }
        return check;
    }

}


