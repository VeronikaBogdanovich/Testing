package steps;

import pages.MainPage;

public class MainPageSteps {
    MainPage mainPage;

    public MainPageSteps(MainPage page) {
        mainPage = page;
    }

    public String checkMaxCountOfBabies(int babiesTimees) {
        return mainPage.clickToContinue()
                .openNewPassengerDropdown()
                .addInfants(babiesTimees)
                .getBabiesError();
    }

    public String enterWithNotValidAriport(){
        return mainPage.enterAirports("Veronika", "Veronika")
                .getAirportError();
    }

    public String checkWhatHappenWhenEnterSpecialSymbols(){
        return mainPage.goToManageTab()
                .enterLastName()
                .getLastNameError();
    }

    public String checkWhatHappenWhenAllFieldsAreEmpty() {
        return mainPage.clickToContinue()
                .searchRaces()
                .getEmptyFieldsError();
    }

    public String checkStatusOfFlights(){
        return mainPage.goToStatusTab()
                .chooseTypeOfEnter()
                .goToEnterNumber()
                .enterNumber("1234")
                .goToPageWithStatus()
                .getStatusError();
    }

    public String checkMaxCountOfPassengers(){
        return mainPage.clickToContinue()
                .openNewPassengerDropdown()
                .addPassengers(12)
                .getValueError();
    }

    public String enterDepartureDateWhichLaterThanReturnDate() {
        return mainPage.clickToContinue()
                .addReturningDate(1)
                .addDepartingDate(2)
                .getDateError();
    }


    public void goToHotelsPage() {
        mainPage.openHotelBooking();
    }

    public void goToBaggagePage() {
        mainPage.openManageMenu()
                .openManageBaggageMenu()
                .openBaggageCalculator();
    }

    public void goToRentalPage(){
        mainPage.openCarRental();
    }

}
