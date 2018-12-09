package steps;

import pages.BaggagePage;

public class BaggagePageSteps {
    private final BaggagePage baggagePage;

    public BaggagePageSteps(BaggagePage baggagePage) {
        this.baggagePage = baggagePage;
    }

    public void inputData(String departureCity, String arrivalCity, int classNumber, int membership) {
        baggagePage.inputDeparture(departureCity)
                .inputArrival(arrivalCity)
                .inputClass(classNumber)
                .inputMembership(membership)
                .search();
    }

    public String getBaggageWeight() {
        return baggagePage.getBaggageWeight();
    }
}
