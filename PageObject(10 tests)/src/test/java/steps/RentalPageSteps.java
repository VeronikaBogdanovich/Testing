package steps;

import pages.RentalPage;

public class RentalPageSteps {

    private final RentalPage rentalPage;

    public RentalPageSteps(RentalPage page) {
        rentalPage = page;
    }


    public String checkLocation() {
        return rentalPage.enterCity("86100 Châtellerault, France")
                .enterPickUpDate(30)
                .enterReturnDate(45)
                .clickToSearch()
                .getError();
    }
}
