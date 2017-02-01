package nl.revolution.hypotheker.scraper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Residence {

    private static ObjectMapper MAPPER;

    static {
        MAPPER = new ObjectMapper();
        MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    @JsonProperty(value = "PostalCode")
    private String postalCode;

    @JsonProperty(value = "HouseNumber")
    private String houseNumber;

    @JsonProperty(value = "HouseNumberPostfix")
    private String houseNumberPostfix;

    /*
    0: Tussenwoning
    1: Appartement
    2: Hoekwoning
    3: 2 onder 1 kap
    4: Vrijstaande woning
    5: Overig
    */
    @JsonProperty(value = "ResidenceType")
    private String residenceType;

    @JsonProperty(value = "ConstructionYear")
    private int constructionYear;

    @JsonProperty(value = "ParcelSurface")
    private int parcelSurface;

    @JsonProperty(value = "PercentageBuiltUp")
    private int percentageBuiltUp;

    @JsonProperty(value = "Volume")
    private int volume;

    @JsonProperty(value = "FloorSurface")
    private int floorSurface;

    @JsonProperty(value = "IsMonument")
    private boolean isMonument;

    @JsonProperty(value = "Date") // format: "2017-01-01"
    private String date;

    @JsonProperty(value = "ResidenceValueId")
    private String residenceValueId;

    @JsonProperty(value = "City")
    private String city;

    @JsonProperty(value = "Street")
    private String street;

    @JsonProperty(value = "TaxationDate") // format: "2017-01-01"
    private String taxationDate;

    @JsonProperty(value = "TaxationValue")
    private String taxationValue;

    @JsonProperty(value = "RebuildValue")
    private long rebuildValue;

    @JsonProperty(value = "ResidenceValue")
    private long residenceValue;

    @JsonProperty(value = "IndexationValue")
    private long indexationValue;

    @JsonProperty(value = "Messages")
    private List<Map> messages;

    @JsonProperty(value = "HasErrorMessage")
    private boolean hasErrorMessage;

    public String toString() {
        try {
            return toJSON();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public String toJSON() throws JsonProcessingException {
        return MAPPER.writeValueAsString(this);
    }

    public static Residence fromJSON(String json) throws IOException {
        return MAPPER.readValue(json, Residence.class);
    }

    public Residence withPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public Residence withHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public Residence withHouseNumberPostfix(String houseNumberPostfix) {
        this.houseNumberPostfix = houseNumberPostfix;
        return this;
    }

    public Residence withResidenceType(String residenceType) {
        this.residenceType = residenceType;
        return this;
    }

    public Residence withConstructionYear(int constructionYear) {
        this.constructionYear = constructionYear;
        return this;
    }

    public Residence withParcelSurface(int parcelSurface) {
        this.parcelSurface = parcelSurface;
        return this;
    }

    public Residence withPercentageBuiltUp(int percentageBuiltUp) {
        this.percentageBuiltUp = percentageBuiltUp;
        return this;
    }

    public Residence withVolume(int volume) {
        this.volume = volume;
        return this;
    }

    public Residence withFloorSurface(int floorSurface) {
        this.floorSurface = floorSurface;
        return this;
    }

    public Residence withMonument(boolean monument) {
        isMonument = monument;
        return this;
    }

    public Residence withDate(String date) {
        this.date = date;
        return this;
    }

    public Residence withTaxationDate(String taxationDate) {
        this.taxationDate = taxationDate;
        return this;
    }

    public Residence withTaxationValue(String taxationValue) {
        this.taxationValue = taxationValue;
        return this;
    }

    public Residence withRebuildValue(long rebuildValue) {
        this.rebuildValue = rebuildValue;
        return this;
    }

    public Residence withResidenceValueId(String residenceValueId) {
        this.residenceValueId = residenceValueId;
        return this;
    }

    public Residence withCity(String city) {
        this.city = city;
        return this;
    }

    public Residence withStreet(String street) {
        this.street = street;
        return this;
    }

    public Residence withResidenceValue(long residenceValue) {
        this.residenceValue = residenceValue;
        return this;
    }

    public Residence withIndexationValue(long indexationValue) {
        this.indexationValue = indexationValue;
        return this;
    }

    public long getResidenceValue() {
        return residenceValue;
    }

    public long getIndexationValue() {
        return indexationValue;
    }

    public List<Map> getMessages() {
        return messages;
    }

}
