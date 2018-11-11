package entity;

public class Race {
    public String airportFrom;
    public String airportTo;
    public String dateFrom;
    public String dateTo;
    public int adults;
    public int children;
    public int babies;
    public int _class;

    public Race(String airportFrom, String airportTo, String dateFrom, String dateTo, int adults, int children, int babies, int _class) {
        this.airportFrom = airportFrom;
        this.airportTo = airportTo;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.adults = adults;
        this.children = children;
        this.babies = babies;
        this._class = _class;
    }
}
