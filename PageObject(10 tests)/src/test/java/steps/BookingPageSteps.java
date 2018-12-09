package steps;

import pages.BookingPage;

public class BookingPageSteps {

    private final BookingPage bookpage;

    public BookingPageSteps(BookingPage page){ bookpage = page;}

    public String checkCityName(){
        return bookpage.getCityName();
    }
}
