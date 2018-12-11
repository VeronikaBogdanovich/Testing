package steps;

import pages.HotelsPage;

public class HotelsPageSteps {

    private final HotelsPage hotelsPage;

    public HotelsPageSteps(HotelsPage page) {
        hotelsPage = page;
    }

    public void findHotel(String name){
        hotelsPage.enterCity(name)
                .findHotels();
    }
}
