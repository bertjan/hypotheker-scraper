package nl.revolution.hypotheker.scraper;

import java.io.IOException;
import java.time.LocalDate;


public class Example {

    public static void main(String... args) throws IOException {
        Residence inputResidence = new Residence()
                .withPostalCode("3512 JC")
                .withHouseNumber("1")
                .withResidenceType("1")
                .withConstructionYear(2010)
                .withParcelSurface(100)
                .withFloorSurface(100)
                .withVolume(250)
                .withPercentageBuiltUp(50)
                .withMonument(false)
                .withDate(LocalDate.now().toString()); // should be current date, format "2017-01-01"
                // .withTaxationValue("200000")
                // .withTaxationDate("2017-01-01") // format "2017-01-01"
                // .withRebuildValue(20000);

        HypothekerService hypothekerService = new HypothekerService();
        Residence residence = hypothekerService.calculateResidenceValue(inputResidence);

        if (!residence.getMessages().isEmpty()) {
            System.out.println(residence.getMessages());
        }

        System.out.println(LocalDate.now() + "|ResidenceValue:" + residence.getResidenceValue() + "|IndexationValue:" + residence.getIndexationValue());
    }
}
